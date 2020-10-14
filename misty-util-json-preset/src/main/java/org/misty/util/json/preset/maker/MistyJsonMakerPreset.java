package org.misty.util.json.preset.maker;

import org.misty.util.json.api.maker.MistyJsonMaker;
import org.misty.util.json.api.node.MistyJsonArray;
import org.misty.util.json.api.node.MistyJsonObject;
import org.misty.util.json.api.node.MistyJsonValue;
import org.misty.util.json.preset.node.MistyJsonArrayPreset;
import org.misty.util.json.preset.node.MistyJsonObjectPreset;
import org.misty.util.json.preset.node.MistyJsonValueAbstract;

public class MistyJsonMakerPreset implements MistyJsonMaker {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	@Override
	public MistyJsonObject makeJsonObject() {
		return new MistyJsonObjectPreset();
	}

	@Override
	public MistyJsonArray makeJsonArray() {
		return new MistyJsonArrayPreset();
	}

	@Override
	public MistyJsonValue makeJsonValue() {
		return new MistyJsonValueAbstract();
	}

	/* [instance] getter/setter */

}
