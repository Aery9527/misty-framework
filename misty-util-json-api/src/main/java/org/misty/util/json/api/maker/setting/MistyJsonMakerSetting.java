package org.misty.util.json.api.maker.setting;

public class MistyJsonMakerSetting {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private String jsonAssemblerClass;

	/* [instance] constructor */

	/* [instance] method */

	public MistyJsonMakerSetting clone() {
		MistyJsonMakerSetting setting = new MistyJsonMakerSetting();
		setting.setJsonAssemblerClass(this.jsonAssemblerClass);

		return setting;
	}

	/* [instance] getter/setter */

	public String getJsonAssemblerClass() {
		return jsonAssemblerClass;
	}

	public void setJsonAssemblerClass(String jsonAssemblerClass) {
		this.jsonAssemblerClass = jsonAssemblerClass;
	}

}
