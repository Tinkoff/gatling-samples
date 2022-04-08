package ru.tinkoff.load.myJdbcSample.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import ru.tinkoff.load.myJdbcSample.cases._
import ru.tinkoff.load.myJdbcSample.feeders.Feeders.myRandomStringFeeder

object CommonScenario {
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {

  val scn: ScenarioBuilder = {
    // Указываем имя запроса
    scenario("Common Scenario")
      // Добавление Feeder
    .feed(myRandomStringFeeder)
      // Выполнение запроса на создание таблицы
    .exec(JdbcActions.createTable)
      // Выполнение запроса на вставку данных в таблицу
    .exec(JdbcActions.insertData)
  }

  val createTableScn: ScenarioBuilder = scenario("create table")
    .exec(JdbcActions.createTable)

  val insertInTable: ScenarioBuilder = scenario("insert")
    .feed(myRandomStringFeeder)
    .exec(JdbcActions.insertData)

}