package ru.tinkoff.load.mygrpc

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import ru.tinkoff.load.mygrpc.scenarios.CommonScenario

class Stability extends Simulation with Annotations {

  setUp(
    new CommonScenario().unaryRpcScenario.inject(
      rampUsersPerSec(0) to intensity.toInt during rampDuration, //разгон
      constantUsersPerSec(intensity.toInt) during stageDuration, //полка
    ),
    new CommonScenario().clientStreamScenario.inject(
      rampUsersPerSec(0) to intensity.toInt during rampDuration, //разгон
      constantUsersPerSec(intensity.toInt) during stageDuration, //полка
    ),
  ).protocols(grpcProtocol)
    .maxDuration(testDuration) //длительность теста = разгон + полка

}
