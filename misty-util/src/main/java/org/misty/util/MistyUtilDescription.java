package org.misty.util;

import org.misty.util.generic.GenericDescription;

public final class MistyUtilDescription implements GenericDescription {

	/* [static] field */

	public static final MistyUtilDescription INSTANCE = new MistyUtilDescription();

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	private MistyUtilDescription() {
	}

	/* [instance] method */

	@Override
	public String getName() {
		return "misty-util";
	}

	@Override
	public String getVersion() {
		return "v0.0.0";
	}

	/* [instance] getter/setter */

}
