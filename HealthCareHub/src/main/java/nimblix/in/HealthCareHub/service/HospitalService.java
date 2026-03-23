package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.request.HospitalRegistrationRequest;

import nimblix.in.HealthCareHub.request.MedicineAddRequest;
import nimblix.in.HealthCareHub.response.HospitalFilterResponse;
import nimblix.in.HealthCareHub.response.HospitalStatsResponse;
import nimblix.in.HealthCareHub.response.RoomResponse;

import java.util.List;

public interface HospitalService {

    String registerHospital(HospitalRegistrationRequest request);

    String addMedicine(MedicineAddRequest request);

    void addRooms(Long hospitalId, List<HospitalRegistrationRequest.Room> rooms);

    List<RoomResponse> getAvailableRooms(Long hospitalId);

    List<HospitalFilterResponse> filterBySpecialization(String specialization);

    HospitalStatsResponse getHospitalStats(Long hospitalId);

}
