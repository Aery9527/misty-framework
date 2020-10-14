package org.misty.util.json.preset.node;

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
	public String toPrettyString() {
		// TODO Auto-generated method stub
		return null;
	}

	/* [instance] getter/setter */

	@Override
	public ValueType getValue() {
		return value;
	}

	public void setValue(ValueType value) {
		this.value = value;
	}

}
