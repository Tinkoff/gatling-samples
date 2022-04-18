package ru.tinkoff.load.myRabbitmq

import io.gatling.core.Predef._
import ru.tinkoff.gatling.amqp.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.load.myRabbitmq.scenarios.CommonScenario

class Debug extends Simulation {

  setUp(
    CommonScenario()          // запускаем наш сценарий
      .inject(atOnceUsers(1)),// запускать будет один пользователь - одну итерацию
  ).protocols(
    amqpConf,                 // работа будет проходить по протоколу, который описан в конфигурации amqpConf
  ).maxDuration(
    testDuration,
  )                           // максимальное время теста равно testDuration, если тест не завершится за меньшее время, он будет остановлен автоматически

}
