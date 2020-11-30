package org.misty.util.json.api.error;

import org.misty.util.generic.GenericErrorDefinition;

public enum MistyJsonErrors implements GenericErrorDefinition<MistyJsonException> {
	// 00 series is about check error
	SET_ERROR("00" + "01") //
	, UNHANDLED_JSON_TYPE("00" + "02") //
	, SETTING_REFRESH_ERROR("00" + "03") //
	// 10 series is about cast error
	, NODE_CAST_ERROR("10" + "01") //
	// 99 series is about unknown error
	, UNKNOWN_ERROR("99" + "00") //
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
	public MistyJsonException thrown() throws MistyJsonException {
		throw new MistyJsonException(this);
	}

	@Override
	public MistyJsonException thrown(String msg) throws MistyJsonException {
		throw new MistyJsonException(this, msg);
	}

	@Override
	public MistyJsonException thrown(Throwable cause) throws MistyJsonException {
		throw new MistyJsonException(this, cause);
	}

	@Override
	public MistyJsonException thrown(String msg, Throwable cause) throws MistyJsonException {
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
