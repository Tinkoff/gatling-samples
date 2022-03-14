package ru.tinkoff.load.myhttpservice

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object GatlingRunner {

  def main(args: Array[String]): Unit = {

    // Указывает имя симуляции Debug, либо какой-то другой, например, MaxPerformance
    val simulationClass = classOf[Debug].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simulationClass)

    Gatling.fromMap(props.build)
  }

}
