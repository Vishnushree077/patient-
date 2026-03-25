package nimblix.in.HealthCareHub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    // ✅ CREATE SUBSCRIPTION
    @PostMapping
    public ResponseEntity<String> createSubscription(@RequestBody String request) {
        return ResponseEntity.ok("Subscription created");
    }

    // ✅ UPGRADE
    @PatchMapping("/{subscriptionId}/upgrade")
    public ResponseEntity<String> upgrade(@PathVariable Long subscriptionId,
                                          @RequestBody String request) {
        return ResponseEntity.ok("Subscription upgraded: " + subscriptionId);
    }

    // ✅ DOWNGRADE
    @PatchMapping("/{subscriptionId}/downgrade")
    public ResponseEntity<String> downgrade(@PathVariable Long subscriptionId,
                                            @RequestBody String request) {
        return ResponseEntity.ok("Subscription downgraded: " + subscriptionId);
    }

    // ✅ EXTEND
    @PatchMapping("/{subscriptionId}/extend")
    public ResponseEntity<String> extend(@PathVariable Long subscriptionId,
                                         @RequestBody String request) {
        return ResponseEntity.ok("Subscription extended: " + subscriptionId);
    }

    // ✅ TEST API (very important)
    @GetMapping("/test")
    public String test() {
        return "API is working";
    }
}