package ru.tinkoff.load

import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.load.jdbc.Predef._
import ru.tinkoff.load.jdbc.protocol.JdbcProtocolBuilder

import scala.concurrent.duration.DurationInt

package object myJdbcSample {

  val jdbcProtocol: JdbcProtocolBuilder = DB
    // Указываем строку подключения к БД
    .url(baseUrl)
    .username(getStringParam("dbUser"))
    .password(getStringParam("dbPassword"))
    .connectionTimeout(2.minute)
}
