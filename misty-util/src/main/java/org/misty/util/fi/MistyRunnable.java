package org.misty.util.fi;

@FunctionalInterface
public interface MistyRunnable extends MistyFunctional {

	public void runOrThrow() throws Exception;

	public default void runOrHandle() {
		MistyFunctional.wrap(() -> {
			runOrThrow();
		});
	}

}
