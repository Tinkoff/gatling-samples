package ru.tinkoff.load.myRabbitmq.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import ru.tinkoff.gatling.amqp.Predef._
import ru.tinkoff.load.myRabbitmq.cases.AmqpActions
import ru.tinkoff.load.myRabbitmq.feeders.Feeders.idFeeder

object CommonScenario {
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {

  val scn: ScenarioBuilder = scenario("Common Scenario")
    .feed(idFeeder)                          // вызов Feeder
    .exec(AmqpActions.publishMessageToQueue) // выполнение публикации сообщения в очередь
    .exec(AmqpActions.publishAndReply)       // публикация в Exchange и чтение из очереди

}
