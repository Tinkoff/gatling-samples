import Dependencies._

enablePlugins(GatlingPlugin)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(
      List(
        organization := "ru.tinkoff.load",
        scalaVersion := "2.13.8",
        version      := "0.1.0",
      ),
    ),
    name := "myRabbitmq",
    libraryDependencies ++= gatling,
    libraryDependencies ++= gatlingPicatinny,
    libraryDependencies ++= janino,
    libraryDependencies ++= epoll,
    libraryDependencies ++= amqpPlugin, // добавляем плагин
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-Xfatal-warnings",
      "-deprecation",
      "-feature",
      "-unchecked",
      "-language:implicitConversions",
      "-language:higherKinds",
      "-language:existentials",
      "-language:postfixOps",
    ),
  )
