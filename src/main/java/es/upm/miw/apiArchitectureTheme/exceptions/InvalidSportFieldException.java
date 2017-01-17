package es.upm.miw.apiArchitectureTheme.exceptions;

public class InvalidSportFieldException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public interface ReasonCodes {
		String NOT_EMPTY = "El nombre de deporte no puede ser vacio";
		String INVALID_NAME = "No existe el nombre de deporte dado." ;
	}

	public InvalidSportFieldException(String reasonCode) {
		super(reasonCode);
	}

	public InvalidSportFieldException() {
		this("");
	}

}
