package com.pm.billingservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);
    @Override
    public void createBillingAccount(BillingRequest billingRequest, StreamObserver<BillingResponse> billingResponseStreamObserver) {
        log.info("Request received at Billing-Service is::: {}", billingRequest.toString());
        //Business Logic
        BillingResponse response = BillingResponse.newBuilder().setAccId("billing-service").setStatus("SUCCESS").build();
        billingResponseStreamObserver.onNext(response);
        billingResponseStreamObserver.onCompleted();

    }

}
