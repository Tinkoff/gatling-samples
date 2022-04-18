import sbt._

object Dependencies {
  lazy val gatling: Seq[ModuleID] = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts",
    "io.gatling"            % "gatling-test-framework",
  ).map(_ % "3.7.6" % Test)

  lazy val gatlingPicatinny: Seq[ModuleID] = Seq(
    "ru.tinkoff" %% "gatling-picatinny",
  ).map(_ % "0.10.0")

  lazy val janino: Seq[ModuleID] = Seq(
    "org.codehaus.janino" % "janino",
  ).map(_ % "3.1.2")

  lazy val epoll: Seq[ModuleID] = Seq(
    "io.netty" % "netty-transport-native-epoll"  % "4.1.65.Final" classifier "linux-x86_64",
    "io.netty" % "netty-transport-native-kqueue" % "4.1.65.Final" classifier "osx-x86_64",
  )

  lazy val amqpPlugin: Seq[ModuleID] = Seq(
    "ru.tinkoff" %% "gatling-amqp-plugin", // подключаем плагин для amqp протокола
  ).map(_ % "0.6.2" % Test)
}
