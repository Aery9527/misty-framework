package org.misty.util.generic;

public interface GenericDescription {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	public String getName();

	public String getVersion();

	public default String getDescription() {
		return getName() + "(" + getVersion() + ")";
	}

	public default String mixMessage(String msg) {
		return getDescription() + ":" + msg;
	}

	/* [instance] getter/setter */

}
