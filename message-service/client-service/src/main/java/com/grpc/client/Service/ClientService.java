package com.grpc.client.Service;

import com.example.grpc.server.grpcserver.PingPongServiceGrpc;
import com.example.grpc.server.grpcserver.PingRequest;
import com.example.grpc.server.grpcserver.PongResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @GrpcClient("client-message")
    private PingPongServiceGrpc.PingPongServiceBlockingStub pongServiceBlockingStub;

    public String pongRequest(String message){
        PingRequest request=PingRequest.newBuilder().setPing(message).build();
        PongResponse response=this.pongServiceBlockingStub.ping(request);

            return  response.getPong();

    }

}
