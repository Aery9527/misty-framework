package org.misty.util.json.preset.node;

import org.misty.util.json.api.node.MistyJsonValue;
import org.misty.util.json.api.node.MistyJsonValueAsBoolean;

public class MistyJsonValueAsBooleanPreset extends MistyJsonValueAbstract<Boolean> implements MistyJsonValueAsBoolean {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	public MistyJsonValueAsBooleanPreset(boolean value) {
		super.setValue(value);
	}

	/* [instance] method */

	@Override
	public Class<? extends MistyJsonValue<?>> provideMainJsonValueInterface() {
		return MistyJsonValueAsBoolean.class;
	}

	/* [instance] getter/setter */

	@Override
	public void setValue(boolean value) {
		super.setValue(value);
	}

}
