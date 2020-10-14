package org.misty.util.json.api.node;

import org.misty.util.json.api.error.MistyJsonErrors;

public interface MistyJsonValueAsNumber extends MistyJsonValue<Number> {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	@Override
	public default boolean isNullValue() {
		return false;
	}

	@Override
	public default boolean isStringValue() {
		return false;
	}

	@Override
	public default boolean isNumberValue() {
		return true;
	}

	@Override
	public default MistyJsonValueAsNull toNullValue() {
		throw MistyJsonErrors.NODE_CAST_ERROR.pop();
	}

	@Override
	public default MistyJsonValueAsString toStringValue() {
		throw MistyJsonErrors.NODE_CAST_ERROR.pop();
	}

	@Override
	public default MistyJsonValueAsNumber toNumberValue() {
		return this;
	}

	/* [instance] getter/setter */

}
