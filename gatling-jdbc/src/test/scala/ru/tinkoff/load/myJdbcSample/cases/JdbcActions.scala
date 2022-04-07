package ru.tinkoff.load.myJdbcSample.cases

import io.gatling.core.Predef._
import ru.tinkoff.load.jdbc.Predef.jdbc
import ru.tinkoff.load.jdbc.actions
import ru.tinkoff.load.jdbc.actions.Columns

object JdbcActions {

  val createTable: actions.RawSqlActionBuilder = jdbc("create table")
    .rawSql("create table if not exists test_table(id SERIAL, name varchar(20))")

  val insertData: actions.DBInsertActionBuilder = jdbc("insert")
    .insertInto("test_table", Columns("name"))
    .values("name" -> "${myString}")
}
