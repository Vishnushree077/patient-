package nimblix.in.HealthCareHub.request;

import lombok.Data;

@Data
public class MedicineRequest {

    private Long medicineId;   // maps to entity field 'id'
    private String medicineName;
    private String manufacturer;
    private String description;
    private String dosage;
    private Double price;
    private Integer stockQuantity;
    private Long hospitalId;
}