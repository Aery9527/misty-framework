package org.misty.util.fi;

@FunctionalInterface
public interface MistyRunnableThrow3<T1 extends Throwable, T2 extends Throwable, T3 extends Throwable>
		extends MistyFunctional {

	public void runOrThrow() throws Exception;

	public default void runOrHandle() throws T1, T2, T3 {
		MistyFunctional.wrap(() -> {
			runOrThrow();
		});
	}

}
