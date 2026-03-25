package nimblix.in.HealthCareHub.request;

import lombok.Data;

@Data
public class SubscriptionRenewRequest {
    private int months;
    private String planType;
}