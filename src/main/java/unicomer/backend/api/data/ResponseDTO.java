/**
 * SmartNewGen exclusive class, all rights reserved
 */
package unicomer.backend.api.data;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * @author Kevin Candia
 * 28-05-2022
 */
@Data
@AllArgsConstructor
public class ResponseDTO implements Serializable {

    private String data;

    private Date date;

    private static final long serialVersionUID = 1L;

}