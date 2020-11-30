package org.misty.util.json.api.maker.setting;

import org.misty.util.json.api.error.MistyJsonErrors;
import org.misty.util.json.api.node.MistyJson;
import org.misty.util.json.api.node.MistyJsonArray;
import org.misty.util.json.api.node.MistyJsonObject;
import org.misty.util.json.api.node.MistyJsonValue;

public interface MistyJsonAssembler {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	public default String toJson(MistyJson json) {
		if (json.isJsonArray()) {
			return toJson(json.toJsonArray());

		} else if (json.isJsonObject()) {
			return toJson(json.toJsonObject());

		} else if (json.isJsonValue()) {
			return toJson(json.toJsonValue());

		} else {
			throw MistyJsonErrors.UNHANDLED_JSON_TYPE.thrown(json.getClass().toString());
		}
	}

	public String toJson(MistyJsonArray jsonArray);

	public String toJson(MistyJsonObject jsonObject);

	public String toJson(MistyJsonValue<?> jsonValue);

	public default String toPrettyString(MistyJson json) {
		if (json.isJsonArray()) {
			return toPrettyString(json.toJsonArray());

		} else if (json.isJsonObject()) {
			return toPrettyString(json.toJsonObject());

		} else if (json.isJsonValue()) {
			return toPrettyString(json.toJsonValue());

		} else {
			throw MistyJsonErrors.UNHANDLED_JSON_TYPE.thrown(json.getClass().toString());
		}
	}

	public String toPrettyString(MistyJsonArray jsonArray);

	public String toPrettyString(MistyJsonObject jsonObject);

	public String toPrettyString(MistyJsonValue<?> jsonValue);

	/* [instance] getter/setter */

}
