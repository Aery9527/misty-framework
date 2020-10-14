package org.misty.util.json.api;

import org.misty.util.generic.GenericDescription;

public final class MistyUtilJsonApiDescription implements GenericDescription {

	/* [static] field */

	public static final MistyUtilJsonApiDescription INSTANCE = new MistyUtilJsonApiDescription();

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	private MistyUtilJsonApiDescription() {
	}

	/* [instance] method */

	@Override
	public String getName() {
		return "misty-util-json-api";
	}

	@Override
	public String getVersion() {
		return "v0.0.0";
	}

	/* [instance] getter/setter */

}
