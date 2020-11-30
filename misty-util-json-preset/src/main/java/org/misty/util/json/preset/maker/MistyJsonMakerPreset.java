package org.misty.util.json.preset.maker;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.misty.util.generic.Examiner;
import org.misty.util.json.api.maker.MistyJsonMaker;
import org.misty.util.json.api.maker.setting.MistyJsonAssembler;
import org.misty.util.json.api.maker.setting.MistyJsonMakerSetting;
import org.misty.util.json.api.node.MistyJson;
import org.misty.util.json.api.node.MistyJsonArray;
import org.misty.util.json.api.node.MistyJsonObject;
import org.misty.util.json.api.node.MistyJsonValueAsBoolean;
import org.misty.util.json.api.node.MistyJsonValueAsNull;
import org.misty.util.json.api.node.MistyJsonValueAsNumber;
import org.misty.util.json.api.node.MistyJsonValueAsString;
import org.misty.util.json.preset.node.MistyJsonArrayPreset;
import org.misty.util.json.preset.node.MistyJsonObjectPreset;
import org.misty.util.json.preset.node.MistyJsonValueAsBooleanPreset;
import org.misty.util.json.preset.node.MistyJsonValueAsNullPreset;
import org.misty.util.json.preset.node.MistyJsonValueAsNumberPreset;
import org.misty.util.json.preset.node.MistyJsonValueAsStringPreset;

public class MistyJsonMakerPreset implements MistyJsonMaker {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private MistyJsonMakerSetting setting;

	/* [instance] constructor */

	public MistyJsonMakerPreset() {
		this.setting = new MistyJsonMakerSetting();
		this.setting.setJsonAssembler(new MistyJsonAssemblerPreset());
	}

	/* [instance] method */

	@Override
	public String toJsonString(MistyJson mistyJson) {
		MistyJsonAssembler jsonAssembler = this.setting.getJsonAssembler();
		String json = jsonAssembler.toJson(mistyJson);
		return json;
	}

	@Override
	public String toPrettyJsonString(MistyJson mistyJson) {
		MistyJsonAssembler jsonAssembler = this.setting.getJsonAssembler();
		String prettyString = jsonAssembler.toPrettyString(mistyJson);
		return prettyString;
	}

	// series of JsonArray

	@Override
	public MistyJsonArray makeArray() {
		return new MistyJsonArrayPreset();
	}

	@Override
	public MistyJsonArray makeArray(Collection<?> collection) {
		return null;
	}

	@Override
	public MistyJsonArray makeArray(Object... collection) {
		return null;
	}

	// series of JsonObject

	@Override
	public MistyJsonObject makeObject() {
		return new MistyJsonObjectPreset();
	}

	@Override
	public MistyJsonObject makeObject(Object rawObject) {
		return null;
	}

	@Override
	public MistyJsonObject makeObject(Map<String, Object> map) {
		return null;
	}

	@Override
	public MistyJsonObject makeObjectWithSort(Comparator<String> comparator) {
		return new MistyJsonObjectPreset(comparator);
	}

	@Override
	public MistyJsonObject makeObjectWithSort(Comparator<String> comparator, Object rawObject) {
		return null;
	}

	@Override
	public MistyJsonObject makeObjectWithSort(Comparator<String> comparator, Map<String, Object> map) {
		return null;
	}

	// series of JsonValue

	@Override
	public MistyJsonValueAsBoolean makeBoolean(boolean value) {
		return new MistyJsonValueAsBooleanPreset(value);
	}

	@Override
	public MistyJsonValueAsNull makeNull() {
		return MistyJsonValueAsNullPreset.SINGLETON;
	}

	@Override
	public MistyJsonValueAsNumber makeNumber(int value) {
		return new MistyJsonValueAsNumberPreset(value);
	}

	@Override
	public MistyJsonValueAsNumber makeNumber(long value) {
		return new MistyJsonValueAsNumberPreset(value);
	}

	@Override
	public MistyJsonValueAsNumber makeNumber(float value) {
		return new MistyJsonValueAsNumberPreset(value);
	}

	@Override
	public MistyJsonValueAsNumber makeNumber(double value) {
		return new MistyJsonValueAsNumberPreset(value);
	}

	@Override
	public MistyJsonValueAsNumber makeNumber(BigDecimal value) {
		return new MistyJsonValueAsNumberPreset(value);
	}

	@Override
	public MistyJsonValueAsString makeString(String value) {
		return new MistyJsonValueAsStringPreset(value);
	}

	/* [instance] getter/setter */

	@Override
	public MistyJsonMakerSetting getSetting() {
		return this.setting;
	}

	@Override
	public void setSetting(MistyJsonMakerSetting setting) {
		Examiner.refuseNullAndEmpty("setting", setting);
		this.setting = setting;
	}

}
