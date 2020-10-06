package org.misty.fw.api;

import org.misty.util.generic.GenericDescription;

public final class MistyFrameworkApiDescription implements GenericDescription {

	/* [static] field */

	public static final MistyFrameworkApiDescription INSTANCE = new MistyFrameworkApiDescription();

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	private MistyFrameworkApiDescription() {
	}

	/* [instance] method */

	@Override
	public String getName() {
		return "misty-fw-api";
	}

	@Override
	public String getVersion() {
		return "v0.0.0";
	}

	/* [instance] getter/setter */

}
