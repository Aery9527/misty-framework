package org.misty.util.oncesetter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.util.Arrays;
import org.assertj.core.util.Lists;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class OnceSetterAcceptableChain_Test {

	private static final String TERM = "OnceSetterTest";

	@SuppressWarnings("serial")
	public static class ChainTestException extends RuntimeException {
		public static void trigger() {
			throw new ChainTestException();
		}

		public static void trigger(String msg) {
			throw new ChainTestException(msg);
		}

		public ChainTestException() {

		}

		public ChainTestException(String msg) {
			super(msg);
		}
	}

	@Rule
	public TestName testName = new TestName();

	@Test
	public void test_chain_executor_order() {
		String chinaName = this.testName.getMethodName();

		List<String> checkList = new ArrayList<>();
		checkList.add("1");
		checkList.add("2");
		checkList.add("3");

		List<String> executeList = new ArrayList<>();
		OnceSetterAcceptableChain<String> chain = OnceSetterAcceptableChain.start(chinaName, String.class) //
				.next((term, hold) -> executeList.add("1")) //
				.next((term, hold) -> executeList.add("2")) //
				.next((term, hold) -> executeList.add("3")) //
				.getRoot() //
		;

		chain.check(null, null);

		Assertions.assertThat(executeList).containsSequence(checkList);
	}

	@Test
	public void test_chain_throw_order() {
		String chinaName = this.testName.getMethodName();

		OnceSetterAcceptableChain<Integer> chain = OnceSetterAcceptableChain.start(chinaName, Integer.class) //
				.next((term, hold) -> {
					if (hold < 10) {
						throw new ChainTestException(String.valueOf(hold));
					}
				}) //
				.next((term, hold) -> {
					if (hold < 100) {
						throw new ChainTestException(String.valueOf(hold));
					}
				}) //
				.getRoot() //
		;

		Assertions.assertThatThrownBy(() -> chain.check(TERM, 5)) //
				.isInstanceOf(ChainTestException.class) //
				.hasMessage("5") //
		;

		Assertions.assertThatThrownBy(() -> chain.check(TERM, 50)) //
				.isInstanceOf(ChainTestException.class) //
				.hasMessage("50") //
		;

		chain.check(TERM, 200); // not thing
	}

	@Test
	public void test_chain_operation() {
		String chinaName = this.testName.getMethodName();
		String hold = "kerker";

		OnceSetterAcceptableChain<String> chain1 = OnceSetterAcceptableChain.start(chinaName);

		chain1.check(TERM, hold); // hot thing

		OnceSetterAcceptableChain<String> chain2 = chain1.next(OnceSetterAcceptable.empty());
		OnceSetterAcceptableChain<String> rootChain = chain2.getRootAndFinishThisChain();

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(rootChain == chain1).isEqualTo(true);
		softAssertions.assertThatThrownBy(() -> chain2.rejectNull()) //
				.isInstanceOf(IllegalStateException.class) //
		;
		softAssertions.assertAll();
	}

	@Test
	public void tset_rejectNull_rejectIfEmptyString() {
		String chinaName = this.testName.getMethodName();

		OnceSetterAcceptableChain<String> chain = OnceSetterAcceptableChain.start(chinaName, String.class) //
				.rejectNull() //
				.rejectIfEmptyString() //
				.getRootAndFinishThisChain() //
		;

		chain.check(TERM, "123"); // not thing

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThatThrownBy(() -> chain.check(TERM, null)) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectNull(TERM)) //
		;
		softAssertions.assertThatThrownBy(() -> chain.check(TERM, "")) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectStringIsEmpty(TERM)) //
		;
		softAssertions.assertAll();
	}

	@Test
	public void tset_rejectNull_rejectIfEmptyCollection() {
		String chinaName = this.testName.getMethodName();

		OnceSetterAcceptableChain<List> chain = OnceSetterAcceptableChain.start(chinaName, List.class) //
				.rejectNull() //
				.rejectIfEmptyCollection() //
				.getRootAndFinishThisChain() //
		;

		chain.check(TERM, Lists.list("1")); // not thing

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThatThrownBy(() -> chain.check(TERM, null)) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectNull(TERM)) //
		;
		softAssertions.assertThatThrownBy(() -> chain.check(TERM, Collections.emptyList())) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectCollectionIsEmpty(TERM)) //
		;
		softAssertions.assertAll();
	}

	@Test
	public void tset_rejectNull_rejectIfEmptyArray() {
		String chinaName = this.testName.getMethodName();

		OnceSetterAcceptableChain<String[]> chain = OnceSetterAcceptableChain.start(chinaName, String[].class) //
				.rejectNull() //
				.rejectIfEmptyArray() //
				.getRootAndFinishThisChain() //
		;

		chain.check(TERM, Arrays.array("1")); // not thing

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThatThrownBy(() -> chain.check(TERM, null)) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectNull(TERM)) //
		;
		softAssertions.assertThatThrownBy(() -> chain.check(TERM, Arrays.array())) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectArrayIsEmpty(TERM)) //
		;
		softAssertions.assertAll();
	}

	@Test
	public void tset_rejectNull_rejectIfEmptyMap() {
		String chinaName = this.testName.getMethodName();

		OnceSetterAcceptableChain<Map> chain = OnceSetterAcceptableChain.start(chinaName, Map.class) //
				.rejectNull() //
				.rejectIfEmptyMap() //
				.getRootAndFinishThisChain() //
		;

		Map map = new HashMap();
		map.put("1", null);
		chain.check(TERM, map); // not thing

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThatThrownBy(() -> chain.check(TERM, null)) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectNull(TERM)) //
		;
		softAssertions.assertThatThrownBy(() -> chain.check(TERM, new HashMap())) //
				.isInstanceOf(IllegalArgumentException.class) //
				.hasMessage(OnceSetterAcceptable.MessageFormat.rejectMapIsEmpty(TERM)) //
		;
		softAssertions.assertAll();
	}

}
