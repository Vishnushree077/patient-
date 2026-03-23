package nimblix.in.HealthCareHub.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalStatsResponse {

    private Long hospitalId;
    private String hospitalName;
    private Integer totalBeds;
    private Integer totalRooms;
    private Integer availableRooms;
    private Integer occupiedRooms;
    private Integer totalDoctors;
}