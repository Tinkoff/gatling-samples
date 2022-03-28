package ru.tinkoff.load.myhttpservice

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.load.myhttpservice.scenarios.CommonScenario

class Debug extends Simulation {

  setUp(
    // Запускаем наш сценарий
    CommonScenario()
      // Запускать будет один пользователь - одну итерацию
      .inject(atOnceUsers(1)),
  ).protocols(
    // Работа будет проходить по протоколу, который описан в конфигурации httpProtocol
    httpProtocol
      // Настраиваем прокси для отладки запросов, используем для этого fiddler или charles (8888 стандартный порт для прокси)
      .proxy(Proxy("localhost", 8888).httpsPort(8888))
  )
    // Максимальное время теста равно testDuration, если тест не завершится за меньшее время, он будет остановлен автоматически
    .maxDuration(testDuration)
}