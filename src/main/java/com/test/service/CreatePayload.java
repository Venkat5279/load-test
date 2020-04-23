package com.test.service;

import com.test.data.DataLoader;
import com.test.model.TestData;
import com.test.model.channelbound.SegmentRequest;
import com.test.model.channelbound.UpgradeRequest;
import com.test.model.channelbound.UpgradeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

@Service
public class CreatePayload {

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;
    @Autowired
    private DataLoader dataloader;
    @Value("${uri}")
    private String uri;

    public List<Callable<ResponseEntity<UpgradeResponse>>> createTasks() {
        final List<Callable<ResponseEntity<UpgradeResponse>>> callableTasks = new ArrayList<>();
        dataloader.getTestData().forEach(v -> {
            final HttpHeaders headers = getHttpEntity(v.getClientId(), uuid());
            final HttpEntity<?> entity = new HttpEntity<>(createRequest(v), headers);
            callableTasks.add(() -> oAuth2RestTemplate.exchange(uri, HttpMethod.POST, entity, UpgradeResponse.class));
        });
        return callableTasks;
    }

    private UpgradeRequest createRequest(final TestData testData) {
        final UpgradeRequest request = new UpgradeRequest();
        request.setPnr(testData.getPnr());
        final List<SegmentRequest> list = new ArrayList<>();
        final SegmentRequest segmentRequest = new SegmentRequest();
        segmentRequest.setSegmentId(testData.getId());
        segmentRequest.setDesiredBookingClass(testData.getClassOfService());
        segmentRequest.setCurrentBookingClass("Y");
        segmentRequest.setOrigin(testData.getOrigin());
        segmentRequest.setDestination(testData.getDestination());
        list.add(segmentRequest);
        request.setSegments(list);
        return request;
    }

    private HttpHeaders getHttpEntity(final String xClientId, final String xTransactionId) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Client-Id", xClientId);
        httpHeaders.add("X-Transaction-Id", xTransactionId);
        httpHeaders.add("Authorization", "Bearer " + oAuth2RestTemplate.getAccessToken().getValue());
        return httpHeaders;
    }

    private static String uuid() {
        return UUID.randomUUID().toString();
    }
}
