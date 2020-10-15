package org.misty.util.json.api.node;

import java.util.Collection;

import org.misty.util.json.api.error.MistyJsonErrors;
import org.misty.util.json.api.error.MistyJsonException;

public interface MistyJsonArray extends MistyJson, Collection<MistyJson> {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	@Override
	public default boolean isJsonArray() {
		return true;
	}

	@Override
	public default boolean isJsonObject() {
		return false;
	}

	@Override
	public default boolean isJsonValue() {
		return false;
	}

	@Override
	public default MistyJsonArray toJsonArray() throws MistyJsonException {
		return this;
	}

	@Override
	public default MistyJsonObject toJsonObject() throws MistyJsonException {
		throw MistyJsonErrors.NODE_CAST_ERROR.pop();
	}

	@Override
	public default MistyJsonValue<?> toJsonValue() throws MistyJsonException {
		throw MistyJsonErrors.NODE_CAST_ERROR.pop();
	}

	/* [instance] getter/setter */

}
