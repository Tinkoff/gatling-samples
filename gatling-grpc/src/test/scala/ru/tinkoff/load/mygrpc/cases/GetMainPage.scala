package ru.tinkoff.load.mygrpc.cases

import io.gatling.http.Predef._
import io.gatling.core.Predef._

object GetMainPage {

  val getMainPage = http("GET /")
    .get("/")
    .check(status is 200)

}
