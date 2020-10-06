package org.misty.util.oncesetter;

import java.util.Collection;
import java.util.Map;

@FunctionalInterface
public interface OnceSetterAcceptable<HoldType> {

	/* [static] field */

	/* [static] */

	public static class MessageFormat {
		public static final String FORMAT = "OnceSetter(%s):%s";

		public static String rejectNull(String trem) {
			return String.format(FORMAT, trem, "can't set null.");
		}

		public static String rejectStringIsEmpty(String trem) {
			return String.format(FORMAT, trem, "can't set empty String.");
		}

		public static String rejectCollectionIsEmpty(String trem) {
			return String.format(FORMAT, trem, "can't set empty Collection.");
		}

		public static String rejectArrayIsEmpty(String trem) {
			return String.format(FORMAT, trem, "can't set empty Array.");
		}

		public static String rejectMapIsEmpty(String trem) {
			return String.format(FORMAT, trem, "can't set empty Map.");
		}
	}

	/* [static] method */

	public static <HoldType> OnceSetterAcceptable<HoldType> empty() {
		return (onceSetterterm, hold) -> {
		};
	}

	// useChain

	public static <HoldType> OnceSetterAcceptableChain<HoldType> useChain(String chinaName) {
		return OnceSetterAcceptableChain.start(chinaName);
	}

	public static <HoldType> OnceSetterAcceptableChain<HoldType> useChain(String chinaName, Class<HoldType> holdType) {
		return useChain(chinaName);
	}

	public static <HoldType> OnceSetterAcceptableChain<HoldType> useChain(String chinaName,
			OnceSetterAcceptable<HoldType> acceptable) {
		OnceSetterAcceptableChain<HoldType> chain = OnceSetterAcceptableChain.start(chinaName);
		return chain.next(acceptable);
	}

	// rejectNull

	public static <HoldType> OnceSetterAcceptable<HoldType> rejectNull() {
		return (onceSetterterm, hold) -> {
			if (hold == null) {
				throw new IllegalArgumentException(MessageFormat.rejectNull(onceSetterterm));
			}
		};
	}

	// String

	public static OnceSetterAcceptable<String> rejectStringIsEmpty() {
		return (onceSetterterm, hold) -> {
			if (hold.isEmpty()) {
				throw new IllegalArgumentException(MessageFormat.rejectStringIsEmpty(onceSetterterm));
			}
		};
	}

	public static OnceSetterAcceptable<String> rejectStringIsNullOrEmpty() {
		OnceSetterAcceptableChain<String> chain = useChain("rejectStringIsNullOrEmpty", rejectNull());
		return chain.next(rejectStringIsEmpty()).getRootAndFinishThisChain();
	}

	// Collection

	public static <HoldType extends Collection<CollectionType>, CollectionType> OnceSetterAcceptable<HoldType> rejectCollectionIsEmpty() {
		return (onceSetterterm, hold) -> {
			if (hold.isEmpty()) {
				throw new IllegalArgumentException(MessageFormat.rejectCollectionIsEmpty(onceSetterterm));
			}
		};
	}

	public static <HoldType extends Collection<CollectionType>, CollectionType> OnceSetterAcceptable<HoldType> rejectCollectionIsNullOrEmpty() {
		OnceSetterAcceptableChain<HoldType> chain = useChain("rejectCollectionIsNullOrEmpty", rejectNull());
		return chain.next(rejectCollectionIsEmpty()).getRootAndFinishThisChain();
	}

	// Array

	public static <HoldType> OnceSetterAcceptable<HoldType[]> rejectArrayIsEmpty() {
		return (onceSetterterm, hold) -> {
			if (hold.length == 0) {
				throw new IllegalArgumentException(MessageFormat.rejectArrayIsEmpty(onceSetterterm));
			}
		};
	}

	public static <HoldType> OnceSetterAcceptable<HoldType[]> rejectArrayIsNullOrEmpty() {
		OnceSetterAcceptableChain<HoldType[]> chain = useChain("rejectArrayIsNullOrEmpty", rejectNull());
		return chain.next(rejectArrayIsEmpty()).getRootAndFinishThisChain();
	}

	// Map

	public static <HoldType extends Map<KeyType, ValType>, KeyType, ValType> OnceSetterAcceptable<HoldType> rejectMapIsEmpty() {
		return (onceSetterterm, hold) -> {
			if (hold.isEmpty()) {
				throw new IllegalArgumentException(MessageFormat.rejectMapIsEmpty(onceSetterterm));
			}
		};
	}

	public static <HoldType extends Map<KeyType, ValType>, KeyType, ValType> OnceSetterAcceptable<HoldType> rejectMapIsNullOrEmpty() {
		OnceSetterAcceptableChain<HoldType> chain = useChain("rejectMapIsNullOrEmpty", rejectNull());
		return chain.next(rejectMapIsEmpty()).getRootAndFinishThisChain();
	}

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	public void check(String onceSetterterm, HoldType hold) throws IllegalArgumentException;

	/* [instance] getter/setter */

}
