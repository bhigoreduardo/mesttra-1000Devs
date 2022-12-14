package br.com.autopecas.domain.exception;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = -4281907428419333334L;

	public NegocioException(String message) {
		super(message);
	}

}
