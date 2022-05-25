/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "doctors")
    public class Doctor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "medical_license_number")
        private int medical_license_number;

        @Column(name = "first_name")
        private String first_name;

        @Column(name = "last_name")
        private String last_name;

        @Column(name = "date_of_birth")
        private LocalDate date_of_birth;

        @Column(name = "tel")
        private int tel;

        @Column(name = "city")
        private String city;

        @Column(name = "street")
        private String street;

        @Column(name = "house_number")
        private int house_number;

        @Column(name = "flat_number")
        private int flat_number;
}
