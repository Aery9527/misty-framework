package org.misty.util.json.preset;

import org.misty.util.generic.GenericDescription;

public final class MistyUtilJsonPresetDescription implements GenericDescription {

	/* [static] field */

	public static final MistyUtilJsonPresetDescription INSTANCE = new MistyUtilJsonPresetDescription();

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	private MistyUtilJsonPresetDescription() {
	}

	/* [instance] method */

	@Override
	public String getName() {
		return "misty-util-json-preset";
	}

	@Override
	public String getVersion() {
		return "v0.0.0";
	}

	/* [instance] getter/setter */

}
