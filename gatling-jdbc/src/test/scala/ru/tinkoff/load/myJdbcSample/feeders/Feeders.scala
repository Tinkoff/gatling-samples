package ru.tinkoff.load.myJdbcSample.feeders

import ru.tinkoff.gatling.feeders.RandomStringFeeder

object Feeders {

  // Создаем feeder для генерации строки из 10 случайных символов
  val myRandomStringFeeder = RandomStringFeeder("myString", 10)
}
