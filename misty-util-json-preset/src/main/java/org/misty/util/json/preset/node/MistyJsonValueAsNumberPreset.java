package org.misty.util.json.preset.node;

import java.math.BigDecimal;

import org.misty.util.json.api.node.MistyJsonValue;
import org.misty.util.json.api.node.MistyJsonValueAsNumber;

public class MistyJsonValueAsNumberPreset extends MistyJsonValueAbstract<Number> implements MistyJsonValueAsNumber {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	public MistyJsonValueAsNumberPreset(int value) {
		setValue(value);
	}

	public MistyJsonValueAsNumberPreset(long value) {
		setValue(value);
	}

	public MistyJsonValueAsNumberPreset(float value) {
		setValue(value);
	}

	public MistyJsonValueAsNumberPreset(double value) {
		setValue(value);
	}

	public MistyJsonValueAsNumberPreset(BigDecimal value) {
		setValue(value);
	}

	/* [instance] method */

	@Override
	public Class<? extends MistyJsonValue<?>> provideMainJsonValueInterface() {
		return MistyJsonValueAsNumber.class;
	}

	/* [instance] getter/setter */

	@Override
	public void setValue(int value) {
		super.setValue(value);
	}

	@Override
	public void setValue(long value) {
		super.setValue(value);
	}

	@Override
	public void setValue(float value) {
		super.setValue(value);
	}

	@Override
	public void setValue(double value) {
		super.setValue(value);
	}

	@Override
	public void setValue(BigDecimal value) {
		super.setValue(value);
	}

}
