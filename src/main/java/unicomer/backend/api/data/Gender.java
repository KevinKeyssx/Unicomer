package unicomer.backend.api.data;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Kevin Candia
 * 28-05-2022
 */
public enum Gender {

    MUJER("Mujer"),
	HOMBRE("Hombre"),
	OTRO("Otro");

    private String code;

	private Gender(String code) {
		this.code = code;
	}

	@JsonValue
	public String getCode() {
		return code;
	}

}