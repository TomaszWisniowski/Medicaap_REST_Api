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
import pl.medicaap.tomaszwisniowski.model.Nurse;

import java.util.List;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Integer> {

    @Query("FROM Nurse ORDER BY first_name")
    List<Nurse> findAllOrderByFirstName();

    @Query("FROM Nurse ORDER BY last_name")
    List<Nurse> findAllOrderByLastName();

    @Query("FROM Nurse ORDER BY id")
    List<Nurse> findAllOrderById();

    @Query("FROM Nurse WHERE last_name = :last_name")
    List<Nurse> findAllByLastName(@Param("last_name") String last_name);
}