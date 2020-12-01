package org.misty.util.fi;

@FunctionalInterface
public interface MistySupplierThrow3<ReturnType, T1 extends Throwable, T2 extends Throwable, T3 extends Throwable>
		extends MistyFunctional {

	public ReturnType getOrThrow() throws Exception;

	public default ReturnType getOrHandle() throws T1, T2, T3 {
		return MistyFunctional.wrap(() -> {
			return getOrThrow();
		});
	}

}
