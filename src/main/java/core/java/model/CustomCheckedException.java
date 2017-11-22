package core.java.model;

public class CustomCheckedException extends Exception {

	private static final long serialVersionUID = 2373186207227495043L;
	private String errorDescription;
	
	public CustomCheckedException() {
	}
	
	
	public CustomCheckedException(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	@Override
	public String toString() {
		if(null != errorDescription) {
			return errorDescription;
		}
		return "CustomCheckedException - Exception thrown";
	}
}
