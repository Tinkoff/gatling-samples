package ru.tinkoff.load.myKafkaSample

import io.gatling.core.Predef._
import ru.tinkoff.gatling.kafka.Predef._
import ru.tinkoff.load.myKafkaSample.scenarios.CommonScenario

class Debug extends Simulation {

  setUp(
    // Вызываем сценарий
    CommonScenario()
      // Задаем интенсивность
      .inject(atOnceUsers(1)),
  ).protocols(
    // Указываем протокол
    kafkaProtocol,
  )
}
