package org.misty.util.json.preset.node;

import org.misty.util.json.api.error.MistyJsonErrors;
import org.misty.util.json.api.node.MistyJsonValue;
import org.misty.util.json.api.node.MistyJsonValueAsNull;

public class MistyJsonValueAsNullPreset extends MistyJsonValueAbstract<Void> implements MistyJsonValueAsNull {

	/* [static] field */

	public static final MistyJsonValueAsNullPreset SINGLETON = new MistyJsonValueAsNullPreset();

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	private MistyJsonValueAsNullPreset() {
	}

	/* [instance] method */

	@Override
	public Class<? extends MistyJsonValue<?>> provideMainJsonValueInterface() {
		return MistyJsonValueAsNull.class;
	}

	@Override
	public void setValue(Void value) {
		throw MistyJsonErrors.SET_ERROR
				.thrown("can't set value into " + provideMainJsonValueInterface().getSimpleName());
	}

	/* [instance] getter/setter */

}
