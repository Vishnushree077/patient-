package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.request.ResetPasswordRequest;
import nimblix.in.HealthCareHub.response.PrescriptionResponse;

public interface PatientService {
    public String resetPassword(ResetPasswordRequest request) ;

    PrescriptionResponse getPrescriptionById(Long id);

    String getPrescriptionMedicine(Long prescriptionId);
}
