package org.misty.util.json.api.node;

import org.misty.util.json.api.error.MistyJsonErrors;

public interface MistyJsonValueAsBoolean extends MistyJsonValue<Boolean> {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	@Override
	public default boolean isBooleanValue() {
		return true;
	}

	@Override
	public default boolean isNullValue() {
		return false;
	}

	@Override
	public default boolean isNumberValue() {
		return false;
	}

	@Override
	public default boolean isStringValue() {
		return false;
	}

	@Override
	public default MistyJsonValueAsBoolean toBooleanValue() {
		return this;
	}

	@Override
	public default MistyJsonValueAsNull toNullValue() {
		throw MistyJsonErrors.NODE_CAST_ERROR.thrown();
	}

	@Override
	public default MistyJsonValueAsNumber toNumberValue() {
		throw MistyJsonErrors.NODE_CAST_ERROR.thrown();
	}

	@Override
	public default MistyJsonValueAsString toStringValue() {
		throw MistyJsonErrors.NODE_CAST_ERROR.thrown();
	}

	/* [instance] getter/setter */

	public void setValue(boolean value);

}
