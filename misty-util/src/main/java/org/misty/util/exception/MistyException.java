package org.misty.util.exception;

@SuppressWarnings("serial")
public class MistyException extends RuntimeException {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private final String errorCode;

	private final String errorMsg;

	private final String connectedMsg;

	/* [instance] constructor */

	public MistyException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.connectedMsg = connectMsg();
	}

	public MistyException(String errorCode, String errorMsg, Throwable throwable) {
		super(throwable);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.connectedMsg = connectMsg();
	}

	/* [instance] method */

	@Override
	public String getMessage() {
		return this.connectedMsg;
	}

	//

	private String connectMsg() {
		return getClass().getSimpleName() + "(" + this.errorCode + ")(" + this.errorMsg + ")";
	}

	/* [instance] getter/setter */

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
