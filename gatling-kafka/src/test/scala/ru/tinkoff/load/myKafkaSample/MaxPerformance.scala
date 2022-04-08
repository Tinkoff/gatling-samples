package ru.tinkoff.load.myKafkaSample

import io.gatling.core.Predef._
import ru.tinkoff.gatling.config.SimulationConfig._
import ru.tinkoff.gatling.influxdb.Annotations
import ru.tinkoff.load.myKafkaSample.scenarios.CommonScenario
import ru.tinkoff.gatling.kafka.Predef._

class MaxPerformance extends Simulation with Annotations {

  setUp(
    //Указываем сценарий
    new CommonScenario().createTableScn
      // Сценарий будет выполнятся 1 раз
      .inject(atOnceUsers(1))
      // Второй сценарий начнет работу только после завершения первого
      .andThen(
        // Указываем сценарий
        new CommonScenario().insertInTable.inject(
          // Интенсивность на ступень
          incrementUsersPerSec((intensity / stagesNumber).toInt)
            // Количество ступеней
            .times(stagesNumber)
            // Длительность полки
            .eachLevelLasting(stageDuration)
            // Длительность разгона
            .separatedByRampsLasting(rampDuration)
            // Начало нагрузки с
            .startingFrom(0),
        ),
      ))
    // Указываем протокол
    .protocols(kafkaProtocol)
    // Общая длительность теста
    .maxDuration(testDuration)
}