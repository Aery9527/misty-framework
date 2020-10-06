package org.misty.util.generic;

import java.util.Collection;
import java.util.Map;

public class Judge {

	/* [static] field */

	/* [static] */

	/* [static] method */

	public static boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}

	public static boolean isNullOrEmpty(Collection<?> c) {
		return c == null || c.isEmpty();
	}

	public static boolean isNullOrEmpty(Map<?, ?> m) {
		return m == null || m.isEmpty();
	}

	public static boolean isNullOrEmpty(Object[] o) {
		return o == null || o.length == 0;
	}
	
	//

	public static boolean notNullAndEmpty(String s) {
		return s != null && s.isEmpty();
	}

	public static boolean notNullAndEmpty(Collection<?> c) {
		return c != null && c.isEmpty();
	}

	public static boolean notNullAndEmpty(Map<?, ?> m) {
		return m != null && m.isEmpty();
	}

	public static boolean notNullAndEmpty(Object[] o) {
		return o != null && o.length == 0;
	}

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	/* [instance] getter/setter */

}
