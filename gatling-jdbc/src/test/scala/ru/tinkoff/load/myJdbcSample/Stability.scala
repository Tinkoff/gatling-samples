package ru.tinkoff.load.myJdbcSample

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import ru.tinkoff.load.myJdbcSample.scenarios.CommonScenario
import ru.tinkoff.load.jdbc.Predef._

class Stability extends Simulation with Annotations {

  setUp(
    CommonScenario().inject(
      // Плавное увеличение нагрузки до целевого значения
      rampUsersPerSec(0) to intensity.toInt during rampDuration,
      // Длительность полки
      constantUsersPerSec(intensity.toInt) during stageDuration,
    ),
    // Указываем протокол
  ).protocols(jdbcProtocol)
    // Общая длительность теста
    .maxDuration(testDuration)

}
