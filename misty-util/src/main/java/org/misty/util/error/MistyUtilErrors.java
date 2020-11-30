package org.misty.util.error;

import org.misty.util.generic.GenericErrorDefinition;

public enum MistyUtilErrors implements GenericErrorDefinition<MistyException> {
	ARGUMENT_CHECK_ERROR("0001") //
	;

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private final String errorType;

	private final String errorCode;

	private final String errorMsg;

	/* [instance] constructor */

	MistyUtilErrors(String errorCode) {
		this.errorType = GenericErrorDefinition.super.getErrorType();
		this.errorCode = errorCode;
		this.errorMsg = name();
	}

	MistyUtilErrors(String errorCode, String errorMsg) {
		this.errorType = GenericErrorDefinition.super.getErrorType();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	/* [instance] method */

	@Override
	public MistyException thrown() throws MistyException {
		throw new MistyException(this);
	}

	@Override
	public MistyException thrown(String msg) throws MistyException {
		throw new MistyException(this, msg);
	}

	@Override
	public MistyException thrown(Throwable cause) throws MistyException {
		throw new MistyException(this, cause);
	}

	@Override
	public MistyException thrown(String msg, Throwable cause) throws MistyException {
		throw new MistyException(this, msg, cause);
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
