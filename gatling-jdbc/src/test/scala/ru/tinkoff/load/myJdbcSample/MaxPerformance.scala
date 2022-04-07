package ru.tinkoff.load.myJdbcSample

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import ru.tinkoff.load.myJdbcSample.scenarios.CommonScenario
import ru.tinkoff.load.jdbc.Predef._

class MaxPerformance extends Simulation with Annotations {

  setUp(
    new CommonScenario().createTableScn.inject(atOnceUsers(1))
      .andThen(
        new CommonScenario().insertInTable.inject(
          incrementUsersPerSec((intensity / stagesNumber).toInt) // интенсивность на ступень
            .times(stagesNumber)                                 // Количество ступеней
            .eachLevelLasting(stageDuration)                     // Длительность полки
            .separatedByRampsLasting(rampDuration)               // Длительность разгона
            .startingFrom(0),                                    // Начало нагрузки с
        ),
      )).protocols(jdbcProtocol)
    .maxDuration(testDuration)                               // общая длительность теста

}
