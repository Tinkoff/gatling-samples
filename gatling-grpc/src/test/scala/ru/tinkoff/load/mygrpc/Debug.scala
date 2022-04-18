package ru.tinkoff.load.mygrpc

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig.testDuration
import ru.tinkoff.load.mygrpc.scenarios.CommonScenario

class Debug extends Simulation {

  setUp(
    new CommonScenario().unaryRpcScenario // запускаем наш сценарий
      .inject(atOnceUsers(1)),            // запускать будет один пользователь - одну итерацию
    new CommonScenario().clientStreamScenario
      .inject(atOnceUsers(1)),
  ).protocols(grpcProtocol) // работа будет проходить по протоколу, который описан в grpcProtocol
    .maxDuration(testDuration)

}
