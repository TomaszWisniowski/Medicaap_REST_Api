/**
 * @author Tomasz Wiśniowski
 * @version 1.0
 * @since 5/04/22

 */

package pl.medicaap.tomaszwisniowski.DTO_model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class DTO_PatientRegistration {


    private int id;

    @NotEmpty(message = "patient_id must be not empty")
    private int patient_id;

    @NotEmpty(message = "Date of visit must be not empty")
    private LocalDate date_of_visit;

    @NotEmpty(message = "Date of registration must be not empty")
    private LocalDate date_of_registration;


}

