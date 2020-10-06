package org.misty.usecase;

import org.misty.fw.api.info.MistyApiInfo;

public class Entrance {

	public static void main(String[] args) {
		MistyApiInfo mistyApiInfo = MistyApiInfo.getImplemented();
		System.out.println(mistyApiInfo.getImplementName());
		System.out.println(mistyApiInfo.getImplementVersion());
	}

}
