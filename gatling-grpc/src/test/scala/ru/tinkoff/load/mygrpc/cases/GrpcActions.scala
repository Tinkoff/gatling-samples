package ru.tinkoff.load.mygrpc.cases

import com.github.phisgr.gatling.grpc.Predef._
import com.github.phisgr.gatling.grpc.action._
import com.github.phisgr.gatling.grpc.request._
import io.gatling.core.Predef._
import io.grpc.Status
import io.grpc.examples.routeguide.route_guide._

object GrpcActions {

  //  Unary RPC
  val getFeature: GrpcCallActionBuilder[Point, Feature] = grpc(
    "Get feature",                          // имя запроса, отображаемое в отчете, следует заполнять без какой-либо интерполяции или подстановки переменных
  )
    .rpc(RouteGuideGrpc.METHOD_GET_FEATURE) // используемый метод тестового сервиса GetFeature
    .payload(
      Point(
        latitude = 409146138,
        longitude = -746188906,
      ),
    )                                       // отправляемый запрос в gRPC сервис
    .extract(_.some)(_ notNull)             // извлечение всего ответа и проверка, что он не пустой
    .extract(_.location.get.latitude.some)(
      _ saveAs "responseLatitude",
    )                                       // извлечение параметра ответа и сохранение в переменную responseLatitude
    .check(statusCode is Status.Code.OK)    // проверка статуса ответа

  //  Client stream RPC
  val clientStream: ClientStream = grpc(
    "Get route summary",           // имя запроса, отображаемое в отчете, следует заполнять без какой-либо интерполяции или подстановки переменных
  )
    .clientStream("Client Stream") // создание клиентского потока

  val recordRouteConnect: ClientStreamStartActionBuilder[Point, RouteSummary] = clientStream
    .connect(RouteGuideGrpc.METHOD_RECORD_ROUTE) // используемый метод тестового сервиса RecordRoute
    .check(statusCode is Status.Code.OK)         // открытие потока

  val recordRouteSend: StreamSendBuilder[Point] = clientStream
    .send("${randPoint}") // отправка запроса (реализуется в фидере) в поток

  val recordRouteСompleteAndWait: ClientStreamCompletionBuilder =
    clientStream.completeAndWait // закрытие потока и ожидание ответа от сервера

}
