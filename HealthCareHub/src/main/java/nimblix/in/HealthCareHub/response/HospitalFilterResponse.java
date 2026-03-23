package nimblix.in.HealthCareHub.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HospitalFilterResponse {

    private Long hospitalId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String phone;
    private String email;
    private Integer totalBeds;
}