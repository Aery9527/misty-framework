package org.misty.fw.api.module;

import jdk.nashorn.internal.ir.annotations.Immutable;

public interface ModuleLifecycle {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	@Immutable
	public ModuleDescription getModuleDescription();

	@Immutable
	public ModuleService getModuleService();

	//

	public void prepareOnline();

	public void destoryBeforeOffline();

	public void destoryAfterOffline();

	/* [instance] getter/setter */

}
