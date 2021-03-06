package org.misty.util.json.preset.node;

import org.misty.util.json.api.node.MistyJsonValue;
import org.misty.util.json.api.node.MistyJsonValueAsString;

public class MistyJsonValueAsStringPreset extends MistyJsonValueAbstract<String> implements MistyJsonValueAsString {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	public MistyJsonValueAsStringPreset(String value) {
		setValue(value);
	}

	/* [instance] method */

	@Override
	public Class<? extends MistyJsonValue<?>> provideMainJsonValueInterface() {
		return MistyJsonValueAsString.class;
	}

	/* [instance] getter/setter */

}
