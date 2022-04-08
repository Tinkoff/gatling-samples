package ru.tinkoff.load.myJdbcSample

import io.gatling.core.Predef._
import ru.tinkoff.load.jdbc.Predef._
import ru.tinkoff.load.myJdbcSample.scenarios.CommonScenario

class Debug extends Simulation {

  setUp(
    // Вызов сценария
    CommonScenario()
      // Нагрузка будет подаваться 1 пользователем = 1 итерация
      .inject(atOnceUsers(1)),
  ).protocols(
    // Указываем протокол
    jdbcProtocol,
  )

}
