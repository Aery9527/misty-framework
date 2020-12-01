package org.misty.util.fi;

@FunctionalInterface
public interface MistyBiFunctionThrow2<ArgType1, ArgType2, ReturnType, T1 extends Throwable, T2 extends Throwable>
		extends MistyFunctional {

	public ReturnType applyOrThrow(ArgType1 arg1, ArgType2 arg2) throws Exception;

	public default ReturnType applyOrHandle(ArgType1 arg1, ArgType2 arg2) throws T1, T2 {
		return MistyFunctional.wrap(() -> {
			return applyOrThrow(arg1, arg2);
		});
	}

}
