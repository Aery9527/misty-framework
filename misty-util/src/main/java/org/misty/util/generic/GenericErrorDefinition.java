package org.misty.util.generic;

import org.misty.util.error.MistyException;

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
		return getErrorTypeCode() + "(" + getErrorMsg() + ")";
	}

	public ThrowableType thrown() throws ThrowableType;

	public ThrowableType thrown(String msg) throws ThrowableType;

	public ThrowableType thrown(Throwable cause) throws ThrowableType;

	public ThrowableType thrown(String msg, Throwable cause) throws ThrowableType;

	/* [instance] getter/setter */

}
