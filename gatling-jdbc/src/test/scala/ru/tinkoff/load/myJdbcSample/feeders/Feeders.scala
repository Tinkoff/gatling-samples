package ru.tinkoff.load.myJdbcSample.feeders

import ru.tinkoff.gatling.feeders.RandomStringFeeder

object Feeders {

  val myRandomStringFeeder = RandomStringFeeder("myString", 10)

}
