package org.misty.fw.api.op.selector;

import org.misty.fw.api.op.Misty;

public class MistySelectorPreset extends MistySelector {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	@Override
	protected Misty selectWithoutArgs() {
		return fromSPI(new String[0]);
	}

	@Override
	protected Misty selectWithArgs(String[] args) {
		return fromSPI(args);
	}

	public Misty fromSPI(String[] args) {
		return new MistySelectorWithFactoryBySPI().find(args);
	}

	/* [instance] getter/setter */

}
