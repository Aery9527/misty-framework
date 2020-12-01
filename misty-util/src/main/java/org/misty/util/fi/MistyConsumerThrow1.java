package org.misty.util.fi;

@FunctionalInterface
public interface MistyConsumerThrow1<ArgType, T1 extends Throwable> extends MistyFunctional {

	public void acceptOrThrow(ArgType arg) throws Exception;

	public default void acceptOrHandle(ArgType arg) throws T1 {
		MistyFunctional.wrap(() -> {
			acceptOrThrow(arg);
		});
	}

}
