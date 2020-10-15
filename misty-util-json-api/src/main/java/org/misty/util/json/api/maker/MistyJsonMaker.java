package org.misty.util.json.api.maker;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.misty.util.json.api.node.MistyJsonArray;
import org.misty.util.json.api.node.MistyJsonObject;
import org.misty.util.json.api.node.MistyJsonValueAsBoolean;
import org.misty.util.json.api.node.MistyJsonValueAsNull;
import org.misty.util.json.api.node.MistyJsonValueAsNumber;
import org.misty.util.json.api.node.MistyJsonValueAsString;

public interface MistyJsonMaker {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	// series of JsonArray

	public MistyJsonArray makeArray();

	public MistyJsonArray makeArray(Collection<?> collection);

	public MistyJsonArray makeArray(Object... collection);

	// series of JsonObject

	public MistyJsonObject makeObject();

	public MistyJsonObject makeObject(Object rawObject);

	public MistyJsonObject makeObject(Map<String, Object> map);

	public MistyJsonObject makeObjectWithSort(Comparator<String> comparator);

	public MistyJsonObject makeObjectWithSort(Comparator<String> comparator, Object rawObject);

	public MistyJsonObject makeObjectWithSort(Comparator<String> comparator, Map<String, Object> map);

	// series of JsonValue

	public MistyJsonValueAsBoolean makeBoolean(boolean value);

	public MistyJsonValueAsNull makeNull();

	public MistyJsonValueAsNumber makeNumber(int value);

	public MistyJsonValueAsNumber makeNumber(long value);

	public MistyJsonValueAsNumber makeNumber(float value);

	public MistyJsonValueAsNumber makeNumber(double value);

	public MistyJsonValueAsNumber makeNumber(BigDecimal value);

	public MistyJsonValueAsString makeString(String value);

	/* [instance] getter/setter */

}
