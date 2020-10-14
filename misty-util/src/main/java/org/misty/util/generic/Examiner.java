package org.misty.util.generic;

import java.util.function.BiFunction;
import java.util.function.Function;

import org.misty.util.error.MistyUtilErrors;

@FunctionalInterface
public interface Examiner<ArgType> {

	/* [static] field */

	/* [static] */

	public static class Message {
		public static final BiFunction<String, Object, String> CHECK_ERROR = (term, arg) -> {
			return "check error of \"" + term + "\" that value is " + arg;
		};

		public static final Function<String, String> REQUIRE_NULL_OR_EMPTY = (term) -> {
			return "check error of  \"" + term + "\" that require null or empty.";
		};

		public static final Function<String, String> REFUSE_NULL_OR_EMPTY = (term) -> {
			return "check error of  \"" + term + "\" that refuse null and empty.";
		};
	}
	
	public static class ofEmail {
		
	}

	/* [static] method */

	public static <ArgType> void check(Examiner<ArgType> examiner, ArgType arg, String term) {
		if (!examiner.check(arg)) {
			String description = Message.CHECK_ERROR.apply(term, arg);
			throw MistyUtilErrors.ARGUMENT_CHECK_ERROR.pop(description);
		}
	}

	//
	public static <ArgType> ArgType requireNullOrEmpty(String term, ArgType arg) {
		if (Judge.isNullOrEmpty(arg)) {
			return arg;
		}

		String description = Message.REQUIRE_NULL_OR_EMPTY.apply(term);
		throw MistyUtilErrors.ARGUMENT_CHECK_ERROR.pop(description);
	}

	public static <ArgType> ArgType refuseNullAndEmpty(String term, ArgType arg) {
		if (Judge.notNullAndEmpty(arg)) {
			return arg;
		}

		String description = Message.REFUSE_NULL_OR_EMPTY.apply(term);
		throw MistyUtilErrors.ARGUMENT_CHECK_ERROR.pop(description);
	}

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	public boolean check(ArgType arg);

	/* [instance] getter/setter */

}
