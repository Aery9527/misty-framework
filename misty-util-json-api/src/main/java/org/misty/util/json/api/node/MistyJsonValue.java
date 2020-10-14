package org.misty.util.json.api.node;

import org.misty.util.json.api.error.MistyJsonErrorCodes;
import org.misty.util.json.api.error.MistyJsonException;

public interface MistyJsonValue extends MistyJson {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	@Override
	public default boolean isJsonObject() {
		return false;
	}

	@Override
	public default boolean isJsonArray() {
		return false;
	}

	@Override
	public default boolean isJsonValue() {
		return true;
	}

	@Override
	public default MistyJsonObject toJsonObject() throws MistyJsonException {
		throw MistyJsonErrorCodes.NODE_CAST_ERROR.pop();
	}

	@Override
	public default MistyJsonArray toJsonArray() throws MistyJsonException {
		throw MistyJsonErrorCodes.NODE_CAST_ERROR.pop();
	}

	@Override
	public default MistyJsonValue toJsonValue() throws MistyJsonException {
		return this;
	}
	
	//
	
	public int toInt();

	/* [instance] getter/setter */

}
