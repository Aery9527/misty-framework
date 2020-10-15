package org.misty.util.json.api.node;

import org.misty.util.json.api.error.MistyJsonErrors;
import org.misty.util.json.api.error.MistyJsonException;

public interface MistyJsonValue<ValueType> extends MistyJson {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	@Override
	public default boolean isJsonArray() {
		return false;
	}

	@Override
	public default boolean isJsonObject() {
		return false;
	}

	@Override
	public default boolean isJsonValue() {
		return true;
	}

	@Override
	public default MistyJsonArray toJsonArray() throws MistyJsonException {
		throw MistyJsonErrors.NODE_CAST_ERROR.pop();
	}

	@Override
	public default MistyJsonObject toJsonObject() throws MistyJsonException {
		throw MistyJsonErrors.NODE_CAST_ERROR.pop();
	}

	@Override
	public default MistyJsonValue<?> toJsonValue() throws MistyJsonException {
		return this;
	}

	//

	public boolean isBooleanValue();

	public boolean isNullValue();

	public boolean isNumberValue();

	public boolean isStringValue();

	public MistyJsonValueAsBoolean toBooleanValue();

	public MistyJsonValueAsNull toNullValue();

	public MistyJsonValueAsNumber toNumberValue();

	public MistyJsonValueAsString toStringValue();

	//

	public ValueType getValue();

	/* [instance] getter/setter */

}
