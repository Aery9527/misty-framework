package org.misty.util.fi;

@FunctionalInterface
public interface MistyConsumerThrow3<ArgType, T1 extends Throwable, T2 extends Throwable, T3 extends Throwable>
		extends MistyFunctional {

	public void acceptOrThrow(ArgType arg) throws Exception;

	public default void acceptOrHandle(ArgType arg) throws T1, T2, T3 {
		MistyFunctional.wrap(() -> {
			acceptOrThrow(arg);
		});
	}

}
