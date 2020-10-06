package org.misty.util.oncesetter;

import java.util.Collection;
import java.util.Map;

public class OnceSetterAcceptableChain<HoldType> implements OnceSetterAcceptable<HoldType> {

	/* [static] field */

	/* [static] */

	private static class RootChain<HoldType> extends OnceSetterAcceptableChain<HoldType> {
		public RootChain(String chinaName) {
			super(null, chinaName, OnceSetterAcceptable.empty());
		}

		@Override
		public OnceSetterAcceptableChain<HoldType> getRoot() {
			return this;
		}

		@Override
		protected OnceSetterAcceptableChain<HoldType> createNextChain(OnceSetterAcceptable<HoldType> acceptable) {
			String term = super.next.getTerm();
			return new OnceSetterAcceptableChain<>(this, term, acceptable);
		}
	}

	/* [static] method */

	public static <HoldType> OnceSetterAcceptableChain<HoldType> start(String chinaName) {
		return new RootChain<>("AcceptableChain:" + chinaName);
	}

	public static <HoldType> OnceSetterAcceptableChain<HoldType> start(String chinaName, Class<HoldType> holdType) {
		return start(chinaName);
	}

	/* [instance] field */

	private final RootChain<HoldType> rootChain;

	private final OnceSetterAcceptable<HoldType> instantly;

	private final OnceSetter<OnceSetterAcceptable<HoldType>> next;

	/* [instance] constructor */

	private OnceSetterAcceptableChain(RootChain<HoldType> rootChain, String term,
			OnceSetterAcceptable<HoldType> acceptable) {
		this.rootChain = rootChain;
		this.instantly = acceptable;
		this.next = OnceSetter.rejectHoldNull(term, OnceSetterAcceptable.empty());
	}

	/* [instance] method */

	@Override
	public void check(String onceSetterterm, HoldType hold) throws IllegalArgumentException {
		this.instantly.check(onceSetterterm, hold);
		this.next.get().check(onceSetterterm, hold);
	}

	//

	public OnceSetterAcceptableChain<HoldType> next(OnceSetterAcceptable<HoldType> acceptable) {
		OnceSetterAcceptableChain<HoldType> nextChain = createNextChain(acceptable);
		this.next.set(nextChain);
		return nextChain;
	}

	public OnceSetterAcceptableChain<HoldType> getRoot() {
		return this.rootChain;
	}

	public OnceSetterAcceptableChain<HoldType> getRootAndFinishThisChain() {
		this.next.lock();
		return getRoot();
	}

	public OnceSetterAcceptableChain<HoldType> rejectNull() {
		return next(OnceSetterAcceptable.rejectNull());
	}

	public OnceSetterAcceptableChain<HoldType> rejectIfEmptyString() {
		return next((onceSetterterm, hold) -> {
			if (hold instanceof String) {
				OnceSetterAcceptable.rejectStringIsEmpty().check(onceSetterterm, (String) hold);
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public OnceSetterAcceptableChain<HoldType> rejectIfEmptyCollection() {
		return next((onceSetterterm, hold) -> {
			if (hold instanceof Collection) {
				OnceSetterAcceptable.rejectCollectionIsEmpty().check(onceSetterterm, (Collection) hold);
			}
		});
	}

	public OnceSetterAcceptableChain<HoldType> rejectIfEmptyArray() {
		return next((onceSetterterm, hold) -> {
			if (hold.getClass().isArray()) {
				OnceSetterAcceptable.rejectArrayIsEmpty().check(onceSetterterm, (Object[]) hold);
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public OnceSetterAcceptableChain<HoldType> rejectIfEmptyMap() {
		return next((onceSetterterm, hold) -> {
			if (hold instanceof Map) {
				OnceSetterAcceptable.rejectMapIsEmpty().check(onceSetterterm, (Map) hold);
			}
		});
	}

	//

	protected OnceSetterAcceptableChain<HoldType> createNextChain(OnceSetterAcceptable<HoldType> acceptable) {
		String term = this.next.getTerm();
		return new OnceSetterAcceptableChain<>(this.rootChain, term, acceptable);
	}

	/* [instance] getter/setter */

}
