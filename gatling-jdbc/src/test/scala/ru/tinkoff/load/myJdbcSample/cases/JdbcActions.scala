package ru.tinkoff.load.myJdbcSample.cases

import io.gatling.core.Predef._
import ru.tinkoff.load.jdbc.Predef.jdbc
import ru.tinkoff.load.jdbc.actions
import ru.tinkoff.load.jdbc.actions.Columns

object JdbcActions {

  val createTable: actions.RawSqlActionBuilder = {
    // Указываем название запроса
    jdbc("create table")
    // Подставляем SQL запрос
    .rawSql("create table if not exists test_table(id SERIAL, name varchar(20))")
  }

  val insertData: actions.DBInsertActionBuilder = {
    // Указываем название запроса
    jdbc("insert")
      // Указываем имя таблицы и список полей, в которые требуется вставить записи
    .insertInto("test_table", Columns("name"))
      // Указываем значения, которые требуется вставить для каждой указанной выше колонки
    .values("name" -> "${myString}")
  }
}
