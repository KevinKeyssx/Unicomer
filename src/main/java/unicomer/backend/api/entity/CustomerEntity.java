package unicomer.backend.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unicomer.backend.api.common.ConstantsDB;
import unicomer.backend.api.data.Gender;

/**
 * @author Kevin Candia
 * 28-05-2022
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = ConstantsDB.CUSTOMER_TABLE, schema = ConstantsDB.SCHEMA)
public class CustomerEntity implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_customer", nullable = false)
    private Long idCustomer;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "gender", nullable = false, length = 20)
    private Gender gender;

    @Column(name = "cellphone", nullable = false, length = 15)
    private String cellphone;

    @Column(name = "home_phone", nullable = true, length = 15)
    private String homePhone;

    @Column(name = "address_home", nullable = false, length = 255)
    private String addressHome;

    @Column(name = "profession", nullable = false, length = 100)
    private String profession;

    @Column(name = "incomes", nullable = false)
    private Integer incomes;

    private static final long serialVersionUID = 1L;

}