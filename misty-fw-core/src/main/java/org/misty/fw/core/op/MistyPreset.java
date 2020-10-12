package org.misty.fw.core.op;

import org.misty.fw.api.module.MistyModuleCamp;
import org.misty.fw.api.module.MistyModuleLauncher;
import org.misty.fw.api.op.Misty;
import org.misty.fw.core.MistyFrameworkCoreDescription;

public class MistyPreset implements Misty {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private MistyModuleLauncher launcher;

	private MistyModuleCamp mistyCamp;

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
	public MistyModuleLauncher getLauncher() {
		return this.launcher;
	}

	@Override
	public MistyModuleCamp getCamp() {
		return this.mistyCamp;
	}

	/* [instance] getter/setter */

}
