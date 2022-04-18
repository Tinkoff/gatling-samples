package ru.tinkoff.load.mygrpc

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import ru.tinkoff.load.mygrpc.scenarios.CommonScenario

class MaxPerformance extends Simulation with Annotations {

  setUp(
    new CommonScenario().unaryRpcScenario.inject(
      incrementUsersPerSec((intensity / stagesNumber).toInt) // интенсивность на ступень
        .times(stagesNumber)                                 // Количество ступеней
        .eachLevelLasting(stageDuration)                     // Длительность полки
        .separatedByRampsLasting(rampDuration)               // Длительность разгона
        .startingFrom(0),                                    // Начало нагрузки с
    ),
    new CommonScenario().clientStreamScenario.inject(
      incrementUsersPerSec((intensity / stagesNumber).toInt) // интенсивность на ступень
        .times(stagesNumber)                                 // Количество ступеней
        .eachLevelLasting(stageDuration)                     // Длительность полки
        .separatedByRampsLasting(rampDuration)               // Длительность разгона
        .startingFrom(0),                                    // Начало нагрузки с
    ),
  ).protocols(grpcProtocol)
    .maxDuration(testDuration) // общая длительность теста

}
