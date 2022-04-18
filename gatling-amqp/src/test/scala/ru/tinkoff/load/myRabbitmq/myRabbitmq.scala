package ru.tinkoff.load

import io.gatling.core.Predef._
import ru.tinkoff.gatling.amqp.Predef._
import ru.tinkoff.gatling.amqp.protocol.AmqpProtocolBuilder
import ru.tinkoff.gatling.config.SimulationConfig.{getIntParam, getStringParam}

package object myRabbitmq {

  val amqpHost: String     = getStringParam("amqpHost")
  val amqpPort: Int        = getIntParam("amqpPort")
  val amqpLogin: String    = getStringParam("amqpLogin")
  val amqpPassword: String = getStringParam("amqpPassword")

  val amqpConf: AmqpProtocolBuilder = amqp
    .connectionFactory(
      rabbitmq
        .host(amqpHost)
        .port(amqpPort)
        .username(amqpLogin)
        .password(amqpPassword)
        .vhost("/"),
    )
    .replyTimeout(60000)
    .consumerThreadsCount(8)
    .usePersistentDeliveryMode

}
