package org.misty.util.json.api.node;

import java.math.BigDecimal;

import org.misty.util.json.api.error.MistyJsonErrors;

public interface MistyJsonValueAsNumber extends MistyJsonValue<Number> {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	@Override
	public default boolean isBooleanValue() {
		return false;
	}

	@Override
	public default boolean isNullValue() {
		return false;
	}

	@Override
	public default boolean isNumberValue() {
		return true;
	}

	@Override
	public default boolean isStringValue() {
		return false;
	}

	@Override
	public default MistyJsonValueAsBoolean toBooleanValue() {
		throw MistyJsonErrors.NODE_CAST_ERROR.thrown();
	}

	@Override
	public default MistyJsonValueAsNull toNullValue() {
		throw MistyJsonErrors.NODE_CAST_ERROR.thrown();
	}

	@Override
	public default MistyJsonValueAsNumber toNumberValue() {
		return this;
	}

	@Override
	public default MistyJsonValueAsString toStringValue() {
		throw MistyJsonErrors.NODE_CAST_ERROR.thrown();
	}

	/* [instance] getter/setter */

	public void setValue(int value);

	public void setValue(long value);

	public void setValue(float value);

	public void setValue(double value);

	public void setValue(BigDecimal value);

}
