package org.misty.util.json.preset.node;

import org.misty.util.json.api.error.MistyJsonErrors;
import org.misty.util.json.api.node.MistyJsonValue;

public abstract class MistyJsonValueAbstract<ValueType> extends MistyJsonAbstract implements MistyJsonValue<ValueType> {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private ValueType value;

	/* [instance] constructor */

	/* [instance] method */

	@Override
	public String getString() {
		return this.value.toString();
	}

	//

	public void check(ValueType value) {
		if (value == null) {
			throw MistyJsonErrors.SET_ERROR
					.thrown("can't set null into " + provideMainJsonValueInterface().getSimpleName());
		}
	}

	public abstract Class<? extends MistyJsonValue<?>> provideMainJsonValueInterface();

	/* [instance] getter/setter */

	@Override
	public ValueType getValue() {
		return value;
	}

	public void setValue(ValueType value) {
		check(value);
		this.value = value;
	}

}
