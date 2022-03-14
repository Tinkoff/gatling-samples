package ru.tinkoff.load.myhttpservice.cases

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Actions {

  val openMainPage: HttpRequestBuilder =
    // Указываем имя запроса
    http("Open main page")
    // Указываем тип запроса (метод) и эндпоинт
      .get("")
      .check(
        // Проверяем, что в ответе пришел ОК
        // (по умолчанию gatling проверяет ответ на все успешные коды ответа: 2xx, 3xx)
        status is 200,
      )

  val pressButtonAddNewComputer: HttpRequestBuilder =
    http("pressButtonAddNewComputer")
      .get("/computers/new")
      .check(
        status is 200,
      )
      .check(
        // Забираем из ответа случайную компанию и сохраняем значение в переменной 'company'
        regex("""<option value="(.+?)"""").findRandom.saveAs("company"),
      )

  val createNewComputer: HttpRequestBuilder =
    http("createNewComputer")
      .post("/computers")
      // Указываем параметры запроса. Обратите внимание на значение, таким образом мы можем параметризовать запросы.
      .formParam("name", "#{randomComputerName}")
      .formParam("introduced", "#{introduced}")
      .formParam("discontinued", "#{discontinued}")
      // Тут вместо #{company} подставится значение из предыдущего запроса
      .formParam("company", "#{company}")
}
