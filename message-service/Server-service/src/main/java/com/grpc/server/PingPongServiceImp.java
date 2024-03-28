package com.grpc.server;

import com.example.grpc.server.grpcserver.PingPongServiceGrpc;
import com.example.grpc.server.grpcserver.PingRequest;
import com.example.grpc.server.grpcserver.PongResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PingPongServiceImp extends PingPongServiceGrpc.PingPongServiceImplBase {
    @Override
    public void ping(PingRequest request, StreamObserver<PongResponse> responseObserver) {
        String ping=new StringBuilder()
                .append("this is from server side")
                .append(request.getPing())
                .toString();

        PongResponse response=PongResponse.newBuilder()
                .setPong(ping)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
