package org.misty.util.fi;

@FunctionalInterface
public interface MistyBiConsumer<ArgType1, ArgType2> extends MistyFunctional {

	public void acceptOrThrow(ArgType1 arg1, ArgType2 arg2) throws Exception;

	public default void acceptOrHandle(ArgType1 arg1, ArgType2 arg2) {
		MistyFunctional.wrap(() -> {
			acceptOrThrow(arg1, arg2);
		});
	}

}
