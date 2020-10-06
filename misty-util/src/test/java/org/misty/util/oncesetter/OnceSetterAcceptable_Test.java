package org.misty.util.oncesetter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class OnceSetterAcceptable_Test {

	private static final String TERM = "OnceSetterAcceptableTest";

	@Test
	public void test_rejectNull() {
		OnceSetterAcceptable<String> acceptable = OnceSetterAcceptable.rejectNull();

		Assertions.assertThatThrownBy(() -> acceptable.check(TERM, null)) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectNull(TERM)) //
		;
	}

	@Test
	public void test_rejectStringIsEmpty() {
		OnceSetterAcceptable<String> acceptable = OnceSetterAcceptable.rejectStringIsEmpty();

		Assertions.assertThatThrownBy(() -> acceptable.check(TERM, "")) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectStringIsEmpty(TERM)) //
		;
	}

	@Test
	public void test_rejectStringIsNullOrEmpty() {
		OnceSetterAcceptable<String> acceptable = OnceSetterAcceptable.rejectStringIsNullOrEmpty();

		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThatThrownBy(() -> acceptable.check(TERM, null)) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectNull(TERM)) //
		;

		softAssertions.assertThatThrownBy(() -> acceptable.check(TERM, "")) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectStringIsEmpty(TERM)) //
		;

		softAssertions.assertAll();
	}

	@Test
	public void test_rejectCollectionIsEmpty() {
		OnceSetterAcceptable<Collection> acceptable = OnceSetterAcceptable.rejectCollectionIsEmpty();

		Assertions.assertThatThrownBy(() -> acceptable.check(TERM, Collections.emptyList())) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectCollectionIsEmpty(TERM)) //
		;
	}

	@Test
	public void test_rejectCollectionIsNullOrEmpty() {
		OnceSetterAcceptable<Collection> acceptable = OnceSetterAcceptable.rejectCollectionIsNullOrEmpty();

		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThatThrownBy(() -> acceptable.check(TERM, null)) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectNull(TERM)) //
		;

		softAssertions.assertThatThrownBy(() -> acceptable.check(TERM, Collections.emptyList())) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectCollectionIsEmpty(TERM)) //
		;

		softAssertions.assertAll();
	}

	@Test
	public void test_rejectArrayIsEmpty() {
		OnceSetterAcceptable<String[]> acceptable = OnceSetterAcceptable.rejectArrayIsEmpty();

		Assertions.assertThatThrownBy(() -> acceptable.check(TERM, new String[0])) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectArrayIsEmpty(TERM)) //
		;
	}

	@Test
	public void test_rejectArrayIsNullOrEmpty() {
		OnceSetterAcceptable<String[]> acceptable = OnceSetterAcceptable.rejectArrayIsNullOrEmpty();

		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThatThrownBy(() -> acceptable.check(TERM, null)) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectNull(TERM)) //
		;

		softAssertions.assertThatThrownBy(() -> acceptable.check(TERM, new String[0])) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectArrayIsEmpty(TERM)) //
		;

		softAssertions.assertAll();
	}

	@Test
	public void test_rejectMapIsEmpty() {
		OnceSetterAcceptable<Map> acceptable = OnceSetterAcceptable.rejectMapIsEmpty();

		Assertions.assertThatThrownBy(() -> acceptable.check(TERM, new HashMap())) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectMapIsEmpty(TERM)) //
		;
	}

	@Test
	public void test_rejectMapIsNullOrEmpty() {
		OnceSetterAcceptable<Map> acceptable = OnceSetterAcceptable.rejectMapIsNullOrEmpty();

		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThatThrownBy(() -> acceptable.check(TERM, null)) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectNull(TERM)) //
		;

		softAssertions.assertThatThrownBy(() -> acceptable.check(TERM, new HashMap())) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectMapIsEmpty(TERM)) //
		;

		softAssertions.assertAll();
	}

}
