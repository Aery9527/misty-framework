package org.misty.util.fi;

@FunctionalInterface
public interface MistyRunnableThrow2<T1 extends Throwable, T2 extends Throwable> extends MistyFunctional {

	public void runOrThrow() throws Exception;

	public default void runOrHandle() throws T1, T2 {
		MistyFunctional.wrap(() -> {
			runOrThrow();
		});
	}

}
