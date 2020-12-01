package org.misty.util.fi;

@FunctionalInterface
public interface MistySupplierThrow1<ReturnType, T1 extends Throwable> extends MistyFunctional {

	public ReturnType getOrThrow() throws Exception;

	public default ReturnType getOrHandle() throws T1 {
		return MistyFunctional.wrap(this);
	}

}
