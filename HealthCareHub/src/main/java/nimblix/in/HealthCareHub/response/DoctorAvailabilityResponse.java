package nimblix.in.HealthCareHub.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorAvailabilityResponse {

    private Long id;
    private Long doctorId;
    private String doctorName;
    private String availableDate;
    private String startTime;
    private String endTime;
    private boolean available;
    private String createdTime;
    private String updatedTime;
}
