package nimblix.in.HealthCareHub.serviceImpl;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.constants.HealthCareConstants;
import nimblix.in.HealthCareHub.exception.DoctorNotFoundException;
import nimblix.in.HealthCareHub.model.Review;
import nimblix.in.HealthCareHub.model.Role;
import nimblix.in.HealthCareHub.repository.DoctorRepository;
import nimblix.in.HealthCareHub.repository.ReviewRepository;
import nimblix.in.HealthCareHub.response.ReviewResponse;
import nimblix.in.HealthCareHub.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public List<String> getAllRoles() {
        return Arrays.stream(Role.values())
                .map(Enum::name)
                .toList();
    }

    @Override
    public List<ReviewResponse> getReviewsByDoctor(Long doctorId) {

        doctorRepository.findById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(
                        HealthCareConstants.DOCTOR_NOT_FOUND));


        List<Review> reviews = reviewRepository.findByDoctorId(doctorId);

        return reviews.stream()
                .map(review -> ReviewResponse.builder()
                        .reviewId(review.getId())
                        .rating(review.getRating())
                        .comment(review.getComment())
                        .patientId(review.getPatient().getId())
                        .patientName(review.getPatient().getName())
                        .doctorId(review.getDoctor().getId())
                        .doctorName(review.getDoctor().getName())
                        .createdTime(review.getCreatedTime())
                        .updatedTime(review.getUpdatedTime())
                        .build())
                .collect(Collectors.toList());
    }
}