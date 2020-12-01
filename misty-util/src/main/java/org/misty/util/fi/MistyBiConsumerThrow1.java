package org.misty.util.fi;

@FunctionalInterface
public interface MistyBiConsumerThrow1<ArgType1, ArgType2, T1 extends Throwable> extends MistyFunctional {

	public void acceptOrThrow(ArgType1 arg1, ArgType2 arg2) throws Exception;

	public default void acceptOrHandle(ArgType1 arg1, ArgType2 arg2) throws T1 {
		MistyFunctional.wrap(() -> {
			acceptOrThrow(arg1, arg2);
		});
	}

}
