package org.misty.util.json.api.error;

import org.misty.util.generic.GenericErrorDefinition;

public enum MistyJsonErrorCodes implements GenericErrorDefinition<MistyJsonException> {
	NODE_CAST_ERROR("0001") //
	;

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private final String errorCode;

	private final String errorMsg;

	/* [instance] constructor */

	MistyJsonErrorCodes(String errorCode) {
		this.errorCode = errorCode;
		this.errorMsg = name();
	}

	MistyJsonErrorCodes(String errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	/* [instance] method */

	@Override
	public MistyJsonException pop() throws MistyJsonException {
		throw new MistyJsonException(this);
	}

	@Override
	public MistyJsonException pop(String msg) throws MistyJsonException {
		throw new MistyJsonException(this, msg);
	}

	@Override
	public MistyJsonException pop(Throwable cause) throws MistyJsonException {
		throw new MistyJsonException(this, cause);
	}

	@Override
	public MistyJsonException pop(String msg, Throwable cause) throws MistyJsonException {
		throw new MistyJsonException(this, msg, cause);
	}

	/* [instance] getter/setter */

	@Override
	public String getErrorCode() {
		return this.errorCode;
	}

	@Override
	public String getErrorMsg() {
		return this.errorMsg;
	}

}
