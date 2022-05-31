package unicomer.backend.api.common;

/**
 * @author Kevin Candia
 * 28-05-2022
 */
public class Constants {

	public static final String END_UNICOMER = "/unicomer";

	public static final String VERSION = END_UNICOMER + "/v1";

	public static final String END_CUSTOMER = VERSION + "/customer";

	public static final String SEARCH = END_CUSTOMER + "/search";

	public static final String SEARCH_BY_ID = END_CUSTOMER + "/searchid";

	public static final String UPDATE_NAME = END_CUSTOMER + "/update-name";

	public static final String SEARCH_ALL = END_CUSTOMER + "/searchall";

	public static final String SAVE = END_CUSTOMER + "/save";

	public static final String DELETE = END_CUSTOMER + "/delete";

	public static final String NOT_FOUND = "Customer not exists";

	public static final String SUCCESS_SAVE = "Customer saved successfully.";

	public static final String SUCCESS_DELETE = "Customer removed successfully.";

	public static final String DEFAULT_PAGE = "0";

	public static final String DEFAULT_SIZE = "10";

	public static final String DEFAULT_ORDER = "idCustomer";

	public static final String DEFAULT_ASC = "true";

	private Constants() {
		throw new IllegalAccessError();
	}

}
