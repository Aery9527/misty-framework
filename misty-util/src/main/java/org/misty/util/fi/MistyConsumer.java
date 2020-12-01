package org.misty.util.fi;

@FunctionalInterface
public interface MistyConsumer<ArgType> extends MistyFunctional {

	public void acceptOrThrow(ArgType arg) throws Exception;

	public default void acceptOrHandle(ArgType arg) {
		MistyFunctional.wrap(() -> {
			acceptOrThrow(arg);
		});
	}

}
