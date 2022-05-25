/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.medicaap.tomaszwisniowski.model.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query("FROM Patient ORDER BY first_name")
    List<Patient> findAllOrderByFirstName();

    @Query("FROM Patient ORDER BY last_name")
    List<Patient> findAllOrderByLastName();

    @Query("FROM Patient ORDER BY id")
    List<Patient> findAllOrderById();

    @Query("FROM Patient WHERE last_name = :last_name")
    List<Patient> findAllByLastName(@Param("last_name") String last_name);
}