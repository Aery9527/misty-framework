package org.misty.util.json.api.error;

import org.misty.util.error.MistyException;
import org.misty.util.generic.GenericErrorDefinition;

@SuppressWarnings("serial")
public class MistyJsonException extends MistyException {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	public MistyJsonException(GenericErrorDefinition<?> errorDefinition) {
		super(errorDefinition);
	}

	public MistyJsonException(GenericErrorDefinition<?> errorDefinition, String message) {
		super(errorDefinition, message);
	}

	public MistyJsonException(GenericErrorDefinition<?> errorDefinition, Throwable cause) {
		super(errorDefinition, cause);
	}

	public MistyJsonException(GenericErrorDefinition<?> errorDefinition, String message, Throwable cause) {
		super(errorDefinition, message, cause);
	}

	/* [instance] method */

	/* [instance] getter/setter */

}
