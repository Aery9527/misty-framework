package org.misty.usecase;

import org.misty.fw.api.op.Misty;

public class Entrance {

	public static void main(String[] args) {
		Misty misty = Misty.get(args);
		System.out.println(misty.getImplementDescription());
	}

}
