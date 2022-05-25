/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.medicaap.tomaszwisniowski.DTO_model.*;
import pl.medicaap.tomaszwisniowski.exception.ResourceNotFoundException;
import pl.medicaap.tomaszwisniowski.model.*;
import pl.medicaap.tomaszwisniowski.service.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ApplicationController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private NurseService nurseService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientCardService patientCardService;
    @Autowired
    private PatientRegistrationService patientRegistrationService;


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////DOCTORS////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/doctors")
    public List<DTO_Doctor> getDoctors(@RequestParam(value = "sortBy", required = false) String sortBy) {
        return doctorService.getDoctors(sortBy).stream().map(this::asDto).collect(Collectors.toList());
    }


    @GetMapping("/doctors/{id}")
    public DTO_Doctor getDoctor(@PathVariable("id") Integer id) {
        return doctorService.getDoctor(id).map(this::asDto).orElseThrow(ResourceNotFoundException::new);
    }


    @PostMapping("/doctors")
    public DTO_Doctor addDoctor(@RequestBody @Valid DTO_Doctor dto_doctor) {
        return asDto(
                doctorService.addDoctor(
                        dto_doctor.getMedical_license_number(), dto_doctor.getFirst_name(), dto_doctor.getLast_name(), dto_doctor.getDate_of_birth(), dto_doctor.getTel(),
                        dto_doctor.getCity(), dto_doctor.getStreet(), dto_doctor.getHouse_number(), dto_doctor.getFlat_number()));
    }


    @PutMapping("/doctors/{id}")
    public DTO_Doctor updateDoctor(@PathVariable("id") Integer id,
                                      @RequestBody @Valid DTO_Doctor dto_doctor) {
        return doctorService
                .updateDoctor(
                        id, dto_doctor.getMedical_license_number(), dto_doctor.getFirst_name(), dto_doctor.getLast_name(), dto_doctor.getDate_of_birth(), dto_doctor.getTel(),
                        dto_doctor.getCity(), dto_doctor.getStreet(), dto_doctor.getHouse_number(), dto_doctor.getFlat_number())
                .map(this::asDto)
                .orElseThrow(ResourceNotFoundException::new);
    }


    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable("id") Integer id) {
        doctorService.deleteDoctor(id);
    }


    public DTO_Doctor asDto(Doctor doctor) {
        return DTO_Doctor.builder()
                .id(doctor.getId())
                .medical_license_number(doctor.getMedical_license_number())
                .first_name(doctor.getFirst_name())
                .last_name(doctor.getLast_name())
                .date_of_birth(doctor.getDate_of_birth())
                .tel(doctor.getTel())
                .city(doctor.getCity())
                .street(doctor.getStreet())
                .house_number(doctor.getHouse_number())
                .flat_number(doctor.getFlat_number())
                .build();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////NURSES////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/nurses")
    public List<DTO_Nurse> getNurses(@RequestParam(value = "sortBy", required = false) String sortBy) {
        return nurseService.getNurse(sortBy).stream().map(this::asDto).collect(Collectors.toList());
    }


    @GetMapping("/nurses/{id}")
    public DTO_Nurse getNurse(@PathVariable("id") Integer id) {
        return nurseService.getNurse(id).map(this::asDto).orElseThrow(ResourceNotFoundException::new);
    }


    @PostMapping("/nurses")
    public DTO_Nurse addNurse(@RequestBody @Valid DTO_Nurse dto_nurse) {
        return asDto(
                nurseService.addNurse(
                        dto_nurse.getMedical_license_number(), dto_nurse.getFirst_name(), dto_nurse.getLast_name(), dto_nurse.getDate_of_birth(), dto_nurse.getTel(),
                        dto_nurse.getCity(), dto_nurse.getStreet(), dto_nurse.getHouse_number(), dto_nurse.getFlat_number()));
    }


    @PutMapping("/nurses/{id}")
    public DTO_Nurse updateNurse(@PathVariable("id") Integer id,
                                   @RequestBody @Valid DTO_Nurse dto_nurse) {
        return nurseService
                .updateNurse(
                        id, dto_nurse.getMedical_license_number(), dto_nurse.getFirst_name(), dto_nurse.getLast_name(), dto_nurse.getDate_of_birth(), dto_nurse.getTel(),
                        dto_nurse.getCity(), dto_nurse.getStreet(), dto_nurse.getHouse_number(), dto_nurse.getFlat_number())
                .map(this::asDto)
                .orElseThrow(ResourceNotFoundException::new);
    }


    @DeleteMapping("/nurses/{id}")
    public void deleteNurse(@PathVariable("id") Integer id) {
        nurseService.deleteNurse(id);
    }


    public DTO_Nurse asDto(Nurse nurse) {
        return DTO_Nurse.builder()
                .id(nurse.getId())
                .medical_license_number(nurse.getMedical_license_number())
                .first_name(nurse.getFirst_name())
                .last_name(nurse.getLast_name())
                .date_of_birth(nurse.getDate_of_birth())
                .tel(nurse.getTel())
                .city(nurse.getCity())
                .street(nurse.getStreet())
                .house_number(nurse.getHouse_number())
                .flat_number(nurse.getFlat_number())
                .build();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////PATIENTS///////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/patients")
    public List<DTO_Patient> getPatients(@RequestParam(value = "sortBy", required = false) String sortBy) {
        return patientService.getPatient(sortBy).stream().map(this::asDto).collect(Collectors.toList());
    }


    @GetMapping("/patients/{id}")
    public DTO_Patient getPatient(@PathVariable("id") Integer id) {
        return patientService.getPatient(id).map(this::asDto).orElseThrow(ResourceNotFoundException::new);
    }


    @PostMapping("/patients")
    public DTO_Patient addPatient(@RequestBody @Valid DTO_Patient dto_patient) {
        return asDto(
                patientService.addPatient(
                        dto_patient.getPesel(), dto_patient.getFirst_name(), dto_patient.getLast_name(), dto_patient.getDate_of_birth(), dto_patient.getTel(),
                        dto_patient.getCity(), dto_patient.getStreet(), dto_patient.getHouse_number(), dto_patient.getFlat_number()));
    }


    @PutMapping("/patients/{id}")
    public DTO_Patient updatePatient(@PathVariable("id") Integer id,
                                 @RequestBody @Valid DTO_Patient dto_patient) {
        return patientService
                .updatePatient(
                        id, dto_patient.getPesel(), dto_patient.getFirst_name(), dto_patient.getLast_name(), dto_patient.getDate_of_birth(), dto_patient.getTel(),
                        dto_patient.getCity(), dto_patient.getStreet(), dto_patient.getHouse_number(), dto_patient.getFlat_number())
                .map(this::asDto)
                .orElseThrow(ResourceNotFoundException::new);
    }


    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable("id") Integer id) {
        patientService.deletePatient(id);
    }


    public DTO_Patient asDto(Patient patient) {
        return DTO_Patient.builder()
                .id(patient.getId())
                .pesel(patient.getPesel())
                .first_name(patient.getFirst_name())
                .last_name(patient.getLast_name())
                .date_of_birth(patient.getDate_of_birth())
                .tel(patient.getTel())
                .city(patient.getCity())
                .street(patient.getStreet())
                .house_number(patient.getHouse_number())
                .flat_number(patient.getFlat_number())
                .build();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////PATIENTS CARDS/////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/patientsCards")
    public List<DTO_PatientCard> getPatientCards(@RequestParam(value = "sortBy", required = false) String sortBy) {
        return patientCardService.getPatientCard(sortBy).stream().map(this::asDto).collect(Collectors.toList());
    }


    @GetMapping("/patientsCards/{id}")
    public DTO_PatientCard getPatientCard(@PathVariable("id") Integer id) {
        return patientCardService.getPatientCard(id).map(this::asDto).orElseThrow(ResourceNotFoundException::new);
    }


    @PostMapping("/patientsCards")
    public DTO_PatientCard addPatientCard(@RequestBody @Valid DTO_PatientCard dto_patientCard) {
        return asDto(
                patientCardService.addPatientCard(
                        dto_patientCard.getInterview(), dto_patientCard.getPhysical_examination(), dto_patientCard.getDiagnosis(), dto_patientCard.getVisit_history(), dto_patientCard.getPatient_id()));
    }


    @PutMapping("/patientsCards/{id}")
    public DTO_PatientCard updatePatientCard(@PathVariable("id") Integer id,
                                     @RequestBody @Valid DTO_PatientCard dto_patientCard) {
        return patientCardService
                .updatePatientCard(
                        id, dto_patientCard.getInterview(), dto_patientCard.getPhysical_examination(), dto_patientCard.getDiagnosis(), dto_patientCard.getVisit_history())
                .map(this::asDto)
                .orElseThrow(ResourceNotFoundException::new);
    }


    @DeleteMapping("/patientsCards/{id}")
    public void deletePatientCard(@PathVariable("id") Integer id) {
        patientCardService.deletePatientCard(id);
    }


    public DTO_PatientCard asDto(PatientCard patientCard) {
        return DTO_PatientCard.builder()
                .id(patientCard.getId())
                .patient_id(patientCard.getPatient().getId())
                .interview(patientCard.getInterview())
                .physical_examination(patientCard.getPhysical_examination())
                .diagnosis(patientCard.getDiagnosis())
                .visit_history(patientCard.getVisit_history())
                .build();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////PATIENTS REGISTRATION//////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/patientsRegistration")
    public List<DTO_PatientRegistration> getPatientRegistrations(@RequestParam(value = "sortBy", required = false) String sortBy) {
        return patientRegistrationService.getPatientRegistrations(sortBy).stream().map(this::asDto).collect(Collectors.toList());
    }


    @GetMapping("/patientsRegistration/{id}")
    public DTO_PatientRegistration getPatientRegistration(@PathVariable("id") Integer id) {
        return patientRegistrationService.getPatientRegistration(id).map(this::asDto).orElseThrow(ResourceNotFoundException::new);
    }


    @PostMapping("/patientsRegistration")
    public DTO_PatientRegistration addPatientRegistration(@RequestBody @Valid DTO_PatientRegistration dto_patientRegistration) {
        return asDto(
                patientRegistrationService.addPatientRegistration(
                        dto_patientRegistration.getDate_of_visit(), dto_patientRegistration.getDate_of_registration(), dto_patientRegistration.getPatient_id()));
    }


    @PutMapping("/patientsRegistration/{id}")
    public DTO_PatientRegistration updatePatientRegistration(@PathVariable("id") Integer id, @RequestBody @Valid DTO_PatientRegistration dto_patientRegistration) {
        return patientRegistrationService
                .updatePatientRegistration(
                        id, dto_patientRegistration.getDate_of_visit(), dto_patientRegistration.getDate_of_registration())
                .map(this::asDto)
                .orElseThrow(ResourceNotFoundException::new);
    }


    @DeleteMapping("/patientsRegistration/{id}")
    public void deletePatientRegistration(@PathVariable("id") Integer id) {
        patientRegistrationService.deletePatientRegistration(id);
    }


    public DTO_PatientRegistration asDto(PatientRegistration patientRegistration) {
        return DTO_PatientRegistration.builder()
                .id(patientRegistration.getId())
                .patient_id(patientRegistration.getId())
                .date_of_visit(patientRegistration.getDate_of_visit())
                .date_of_registration(patientRegistration.getDate_of_registration())
                .build();
    }

}
