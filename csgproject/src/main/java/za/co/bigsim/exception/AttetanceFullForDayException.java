package za.co.bigsim.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AttetanceFullForDayException  extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AttetanceFullForDayException(String message) {
        super(message);
    }
	
}
