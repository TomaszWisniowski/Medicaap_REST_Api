/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.medicaap.tomaszwisniowski.model.Doctor;
import pl.medicaap.tomaszwisniowski.repository.DoctorRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(int medical_license_number, String first_name, String last_name, LocalDate date_of_birth, int tel, String city, String street, int house_number, int flat_number) {
        Doctor doctor = Doctor.builder()
                .medical_license_number(medical_license_number)
                .first_name(first_name)
                .last_name(last_name)
                .date_of_birth(date_of_birth)
                .tel(tel)
                .city(city)
                .street(street)
                .house_number(house_number)
                .flat_number(flat_number)
                .build();
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctors(String sortBy) {
        if ("id".equals(sortBy)) {
            return doctorRepository.findAllOrderById();
        } else if ("first_name".equals(sortBy)) {
            return doctorRepository.findAllOrderByFirstName();
        } else if ("last_name".equals(sortBy)) {
            return doctorRepository.findAllOrderByLastName();
        } else {
            return doctorRepository.findAll();
        }
    }

    public Optional<Doctor> getDoctor(int id) {
        return doctorRepository.findById(id);
    }

    public Optional<Doctor> updateDoctor(int id, int medical_license_number, String first_name, String last_name, LocalDate date_of_birth, int tel, String city, String street, int house_number, int flat_number) {
        Doctor doctor = Doctor.builder()
                .id(id)
                .medical_license_number(medical_license_number)
                .first_name(first_name)
                .last_name(last_name)
                .date_of_birth(date_of_birth)
                .tel(tel)
                .city(city)
                .street(street)
                .house_number(house_number)
                .flat_number(flat_number)
                .build();
        return doctorRepository
                .findById(id)
                .map(savedCustomer -> doctorRepository.save(doctor));
    }

    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
    }
}
