package ru.tinkoff.load.mygrpc.feeders

import io.gatling.core.feeder.Feeder
import io.grpc.examples.routeguide.route_guide.Point
import ru.tinkoff.gatling.feeders.CustomFeeder

import scala.util.Random

object Feeders {

  val pointFeeder: Feeder[Point] = CustomFeeder(
    "randPoint",
    new Point(
      latitude = Random.between(400273442, 419999544),
      longitude = Random.between(-749836354, -741058078),
    ),
  )

}
