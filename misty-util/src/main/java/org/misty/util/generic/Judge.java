package org.misty.util.generic;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class Judge {

	/* [static] field */

	/* [static] */

	/* [static] method */

	@SuppressWarnings("rawtypes")
	public static boolean isNullOrEmpty(Object o) {
		if (o == null) {
			return true;

		} else if (o instanceof String) {
			return isNullOrEmpty((String) o);

		} else if (o instanceof Collection) {
			return isNullOrEmpty((Collection) o);

		} else if (o instanceof Map) {
			return isNullOrEmpty((Map) o);

		} else if (o instanceof Object[]) {
			return isNullOrEmpty((Object[]) o);

		} else if (o instanceof Optional) {
			return isNullOrEmpty((Optional) o);

		} else {
			return false;
		}
	}

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

	public static boolean isNullOrEmpty(Optional<?> o) {
		if (o == null) {
			return true;
		}

		if (!o.isPresent()) {
			return true;
		}

		Object v = o.get();

		if (v instanceof String) {
			return isNullOrEmpty((String) v);
		} else if (v instanceof Collection) {
			return isNullOrEmpty((Collection<?>) v);
		} else if (v instanceof Map) {
			return isNullOrEmpty((Map<?, ?>) v);
		} else {
			return false;
		}
	}

	//

	public static boolean notNullAndEmpty(Object o) {
		return !isNullOrEmpty(o);
	}

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

	public static boolean notNullOrEmpty(Optional<?> o) {
		return !isNullOrEmpty(o);
	}

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	/* [instance] getter/setter */

}
