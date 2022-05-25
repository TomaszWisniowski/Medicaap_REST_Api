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

public class DTO_Doctor {


    private int id;

    @NotEmpty(message = "medical_license_number must be not empty")
    private int medical_license_number;

    @NotEmpty(message = "first_name must be not empty")
    private String first_name;

    @NotEmpty(message = "last_name must be not empty")
    private String last_name;

    @NotEmpty(message = "date_of_birth must be not empty")
    private LocalDate date_of_birth;

    @NotEmpty(message = "telephone number must be not empty")
    private int tel;

    @NotEmpty(message = "city must be not empty")
    private String city;

    @NotEmpty(message = "street must be not empty")
    private String street;

    @NotEmpty(message = "house_number must be not empty")
    private int house_number;

    @NotEmpty(message = "flat_number must be not empty")
    private int flat_number;
}
