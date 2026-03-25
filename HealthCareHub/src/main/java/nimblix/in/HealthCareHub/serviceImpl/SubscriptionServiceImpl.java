package nimblix.in.HealthCareHub.serviceImpl;

import nimblix.in.HealthCareHub.model.Hospital;
import nimblix.in.HealthCareHub.repository.HospitalRepository;
import nimblix.in.HealthCareHub.request.SubscriptionRenewRequest;
import nimblix.in.HealthCareHub.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public void renewHospitalSubscription(Long hospitalId, SubscriptionRenewRequest request) {
        // Find hospital or throw exception
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException("Hospital not found with id: " + hospitalId));

        // Logic: You can update fields here like hospital.setPlan(request.getPlanType())
        // hospitalRepository.save(hospital);

        System.out.println("Renewing hospital: " + hospital.getName() + " for " + request.getMonths() + " months.");
    }
}