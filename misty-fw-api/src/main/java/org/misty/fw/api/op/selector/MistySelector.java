package org.misty.fw.api.op.selector;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

import org.misty.fw.api.op.Misty;
import org.misty.util.generic.Judge;
import org.misty.util.oncesetter.OnceSetter;

public abstract class MistySelector {

	/* [static] field */

	private static final OnceSetter<MistySelector> SELECTOR = OnceSetter.rejectHoldNull("selector",
			new MistySelectorPreset());

	private static final OnceSetter<String[]> ARGUMENTS = OnceSetter.rejectHoldNull("arguments", new String[0]);

	private static final AtomicBoolean PREPARED = new AtomicBoolean(false);

	private static Supplier<Misty> MISTY_SUPPLIER;

	/* [static] */

	static {
		MISTY_SUPPLIER = () -> { // first initial
			if (PREPARED.get()) {
				return MISTY_SUPPLIER.get();
			}

			synchronized (PREPARED) {
				if (PREPARED.get()) {
					return MISTY_SUPPLIER.get();
				}
				PREPARED.set(true);

				MistySelector selector = SELECTOR.getAndRemove();
				String[] arguments = ARGUMENTS.getAndRemove();

				Misty misty = selector.select(arguments);

				MISTY_SUPPLIER = () -> misty;

				return misty;
			}
		};
	}

	/* [static] method */

	/* [instance] field */

	public static void init(String[] args) {
		ARGUMENTS.set(args);
	}

	public static void init(MistySelector selector) {
		SELECTOR.set(selector);
	}

	public static Misty get() {
		return MISTY_SUPPLIER.get();
	}

	/* [instance] constructor */

	/* [instance] method */

	protected Misty select(String[] args) {
		if (Judge.isNullOrEmpty(args)) {
			return selectWithoutArgs();
		} else {
			return selectWithArgs(args);
		}
	}

	protected abstract Misty selectWithoutArgs();

	protected abstract Misty selectWithArgs(String[] args);

	/* [instance] getter/setter */

}
