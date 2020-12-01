package org.misty.util.fi;

@FunctionalInterface
public interface MistyRunnableThrow1<T1 extends Throwable> extends MistyFunctional {

	public void runOrThrow() throws Exception;

	public default void runOrHandle() throws T1 {
		MistyFunctional.wrap(this);
	}

}
