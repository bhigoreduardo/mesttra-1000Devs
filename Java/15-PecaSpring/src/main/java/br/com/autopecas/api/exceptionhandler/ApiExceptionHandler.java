package br.com.autopecas.api.exceptionhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.autopecas.domain.exception.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler {

	private final Integer FIRST_ERROR = 0;
	private final String USER_MESSAGE = "Ocorreu um erro interno inesperado, aguarde e tente novamente mais tarde, se o "
			+ "erro persistir contacte o administrador do sistema.";

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class })
	public @ResponseBody List<FieldErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		List<FieldErrorDTO> fields = new ArrayList<FieldErrorDTO>();

		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String internalError = error.getCodes()[FIRST_ERROR];
			String fieldName = internalError.substring(internalError.lastIndexOf(".") + 1, internalError.length());

			fields.add(new FieldErrorDTO(fieldName, error.getDefaultMessage()));
		}

		return fields;
	}

	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler({ NegocioException.class })
	public @ResponseBody ErrorDTO handleNegocioException(Exception ex) {
		return new ErrorDTO(ex.getMessage());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class, RuntimeException.class })
	public @ResponseBody ErrorDTO handleException(Exception ex) {
		return new ErrorDTO(USER_MESSAGE);
	}

}
