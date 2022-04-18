package ru.tinkoff.load.myRabbitmq

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import ru.tinkoff.load.myRabbitmq.scenarios.CommonScenario
import ru.tinkoff.gatling.amqp.Predef._

class MaxPerformance extends Simulation with Annotations {

  setUp(
    CommonScenario().inject(
      incrementUsersPerSec((intensity / stagesNumber).toInt) // интенсивность на ступень
        .times(stagesNumber)                                 // Количество ступеней
        .eachLevelLasting(stageDuration)                     // Длительность полки
        .separatedByRampsLasting(rampDuration)               // Длительность разгона
        .startingFrom(0),                                    // Начало нагрузки с
    ),
  ).protocols(amqpConf)
    .maxDuration(testDuration)                               // общая длительность теста

}
