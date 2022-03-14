package ru.tinkoff.load.myhttpservice.scenarios

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import ru.tinkoff.load.myhttpservice.cases.Actions._
import ru.tinkoff.load.myhttpservice.feeders.Feeders._

/*
Объект-компаньон для класса CommonScenario,
по сути синтаксический сахар, что бы можно было вызвать сценарий
таким образом CommonScenario(), вместо new CommonScenario().scn
*/
object CommonScenario {
  def apply(): ScenarioBuilder = new CommonScenario().scn
}

class CommonScenario {

  // Создаем сценарий и его имя
  val scn: ScenarioBuilder = scenario("CommonScenario")
  // Подключаем наши фидеры
    .feed(feeders)
    // Подключаем наши запросы
    .exec(pressButtonAddNewComputer)
    .exec(createNewComputer)
}
