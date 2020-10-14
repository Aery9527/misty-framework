package org.misty.util.json.api.node;

import org.misty.util.json.api.error.MistyJsonException;

public interface MistyJson {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	public boolean isJsonObject();

	public boolean isJsonArray();

	public boolean isJsonValue();

	public MistyJsonObject toJsonObject() throws MistyJsonException;

	public MistyJsonArray toJsonArray() throws MistyJsonException;

	public MistyJsonValue<?> toJsonValue() throws MistyJsonException;

	//

	public String toString();

	public String toPrettyString();

	/* [instance] getter/setter */

}
