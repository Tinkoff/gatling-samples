package ru.tinkoff.load.myRabbitmq.cases

import io.gatling.core.Predef._
import ru.tinkoff.gatling.amqp.Predef._
import ru.tinkoff.gatling.amqp.request.{PublishDslBuilder, RequestReplyDslBuilder}

object AmqpActions {

  val publishMessageToQueue: PublishDslBuilder = amqp("Publish to queue").publish
    .queueExchange("test_queue")                 // имя очереди, в которую отправляем сообщения
    .textMessage("Hello message - ${messageId}") // текст сообщения
    .messageId("${messageId}")                   // настройки сообщения
    .priority(0)

  val publishAndReply: RequestReplyDslBuilder = amqp("Request Reply exchange test").requestReply
    .queueExchange("test_queue_out")
    .replyExchange("test_queue_out")
    .textMessage("""{"msg": "Hello message - ${messageId}"}""")
    .messageId("${messageId}")
    .priority(0)
    .contentType("application/json")
    .headers("test" -> "performance", "extra-test" -> "34-${messageId}")
    .check(
      bodyString.exists,
    )

}
