package org.misty.util.json.api.error;

import org.misty.util.generic.GenericErrorDefinition;

public enum MistyJsonErrors implements GenericErrorDefinition<MistyJsonException> {
	// 00 series is about check error
	NODE_CAST_ERROR("0001") //
	, SET_ERROR("0002") //
	;

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private final String errorType;

	private final String errorCode;

	private final String errorMsg;

	/* [instance] constructor */

	MistyJsonErrors(String errorCode) {
		this.errorType = GenericErrorDefinition.super.getErrorType();
		this.errorCode = errorCode;
		this.errorMsg = name();
	}

	MistyJsonErrors(String errorCode, String errorMsg) {
		this.errorType = GenericErrorDefinition.super.getErrorType();
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
	public String getErrorType() {
		return this.errorType;
	}

	@Override
	public String getErrorCode() {
		return this.errorCode;
	}

	@Override
	public String getErrorMsg() {
		return this.errorMsg;
	}

}
