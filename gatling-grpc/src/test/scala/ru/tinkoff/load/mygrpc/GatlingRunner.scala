package ru.tinkoff.load.mygrpc

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object GatlingRunner {

  def main(args: Array[String]): Unit = {

    // this is where you specify the class you want to run
    val simulationClass = classOf[Debug].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simulationClass)

    Gatling.fromMap(props.build)
  }

}
