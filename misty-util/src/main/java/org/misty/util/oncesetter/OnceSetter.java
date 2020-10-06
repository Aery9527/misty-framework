package org.misty.util.oncesetter;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class OnceSetter<HoldType> {

	/* [static] field */

	public static final boolean UNSET = false;

	public static final boolean SETUP = true;

	/* [static] */

	/* [static] method */

	// rejectHoldNull

	public static <HoldType> OnceSetter<HoldType> rejectHoldNull(String term, HoldType preset) {
		return new OnceSetter<>(term, preset, OnceSetterAcceptable.rejectNull());
	}

	// rejectHoldEmpty

	public static OnceSetter<String> rejectHoldEmpty(String term, String preset) {
		return new OnceSetter<>(term, preset, OnceSetterAcceptable.rejectStringIsEmpty());
	}

	public static <HoldType extends Collection<CollectionType>, CollectionType> OnceSetter<HoldType> rejectHoldEmpty(
			String term, HoldType preset) {
		return new OnceSetter<>(term, preset, OnceSetterAcceptable.rejectCollectionIsEmpty());
	}

	public static <HoldType> OnceSetter<HoldType[]> rejectHoldEmpty(String term, HoldType[] preset) {
		return new OnceSetter<>(term, preset, OnceSetterAcceptable.rejectArrayIsEmpty());
	}

	public static <KeyType, ValType> OnceSetter<Map<KeyType, ValType>> rejectHoldEmpty(String term,
			Map<KeyType, ValType> preset) {
		return new OnceSetter<>(term, preset, OnceSetterAcceptable.rejectMapIsEmpty());
	}

	// rejectHoldNullOrEmpty

	public static OnceSetter<String> rejectHoldNullOrEmpty(String term, String preset) {
		return new OnceSetter<>(term, preset, OnceSetterAcceptable.rejectStringIsNullOrEmpty());
	}

	public static <CollectionType> OnceSetter<Collection<CollectionType>> rejectHoldNullOrEmpty(String term,
			Collection<CollectionType> preset) {
		return new OnceSetter<>(term, preset, OnceSetterAcceptable.rejectCollectionIsNullOrEmpty());
	}

	public static <KeyType, ValType> OnceSetter<Map<KeyType, ValType>> rejectHoldNullOrEmpty(String term,
			Map<KeyType, ValType> preset) {
		return new OnceSetter<>(term, preset, OnceSetterAcceptable.rejectMapIsNullOrEmpty());
	}

	public static <HoldType> OnceSetter<HoldType[]> rejectHoldNullOrEmpty(String term, HoldType[] preset) {
		return new OnceSetter<>(term, preset, OnceSetterAcceptable.rejectArrayIsNullOrEmpty());
	}

	/* [instance] field */

	private final AtomicBoolean lock = new AtomicBoolean(UNSET);

	private final String term;

	private final OnceSetterAcceptable<HoldType> acceptable;

	private HoldType hold;

	/* [instance] constructor */

	public OnceSetter(String term, HoldType preset) {
		this(term, preset, OnceSetterAcceptable.empty());
	}

	public OnceSetter(String term, HoldType preset, OnceSetterAcceptable<HoldType> acceptable) {
		this.term = term;
		this.acceptable = acceptable;
		this.hold = preset;

		this.acceptable.check(this.term, this.hold);
	}

	/* [instance] method */

	public void set(HoldType newHold) throws IllegalStateException {
		checkUnset();

		this.acceptable.check(this.term, newHold);

		synchronized (this.lock) {
			checkUnset();
			hold = newHold;
			lock();
		}
	}

	public HoldType get() {
		return this.hold;
	}

	public HoldType getAndRemove() {
		HoldType hold = this.hold;
		this.hold = null;
		return hold;
	}

	public void lock() {
		this.lock.set(SETUP);
	}

	public boolean isSetup() {
		return this.lock.get();
	}

	public boolean isUnset() {
		return !this.lock.get();
	}

	private void checkUnset() throws IllegalStateException {
		if (this.lock.get()) {
			String msg = String.format(OnceSetterAcceptable.MessageFormat.FORMAT, this.term, "has been setup!");
			throw new IllegalStateException(msg);
		}
	}

	/* [instance] getter/setter */

	public String getTerm() {
		return term;
	}

}
