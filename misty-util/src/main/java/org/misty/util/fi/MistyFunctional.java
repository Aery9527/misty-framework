package org.misty.util.fi;

public interface MistyFunctional {

	/* [static] field */

	/* [static] */

	/* [static] method */

	@SuppressWarnings("unchecked")
	public static <T extends Throwable> void wrap(MistyRunnableThrow1<T> runnableThrow1) throws T {
		try {
			runnableThrow1.runOrThrow();
		} catch (Exception e) {
			try {
				throw (T) e; // ThrowableType被外部呼叫時決定為A-exception, 但真正執行時拋出B-exception時, 這裡轉型會過...滿神奇的...
			} catch (ClassCastException cce) {
				cce.printStackTrace();
				throw new RuntimeException(e); // 所以基本上不會跑到這...因為不會轉型錯誤...
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <ReturnType, T extends Throwable> ReturnType wrap(MistySupplierThrow1<ReturnType, T> supplierThrow1)
			throws T {
		try {
			return supplierThrow1.getOrThrow();
		} catch (Exception e) {
			try {
				throw (T) e; // ThrowableType被外部呼叫時決定為A-exception, 但真正執行時拋出B-exception時, 這裡轉型會過...滿神奇的...
			} catch (ClassCastException cce) {
				cce.printStackTrace();
				throw new RuntimeException(e); // 所以基本上不會跑到這...因為不會轉型錯誤...
			}
		}
	}

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	/* [instance] getter/setter */

}
