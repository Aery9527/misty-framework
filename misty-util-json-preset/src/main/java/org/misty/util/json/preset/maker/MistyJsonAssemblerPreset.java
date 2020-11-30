package org.misty.util.json.preset.maker;

import java.util.function.Consumer;

import org.misty.util.generic.Examiner;
import org.misty.util.json.api.maker.setting.MistyJsonAssembler;
import org.misty.util.json.api.node.MistyJsonArray;
import org.misty.util.json.api.node.MistyJsonObject;
import org.misty.util.json.api.node.MistyJsonValue;

public class MistyJsonAssemblerPreset implements MistyJsonAssembler {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private String lineSeparator = System.lineSeparator();

	private String splitSeparator = "  ";

	/* [instance] constructor */

	/* [instance] method */

	@Override
	public String toJson(MistyJsonArray jsonArray) {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("[");

		stringBuilder.append("]");
	}

	@Override
	public String toJson(MistyJsonObject jsonObject) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("[");

		stringBuilder.append("]");
	}

	@Override
	public String toJson(MistyJsonValue<?> jsonValue) {
		// TODO Auto-generated method stub

	}
	

	public String toJson(MistyJsonArray jsonArray, StringBuilder stringBuilder) {
		
	}

	//

	@Override
	public String toPrettyString(MistyJsonArray jsonArray) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toPrettyString(MistyJsonObject jsonObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toPrettyString(MistyJsonValue<?> jsonValue) {
		// TODO Auto-generated method stub

	}

	//

	public String getLineSeparator() {
		return lineSeparator;
	}

	public void setLineSeparator(String lineSeparator) {
		Examiner.refuseNullAndEmpty("lineSeparator", lineSeparator);
		this.lineSeparator = lineSeparator;
	}

	public String getSplitSeparator() {
		return splitSeparator;
	}

	public void setSplitSeparator(String splitSeparator) {
		Examiner.refuseNullAndEmpty("splitSeparator", splitSeparator);
		this.splitSeparator = splitSeparator;
	}

	/* [instance] getter/setter */

}
