package org.misty.util.generic;

import org.misty.util.exception.MistyException;

public interface GenericErrorDefinition<ThrowableType extends MistyException> {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	public default String getErrorType() {
		String className = getClass().getSimpleName();

		String type = "";
		for (char c : className.toCharArray()) {
			if (c >= 65 && c <= 90) { // A~Z
				type += c;
			}
		}

		return type;
	}

	public String getErrorCode();

	public String getErrorMsg();

	public default String getErrorTypeCode() {
		return getErrorType() + "-" + getErrorCode();
	}

	public default String getErrorTypeCodeMsg() {
		return getErrorTypeCode() + ":" + getErrorMsg();
	}

	public ThrowableType pop();

	public ThrowableType pop(String msg);

	public ThrowableType pop(Throwable cause);

	public ThrowableType pop(String msg, Throwable cause);

	/* [instance] getter/setter */

}
