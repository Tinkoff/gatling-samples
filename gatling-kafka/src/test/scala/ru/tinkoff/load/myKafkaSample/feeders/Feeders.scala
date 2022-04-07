package ru.tinkoff.load.myKafkaSample.feeders

import io.gatling.core.feeder.Feeder
import ru.tinkoff.gatling.feeders.RandomStringFeeder

object Feeders {

  val myRandomStringFeeder: Feeder[String] = RandomStringFeeder("name", 6)
}
