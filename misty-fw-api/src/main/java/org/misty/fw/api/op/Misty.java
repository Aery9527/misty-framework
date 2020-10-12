package org.misty.fw.api.op;

import org.misty.fw.api.module.MistyModuleCamp;
import org.misty.fw.api.module.MistyModuleLauncher;
import org.misty.fw.api.op.selector.MistySelector;

import jdk.nashorn.internal.ir.annotations.Immutable;

public interface Misty {

	/* [static] field */

	/* [static] */

	/* [static] method */

	public static Misty get() {
		return MistySelector.get();
	}

	public static Misty get(MistySelector selector) {
		MistySelector.init(selector);
		return MistySelector.get();
	}

	public static Misty get(String[] args) {
		MistySelector.init(args);
		return MistySelector.get();
	}

	public static Misty get(String[] args, MistySelector selector) {
		MistySelector.init(selector);
		MistySelector.init(args);
		return MistySelector.get();
	}

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	@Immutable
	public String getImplementName();

	@Immutable
	public String getImplementVersion();

	@Immutable
	public default String getImplementDescription() {
		return getImplementName() + "(" + getImplementVersion() + ")";
	}

	//

	public default String mixMessage(String msg) {
		return getImplementDescription() + ":" + msg;
	}

	//

	@Immutable
	public MistyModuleLauncher getLauncher();

	@Immutable
	public MistyModuleCamp getCamp();

	/* [instance] getter/setter */

}
