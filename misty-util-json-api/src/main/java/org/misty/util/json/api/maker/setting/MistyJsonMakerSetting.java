package org.misty.util.json.api.maker.setting;

import org.misty.util.generic.Examiner;

public class MistyJsonMakerSetting {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private MistyJsonAssembler jsonAssembler;

	/* [instance] constructor */

	/* [instance] method */

	/* [instance] getter/setter */

	public MistyJsonAssembler getJsonAssembler() {
		return jsonAssembler;
	}

	public void setJsonAssembler(MistyJsonAssembler jsonAssembler) {
		Examiner.refuseNullAndEmpty("jsonAssembler", jsonAssembler);
		this.jsonAssembler = jsonAssembler;
	}

}
