package org.misty.util.fi;

@FunctionalInterface
public interface MistyFunctionThrow2<ArgType, ReturnType, T1 extends Throwable, T2 extends Throwable>
		extends MistyFunctional {

	public ReturnType applyOrThrow(ArgType arg) throws Exception;

	public default ReturnType applyOrHandle(ArgType arg) throws T1, T2 {
		return MistyFunctional.wrap(() -> {
			return applyOrThrow(arg);
		});
	}

}
