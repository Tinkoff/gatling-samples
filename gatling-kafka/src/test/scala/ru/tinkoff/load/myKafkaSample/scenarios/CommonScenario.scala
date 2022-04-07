package ru.tinkoff.load.myKafkaSample.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import ru.tinkoff.load.myKafkaSample.cases._
import ru.tinkoff.gatling.kafka.Predef._
import ru.tinkoff.load.myKafkaSample.feeders.Feeders.myRandomStringFeeder

object CommonScenario {
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {

  val scn: ScenarioBuilder = scenario("Common Scenario")
    .feed(myRandomStringFeeder)
    .exec(kafkaActions.sendMyMessage)
    .exec(kafkaActions.sendOtherMessage)

}