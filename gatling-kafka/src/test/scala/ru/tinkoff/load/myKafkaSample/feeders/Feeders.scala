package ru.tinkoff.load.myKafkaSample.feeders

import io.gatling.core.feeder.Feeder
import ru.tinkoff.gatling.feeders.RandomStringFeeder

object Feeders {

  // Создаем фидер для генерации строки 6 случайных символов
  val myRandomStringFeeder: Feeder[String] = RandomStringFeeder("name", 6)
}
