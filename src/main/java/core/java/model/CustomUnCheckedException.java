package core.java.model;

public class CustomUnCheckedException extends RuntimeException {

	private static final long serialVersionUID = -3532234464359254343L;
	private String errorDescription;
	
	public CustomUnCheckedException() {
	}
	
	
	public CustomUnCheckedException(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
	@Override
	public String toString() {
		if(null != errorDescription) {
			return errorDescription;
		}
		return "CustomUnCheckedException - Exception thrown";
	}
}