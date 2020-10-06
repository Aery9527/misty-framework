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

	/* [instance] getter/setter */

}
