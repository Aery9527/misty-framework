package org.misty.util.fi;

@FunctionalInterface
public interface MistySupplier<ReturnType> extends MistyFunctional {

	public ReturnType getOrThrow() throws Exception;

	public default ReturnType getOrHandle() {
		return MistyFunctional.wrap(() -> {
			return getOrThrow();
		});
	}

}
