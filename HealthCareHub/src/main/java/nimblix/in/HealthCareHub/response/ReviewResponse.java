package nimblix.in.HealthCareHub.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {

    private Long reviewId;
    private Integer rating;
    private String comment;
    private Long patientId;
    private String patientName;
    private Long doctorId;
    private String doctorName;
    private String createdTime;
    private String updatedTime;
}
