package org.misty.util.exception;

import org.misty.util.generic.GenericErrorDefinition;

@SuppressWarnings("serial")
public class MistyException extends RuntimeException {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private final GenericErrorDefinition<?> errorDefinition;

	/* [instance] constructor */

	public MistyException(GenericErrorDefinition<?> errorDefinition) {
		super(errorDefinition.getErrorTypeCodeMsg());
		this.errorDefinition = errorDefinition;
	}

	public MistyException(GenericErrorDefinition<?> errorDefinition, String message) {
		super(message);
		this.errorDefinition = errorDefinition;
	}

	public MistyException(GenericErrorDefinition<?> errorDefinition, Throwable cause) {
		super(errorDefinition.getErrorTypeCodeMsg(), cause);
		this.errorDefinition = errorDefinition;
	}

	public MistyException(GenericErrorDefinition<?> errorDefinition, String message, Throwable cause) {
		super(message, cause);
		this.errorDefinition = errorDefinition;
	}

	/* [instance] method */

	/* [instance] getter/setter */

	public GenericErrorDefinition<?> getErrorDefinition() {
		return errorDefinition;
	}

}
