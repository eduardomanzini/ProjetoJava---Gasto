package com.teste.exeptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {


	@Serial
	private static final long serialVersionUID = -439892685793517584L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
}
