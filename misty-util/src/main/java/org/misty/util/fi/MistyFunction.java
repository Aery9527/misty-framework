package org.misty.util.fi;

@FunctionalInterface
public interface MistyFunction<ArgType, ReturnType> extends MistyFunctional {

	public ReturnType applyOrThrow(ArgType arg) throws Exception;

	public default ReturnType applyOrHandle(ArgType arg) {
		return MistyFunctional.wrap(() -> {
			return applyOrThrow(arg);
		});
	}

}
