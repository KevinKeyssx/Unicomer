package unicomer.backend.api.common;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * @author Kevin Candia
 * 28-05-2022
 */
public class Util implements Serializable {

    private static final long serialVersionUID = 1L;

    public Util(Boolean value) {
        if (Boolean.FALSE.equals(value)) {
            throw new IllegalAccessError("Ilegal access.");
        }
    }

    public HttpStatus typeStatus(Object object){
        return object == null || object.toString().equals("[]") ||  object.toString().isBlank() ? 
            HttpStatus.NO_CONTENT: HttpStatus.OK;
    }

    public boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }

    public boolean isLong(String value) {
        try {
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }

    public Long asLong(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException excepcion) {
            return null;
        }
    }

}
