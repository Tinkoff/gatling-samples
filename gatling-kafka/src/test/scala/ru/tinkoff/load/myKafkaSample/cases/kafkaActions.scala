package ru.tinkoff.load.myKafkaSample.cases

import io.gatling.core.Predef._
import ru.tinkoff.gatling.kafka.Predef.kafka
import ru.tinkoff.gatling.kafka.request.builder.RequestBuilder

object kafkaActions {

  val sendMyMessage: RequestBuilder[_, Any] = {
    // Указываем имя запроса
    kafka("my message")
      // Указываем ключ и сообщение
      .send("myMessage", "Hello!")
  }

  val sendOtherMessage: RequestBuilder[_, Any] = kafka("my other message")
    .send("myMessage", "Hello, #{name}!")

}
