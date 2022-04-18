package ru.tinkoff.load.mygrpc.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import ru.tinkoff.load.mygrpc.cases.GrpcActions
import ru.tinkoff.load.mygrpc.feeders.Feeders.pointFeeder

import scala.concurrent.duration.DurationInt

class CommonScenario {

  val unaryRpcScenario: ScenarioBuilder = scenario("Unary RPC")
    .exec(GrpcActions.getFeature)

  val clientStreamScenario: ScenarioBuilder = scenario("Client stream RPC")
    .exec(GrpcActions.recordRouteConnect)         // открываем клиентский поток
    .repeat(5) {
      pause(1.seconds)
        .feed(pointFeeder)                 // вызываем фидер
        .exec(GrpcActions.recordRouteSend) // отправляем запрос в поток
    }
    .exec(GrpcActions.recordRouteСompleteAndWait) // закрываем поток и ждем ответа от сервера

}
