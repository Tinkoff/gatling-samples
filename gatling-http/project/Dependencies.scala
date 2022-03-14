import sbt._

object Dependencies {
  lazy val gatling: Seq[ModuleID] = Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts",
    "io.gatling"            % "gatling-test-framework"
  ).map(_ % "3.7.5" % Test)

  lazy val gatlingPicatinny: Seq[ModuleID] = Seq(
    "ru.tinkoff" %% "gatling-picatinny"
  ).map(_ % "0.9.1")

  lazy val janino: Seq[ModuleID] = Seq(
    "org.codehaus.janino" % "janino"
  ).map(_ % "3.1.2")

}
