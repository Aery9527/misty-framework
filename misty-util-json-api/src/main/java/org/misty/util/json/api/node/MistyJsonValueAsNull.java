package org.misty.util.json.api.node;

import org.misty.util.json.api.error.MistyJsonErrors;

public interface MistyJsonValueAsNull extends MistyJsonValue<Void> {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	@Override
	public default boolean isNullValue() {
		return true;
	}

	@Override
	public default boolean isStringValue() {
		return false;
	}

	@Override
	public default boolean isNumberValue() {
		return false;
	}

	@Override
	public default MistyJsonValueAsNull toNullValue() {
		return this;
	}

	@Override
	public default MistyJsonValueAsString toStringValue() {
		throw MistyJsonErrors.NODE_CAST_ERROR.pop();
	}

	@Override
	public default MistyJsonValueAsNumber toNumberValue() {
		throw MistyJsonErrors.NODE_CAST_ERROR.pop();
	}

	/* [instance] getter/setter */

}
