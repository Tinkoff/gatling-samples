package ru.tinkoff.load.myJdbcSample

import io.gatling.core.Predef._
import ru.tinkoff.load.jdbc.Predef._
import ru.tinkoff.load.myJdbcSample.scenarios.CommonScenario

class Debug extends Simulation {

  setUp(
    CommonScenario()          // Вызов сценария
      .inject(atOnceUsers(1)),// Нагрузка будет подаваться 1 пользователем = 1 итерация
  ).protocols(
    jdbcProtocol,             // Указываем наш протокол
  )

}
