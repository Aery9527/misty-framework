package org.misty.util.oncesetter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class OnceSetter_Test {

	private static final String TERM = "OnceSetterTest";

	private static final String PRESET = "preset";

	@Test
	public void test_setup_twice_will_throw_exception() {
		OnceSetter<String> onceSetter = new OnceSetter<>(TERM, PRESET);
		onceSetter.set("");

		Assertions.assertThatThrownBy(() -> onceSetter.set("")) //
				.isInstanceOf(IllegalStateException.class) //
		;
	}

	@Test
	public void test_getAndRemove() {
		OnceSetter<String> onceSetter = new OnceSetter<>(TERM, PRESET);
		String hold1 = onceSetter.getAndRemove();
		String hold2 = onceSetter.get();

		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThat(hold1).isEqualTo(PRESET);
		softAssertions.assertThat(hold2).isNull();
		softAssertions.assertAll();
	}

	@Test
	public void test_return_preset_when_unset() {
		OnceSetter<String> onceSetter = new OnceSetter<>(TERM, PRESET);
		String hold = onceSetter.get();

		Assertions.assertThat(hold).isEqualTo(PRESET);
	}

	@Test
	public void test_return_new_ones_when_set() {
		final String newHold = "kerker";

		OnceSetter<String> onceSetter = new OnceSetter<>(TERM, PRESET);
		onceSetter.set(newHold);

		String hold = onceSetter.get();

		Assertions.assertThat(hold).isEqualTo(newHold);
	}

	@Test
	public void test_rejectHoldNull_when_preset() {
		Assertions.assertThatThrownBy(() -> OnceSetter.rejectHoldNull(TERM, null)) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectNull(TERM)) //
		;
	}

	@Test
	public void test_rejectHoldNull_when_set() {
		OnceSetter<String> onceSetter = OnceSetter.rejectHoldNull(TERM, PRESET);

		Assertions.assertThatThrownBy(() -> onceSetter.set(null)) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectNull(TERM)) //
		;
	}

	@Test
	public void test_rejectHoldEmpty_with_String_when_preset() {
		Assertions.assertThatThrownBy(() -> OnceSetter.rejectHoldEmpty(TERM, "")) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectStringIsEmpty(TERM)) //
		;
	}

	@Test
	public void test_rejectHoldEmpty_with_String_when_set() {
		OnceSetter<String> onceSetter = OnceSetter.rejectHoldEmpty(TERM, PRESET);

		Assertions.assertThatThrownBy(() -> onceSetter.set("")) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectStringIsEmpty(TERM)) //
		;
	}

	@Test
	public void test_rejectHoldEmpty_with_Collection_when_preset() {
		Assertions.assertThatThrownBy(() -> OnceSetter.rejectHoldEmpty(TERM, Collections.emptyList())) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectCollectionIsEmpty(TERM)) //
		;
	}

	@Test
	public void test_rejectHoldEmpty_with_Collection_when_set() {
		OnceSetter<List<String>> onceSetter = OnceSetter.rejectHoldEmpty(TERM, Lists.list("kerker"));

		Assertions.assertThatThrownBy(() -> onceSetter.set(Collections.emptyList())) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectCollectionIsEmpty(TERM)) //
		;
	}

	@Test
	public void test_rejectHoldEmpty_with_Array_when_preset() {
		Assertions.assertThatThrownBy(() -> OnceSetter.rejectHoldEmpty(TERM, new String[0])) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectArrayIsEmpty(TERM)) //
		;
	}

	@Test
	public void test_rejectHoldEmpty_with_Array_when_set() {
		OnceSetter<String[]> onceSetter = OnceSetter.rejectHoldEmpty(TERM, new String[] { "9487" });

		Assertions.assertThatThrownBy(() -> onceSetter.set(new String[0])) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectArrayIsEmpty(TERM)) //
		;
	}

	@Test
	public void test_rejectHoldEmpty_with_Map_when_preset() {
		Assertions.assertThatThrownBy(() -> OnceSetter.rejectHoldEmpty(TERM, Collections.emptyMap())) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectMapIsEmpty(TERM)) //
		;
	}

	@Test
	public void test_rejectHoldEmpty_with_Map_when_set() {
		Map<String, Void> map = new HashMap<>();
		map.put("kerker", null);
		OnceSetter<Map<String, Void>> onceSetter = OnceSetter.rejectHoldEmpty(TERM, map);

		Assertions.assertThatThrownBy(() -> onceSetter.set(Collections.emptyMap())) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectMapIsEmpty(TERM)) //
		;
	}

}
