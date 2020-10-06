package org.misty.fw.api.info;

public interface MistyApiInfo {

	/* [static] field */

	/* [static] */

	/* [static] method */

	public static MistyApiInfo getImplemented() {
		return MistyApiInfoFromSPI.get();
	}

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	public String getImplementName();

	public String getImplementVersion();

	public default String getImplementDescription() {
		return getImplementName() + "(" + getImplementVersion() + ")";
	}

	public default String mixMessage(String msg) {
		return getImplementDescription() + ":" + msg;
	}

	/* [instance] getter/setter */

}
