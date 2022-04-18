package ru.tinkoff.load

import com.github.phisgr.gatling.grpc.Predef._
import com.github.phisgr.gatling.grpc.protocol.StaticGrpcProtocol
import ru.tinkoff.gatling.config.SimulationConfig._

package object mygrpc {

  val grpcHost: String = getStringParam("grpcHost")
  val grpcPort: Int    = getIntParam("grpcPort")

  val grpcProtocol: StaticGrpcProtocol = grpc(managedChannelBuilder(grpcHost, grpcPort).usePlaintext())

}
