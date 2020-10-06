package org.misty.fw.core;

import org.misty.util.generic.GenericDescription;

public final class MistyFrameworkCoreDescription implements GenericDescription {

	/* [static] field */

	public static final MistyFrameworkCoreDescription INSTANCE = new MistyFrameworkCoreDescription();

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	private MistyFrameworkCoreDescription() {
	}

	/* [instance] method */

	@Override
	public String getName() {
		return "misty-fw-core";
	}

	@Override
	public String getVersion() {
		return "v0.0.0";
	}

	/* [instance] getter/setter */

}
