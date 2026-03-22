package nimblix.in.HealthCareHub.serviceImpl;

import nimblix.in.HealthCareHub.model.Patient;
import nimblix.in.HealthCareHub.repository.PatientRepository;
import nimblix.in.HealthCareHub.request.ResetPasswordRequest;
import nimblix.in.HealthCareHub.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
//    public List<Patient> getAllPatients() {
//
//        return repository.findByIsDeletedFalse();
//    }

    public String softDeletePatient(Long id) {
        Patient patient = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

//        patient.setDeleted();   //  Mark as deleted
        repository.save(patient);

        return "Patient soft deleted successfully";
    }

    public Patient savePatient(Patient patient) {
        // TODO Auto-generated method stub
        return repository.save(patient);
    }



@Override
        public String resetPassword(ResetPasswordRequest request) {
            Patient patient =  repository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("Patient not found"));

            // Encrypt password
            String encodedPassword = passwordEncoder.encode(request.getNewPassword());
            patient.setPassword(encodedPassword);

            repository.save(patient);

            return "Password reset successful";
        }
    }

