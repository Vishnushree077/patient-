package nimblix.in.HealthCareHub.DTO;

public class HospitalDTO {
    private Long id;
    private String name;
    private String city;   //

    public HospitalDTO(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
