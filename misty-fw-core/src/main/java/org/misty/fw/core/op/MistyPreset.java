package org.misty.fw.core.op;

import org.misty.fw.api.op.Misty;
import org.misty.fw.api.op.MistyCamp;
import org.misty.fw.api.op.MistyLauncher;
import org.misty.fw.core.MistyFrameworkCoreDescription;

public class MistyPreset implements Misty {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	@Override
	public String getImplementName() {
		return MistyFrameworkCoreDescription.INSTANCE.getName();
	}

	@Override
	public String getImplementVersion() {
		return MistyFrameworkCoreDescription.INSTANCE.getVersion();
	}

	@Override
	public MistyLauncher getLauncher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MistyCamp getCamp() {
		// TODO Auto-generated method stub
		return null;
	}

	/* [instance] getter/setter */

}
