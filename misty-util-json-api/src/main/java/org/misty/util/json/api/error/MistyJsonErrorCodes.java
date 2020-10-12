package org.misty.util.json.api.error;

import org.misty.util.generic.GenericErrorDefinition;

public enum MistyJsonErrorCodes implements GenericErrorDefinition {
		
	;

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private final String errorCode;

	private final String errorMsg;

	/* [instance] constructor */

	MistyJsonErrorCodes(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	/* [instance] method */

	@Override
	public String getErrorCode() {
		return this.errorCode;
	}

	@Override
	public String getErrorMsg() {
		return this.errorMsg;
	}

	/* [instance] getter/setter */

}
