package org.misty.util.fi;

@FunctionalInterface
public interface MistyConsumerThrow2<ArgType, T1 extends Throwable, T2 extends Throwable> extends MistyFunctional {

	public void acceptOrThrow(ArgType arg) throws Exception;

	public default void acceptOrHandle(ArgType arg) throws T1, T2 {
		MistyFunctional.wrap(() -> {
			acceptOrThrow(arg);
		});
	}

}
