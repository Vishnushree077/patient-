
package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.response.ReviewResponse;

import java.util.List;

public interface DoctorService {

    List<String> getAllRoles();

    List<ReviewResponse> getReviewsByDoctor(Long doctorId);
}
