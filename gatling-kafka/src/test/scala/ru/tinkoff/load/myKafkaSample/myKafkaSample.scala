package ru.tinkoff.load

import org.apache.kafka.clients.producer.ProducerConfig
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.kafka.Predef.kafka
import ru.tinkoff.gatling.kafka.protocol.KafkaProtocolBuilder

package object myKafkaSample {

  val kafkaProtocol: KafkaProtocolBuilder = kafka
    .topic("myTopic")
    .properties(
      Map(
        ProducerConfig.ACKS_CONFIG                   -> "1",
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG      -> getStringParam("kafkaBroker"),
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG   -> "org.apache.kafka.common.serialization.StringSerializer",
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringSerializer",
      ),
    )
}
