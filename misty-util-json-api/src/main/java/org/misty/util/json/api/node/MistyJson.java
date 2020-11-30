package org.misty.util.json.api.node;

import org.misty.util.json.api.error.MistyJsonException;

public interface MistyJson {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	public boolean isJsonArray();

	public boolean isJsonObject();

	public boolean isJsonValue();

	public MistyJsonArray toJsonArray() throws MistyJsonException;

	public MistyJsonObject toJsonObject() throws MistyJsonException;

	public MistyJsonValue<?> toJsonValue() throws MistyJsonException;

	/* [instance] getter/setter */

}
