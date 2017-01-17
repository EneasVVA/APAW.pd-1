package es.upm.miw.apiArchitectureTheme.exceptions;

public class SportAlreadyExistsFieldException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public interface ReasonCodes {
		String ALREADY_EXISTS = "El nombre del deporte ya existe" ;
	}

	public SportAlreadyExistsFieldException(String reasonCode) {
		super(reasonCode);
	}

	public SportAlreadyExistsFieldException() {
		this("");
	}

}
