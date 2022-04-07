package ru.tinkoff.load.myKafkaSample

import io.gatling.core.Predef._
import ru.tinkoff.gatling.kafka.Predef._
import ru.tinkoff.load.myKafkaSample.scenarios.CommonScenario

class Debug extends Simulation {

  setUp(
    CommonScenario().inject(atOnceUsers(1)),
  ).protocols(
    kafkaProtocol,
  )
}
