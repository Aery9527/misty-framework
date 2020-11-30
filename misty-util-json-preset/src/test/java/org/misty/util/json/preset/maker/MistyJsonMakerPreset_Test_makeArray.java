package org.misty.util.json.preset.maker;

import java.util.function.Consumer;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;
import org.misty.util.generic.GenericErrorDefinition;
import org.misty.util.json.api.error.MistyJsonErrors;
import org.misty.util.json.api.error.MistyJsonException;
import org.misty.util.json.api.maker.MistyJsonMaker;
import org.misty.util.json.api.node.MistyJson;
import org.misty.util.json.api.node.MistyJsonArray;

public class MistyJsonMakerPreset_Test_makeArray {

	private MistyJsonMaker jsonMaker = new MistyJsonMakerPreset();

	@Test
	public void test_makeArray_withoutArgs() {
		MistyJsonArray jsonArray = this.jsonMaker.makeArray();

		SoftAssertions softAssertions = assertionsGeneric(jsonArray);
		softAssertions.assertThat(jsonArray.size()).isEqualTo(0);
		assertionsToJson(jsonArray, softAssertions);

		softAssertions.assertAll();
	}

	@Test
	public void test_makeArray_withCollection() {
		
	}

	@Test
	public void test_makeArray_withObjects() {

	}

	//

	public SoftAssertions assertionsGeneric(MistyJsonArray jsonArray) {
		return assertionsGeneric(jsonArray, new SoftAssertions());
	}

	public SoftAssertions assertionsGeneric(MistyJsonArray jsonArray, SoftAssertions softAssertions) {
		Consumer<ThrowableAssert.ThrowingCallable> assertThatThrown = (throwingCallable) -> {
			softAssertions.assertThatThrownBy(throwingCallable) //
					.isInstanceOf(MistyJsonException.class) //
					.matches((throwable) -> {
						if (!(throwable instanceof MistyJsonException)) {
							return true; // 因為前面會先經過MistyJsonException判斷, 所以這邊只是為了不再顯示同樣重複的錯誤, 所以回傳true
						}

						MistyJsonException mistyJsonException = (MistyJsonException) throwable;
						GenericErrorDefinition<?> errorDefinition = mistyJsonException.getErrorDefinition();
						boolean isMatch = MistyJsonErrors.NODE_CAST_ERROR.equals(errorDefinition);
						return isMatch;
					}) //
			;
		};

		softAssertions.assertThat(jsonArray.isJsonArray()).isEqualTo(true);
		softAssertions.assertThat(jsonArray.isJsonObject()).isEqualTo(false);
		softAssertions.assertThat(jsonArray.isJsonValue()).isEqualTo(false);
		softAssertions.assertThat(jsonArray.toJsonArray()).isInstanceOf(MistyJsonArray.class);
		assertThatThrown.accept(() -> jsonArray.toJsonObject());
		assertThatThrown.accept(() -> jsonArray.toJsonValue());

		return softAssertions;
	}

	//

	public SoftAssertions assertionsToJson(MistyJsonArray jsonArray) {
		return assertionsToJson(jsonArray, new SoftAssertions());
	}

	public SoftAssertions assertionsToJson(MistyJsonArray jsonArray, SoftAssertions softAssertions) {
		String element1 = "111";
		String element2 = "222";
		int originalSize = jsonArray.size();
		MistyJson element = this.jsonMaker.makeString(elementContent);
		jsonArray.add(element);

		return softAssertions;
	}

}
