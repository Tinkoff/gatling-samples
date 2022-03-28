package ru.tinkoff.load.myhttpservice

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import ru.tinkoff.load.myhttpservice.scenarios.CommonScenario

class MaxPerformance extends Simulation with Annotations {

  setUp(
    CommonScenario().inject(
      // Интенсивность на ступень
      incrementUsersPerSec((intensity / stagesNumber).toInt)
        // Количество ступеней
        .times(stagesNumber)
        // Длительность полки
        .eachLevelLasting(stageDuration)
        // Длительность разгона
        .separatedByRampsLasting(rampDuration)
        // Начало нагрузки с
        .startingFrom(0)
    )
  ).protocols(httpProtocol)
    // Общая длительность теста
    .maxDuration(testDuration)

}
