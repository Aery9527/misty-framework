package org.misty.util.json.api.node;

import java.util.Map;

import org.misty.util.json.api.error.MistyJsonErrors;
import org.misty.util.json.api.error.MistyJsonException;

public interface MistyJsonObject extends MistyJson, Map<String, MistyJson> {

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
		return true;
	}

	@Override
	public default boolean isJsonValue() {
		return false;
	}

	@Override
	public default MistyJsonArray toJsonArray() throws MistyJsonException {
		throw MistyJsonErrors.NODE_CAST_ERROR.thrown();
	}

	@Override
	public default MistyJsonObject toJsonObject() throws MistyJsonException {
		return this;
	}

	@Override
	public default MistyJsonValue<?> toJsonValue() throws MistyJsonException {
		throw MistyJsonErrors.NODE_CAST_ERROR.thrown();
	}

	public boolean isSequenceable();
	
	/* [instance] getter/setter */

}
