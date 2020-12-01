package org.misty.util.fi;

@FunctionalInterface
public interface MistySupplierThrow2<ReturnType, T1 extends Throwable, T2 extends Throwable> extends MistyFunctional {

	public ReturnType getOrThrow() throws Exception;

	public default ReturnType getOrHandle() throws T1, T2 {
		return MistyFunctional.wrap(() -> {
			return getOrThrow();
		});
	}

}
