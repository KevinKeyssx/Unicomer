package unicomer.backend.api.data;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Kevin Candia
 * 28-05-2022
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatchCustomerDTO implements Serializable {
    @JsonProperty("idCustomer")
    private Long idCustomer;

    @Size(min = 5, max = 50, message = "First Name must have a minimum of 5 and a maximum of 50 characters")
	@NotEmpty(message = "FirsName cannot be empty")
	@NotNull(message = "FirsName cannot be null")
    @JsonProperty("firstName")
    private String firstName;

    @Size(min = 5, max = 50, message = "LastName must have a minimum of 5 and a maximum of 50 characters")
	@NotEmpty(message = "LastName cannot be empty")
	@NotNull(message = "LastName cannot be null")
    @JsonProperty("lastName")
    private String lastName;

    @Size(min = 5, max = 15, message = "Cellphone must have a minimum of 5 and a maximum of 15 characters")
	@NotEmpty(message = "Cellphone cannot be empty")
	@NotNull(message = "Cellphone cannot be null")
    @JsonProperty("cellphone")
    private String cellphone;

    @Size(min = 5, max = 15, message = "Home Phone must have a minimum of 5 and a maximum of 15 characters")
    @JsonProperty("homePhone")
    private String homePhone;

    @Size(max = 255, message = "Address Home must have a maximum of 255 characters")
	@NotEmpty(message = "Address Home cannot be empty")
	@NotNull(message = "Address Home cannot be null")
    @JsonProperty("addressHome")
    private String addressHome;

    @Size(min = 5, max = 100, message = "Profession must have a minimum of 5 and a maximum of 100 characters")
	@NotEmpty(message = "Profession cannot be empty")
	@NotNull(message = "Profession cannot be null")
    @JsonProperty("profession")
    private String profession;

    @NotNull(message = "Incomes cannot be null")
    @JsonProperty("incomes")
    @Min(value = 1, message = "Incomes cannot have be less than 1")
    @Max(value = 1000000000, message = "Incomes cannot have be greater than 1.000.000.000")
    private Integer incomes;

    private static final long serialVersionUID = 1L;
}