package es.upm.miw.apiArchitectureTheme.exceptions;

public class InvalidUserFieldException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public interface ReasonCodes {
	   String INVALID_EMAIL = "Formato de correo inválido.";
	   String INICK_ALREADY_EXISTS = "El usuario ya existe.";
	}

	public InvalidUserFieldException(String reasonCode) {
		super(reasonCode);
	}

	public InvalidUserFieldException() {
		this("");
	}

}
