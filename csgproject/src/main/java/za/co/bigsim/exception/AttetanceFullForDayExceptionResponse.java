package za.co.bigsim.exception;

public class AttetanceFullForDayExceptionResponse {

	private String name;
	
	public AttetanceFullForDayExceptionResponse(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
