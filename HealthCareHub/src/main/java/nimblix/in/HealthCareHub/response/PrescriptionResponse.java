package nimblix.in.HealthCareHub.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrescriptionResponse {
    private Long prescriptionId;
    
    // Patient info
    private Long patientId;
    private String patientName;
    
    // Doctor info
    private Long doctorId;
    private String doctorName;
    
    // Prescription details
    private String diagnosis;
    private String medicineDetails;
    private String prescribedAt; // IST format string
}
