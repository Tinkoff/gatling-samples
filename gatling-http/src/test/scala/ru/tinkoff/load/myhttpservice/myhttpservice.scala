package ru.tinkoff.load

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
// Подключаем стандартные переменные из gatling picatinny
import ru.tinkoff.gatling.config.SimulationConfig._

package object myhttpservice {

  val httpProtocol: HttpProtocolBuilder = http
    // Используем стандартную переменную из gatling picatinny, значение которой подтянется из simulation.conf
    .baseUrl(baseUrl)
    // Базовые заголовки. Для большинства кейсов этого будет достаточно и ничего менять не нужно.
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
    // Если требуется добавить авторизацию, можно использовать специальные методы.
    .authorizationHeader("Bearer token")
    // Или определить свой заголовок
    .header("customHeader", "value")
}

