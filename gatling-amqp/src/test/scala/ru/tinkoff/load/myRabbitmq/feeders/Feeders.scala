package ru.tinkoff.load.myRabbitmq.feeders

import io.gatling.core.Predef._
import io.gatling.core.feeder.BatchableFeederBuilder

object Feeders {

  val idFeeder: BatchableFeederBuilder[String] = csv("pools/messageIds.csv").

}
