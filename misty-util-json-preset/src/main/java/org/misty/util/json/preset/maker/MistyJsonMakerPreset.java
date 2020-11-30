package org.misty.util.json.preset.maker;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.misty.util.generic.Examiner;
import org.misty.util.json.api.error.MistyJsonErrors;
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

	private MistyJsonAssembler jsonAssembler;

	/* [instance] constructor */

	public MistyJsonMakerPreset() {
		this.setting = new MistyJsonMakerSetting();
		this.setting.setJsonAssemblerClass("org.misty.util.json.preset.maker.MistyJsonAssemblerPreset");
		refreshSetting(this.setting);
	}

	public MistyJsonMakerPreset(MistyJsonMakerSetting setting) {
		this.setting = setting;
		refreshSetting(this.setting);
	}
	/* [instance] method */

	@Override
	public String toJsonString(MistyJson mistyJson) {
		String json = this.jsonAssembler.toJson(mistyJson);
		return json;
	}

	@Override
	public String toPrettyJsonString(MistyJson mistyJson) {
		String prettyString = this.jsonAssembler.toPrettyString(mistyJson);
		return prettyString;
	}

	@Override
	public <Type> Type fromJsonString(String json, Class<Type> type) {
		// TODO Auto-generated method stub
		return null;
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

	//

	public void refreshSetting(MistyJsonMakerSetting newSetting) {
		try {
			Examiner.refuseNullAndEmpty("newSetting", newSetting);

			boolean refreshAll = newSetting == this.setting;

			refresh(refreshAll, this.setting::getJsonAssemblerClass, newSetting::getJsonAssemblerClass,
					(jsonAssemblerClass) -> {
						this.jsonAssembler = refreshJsonAssembler(jsonAssemblerClass);
					});

		} catch (Exception e) {
			throw MistyJsonErrors.UNKNOWN_ERROR.thrown(e);
		}
	}

	public MistyJsonAssembler refreshJsonAssembler(String jsonAssemblerClass) {
		
	}

	public <SettingValue> void refresh(boolean refreshAll, Supplier<SettingValue> oldSupplier,
			Supplier<SettingValue> newSupplier, Consumer<SettingValue> action) {
		SettingValue oldValue = oldSupplier.get();
		SettingValue newValue = newSupplier.get();

		if (oldValue == null) {
			throw MistyJsonErrors.SETTING_REFRESH_ERROR
					.thrown("old setting value can't be null, please check initial function.");
		}

		if (newValue == null && refreshAll) {
			throw MistyJsonErrors.SETTING_REFRESH_ERROR
					.thrown("new setting value can't be null, please check initial function.");
		}

		if (newValue != null) {
			action.accept(newValue);
		}
	}

	/* [instance] getter/setter */

	@Override
	public MistyJsonMakerSetting getSetting() {
		MistyJsonMakerSetting setting = this.setting.clone();
		return setting;
	}

	@Override
	public void setSetting(MistyJsonMakerSetting setting) {
		MistyJsonMakerSetting newSetting = setting.clone();

		if (newSetting == setting) {
			throw MistyJsonErrors.SETTING_REFRESH_ERROR.thrown(
					MistyJsonMakerSetting.class.getSimpleName() + " cloned instance can't same the original instance!");
		}

		refreshSetting(newSetting);
		this.setting = newSetting;
	}

}
