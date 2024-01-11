package br.com.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceprion extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExceprion(String ex) {
		super(ex);
	}

}
