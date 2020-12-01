package org.misty.util.fi;

@FunctionalInterface
public interface MistyFunctionThrow1<ArgType, ReturnType, T1 extends Throwable> extends MistyFunctional {

	public ReturnType applyOrThrow(ArgType arg) throws Exception;

	public default ReturnType applyOrHandle(ArgType arg) throws T1 {
		return MistyFunctional.wrap(() -> {
			return applyOrThrow(arg);
		});
	}

}
