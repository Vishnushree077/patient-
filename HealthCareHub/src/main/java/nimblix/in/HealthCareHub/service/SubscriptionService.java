package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.request.SubscriptionRenewRequest;

public interface SubscriptionService {
    void renewHospitalSubscription(Long hospitalId, SubscriptionRenewRequest request);
}