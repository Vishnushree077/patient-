package nimblix.in.HealthCareHub.controller;

import nimblix.in.HealthCareHub.request.SubscriptionRenewRequest;
import nimblix.in.HealthCareHub.response.ApiResponse;
import nimblix.in.HealthCareHub.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PutMapping("/{hospitalId}/renew")
    public ResponseEntity<ApiResponse<String>> renewSubscription(
            @PathVariable Long hospitalId,
            @RequestBody SubscriptionRenewRequest renewRequest) {

        subscriptionService.renewHospitalSubscription(hospitalId, renewRequest);

        return ResponseEntity.ok(new ApiResponse<>(true, "Subscription updated successfully", null));
    }
}