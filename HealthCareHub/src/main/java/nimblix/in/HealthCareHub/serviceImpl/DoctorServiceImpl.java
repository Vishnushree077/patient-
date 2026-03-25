package nimblix.in.HealthCareHub.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import nimblix.in.HealthCareHub.model.Role;
import nimblix.in.HealthCareHub.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Override
    public List<String> getAllRoles() {

        return Arrays.stream(Role.values())
                .map(Enum::name)
                .toList();
    }
}
