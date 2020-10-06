package org.misty.util.generic;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/** 將{@link System#getenv()}系列與{@link System#getProperties()}系列整合起來操作, 並控制其key不存在時的狀況或大部分轉型情況 */
public class SystemValues {

	/* [static] field */

	/* [static] */

	public static class Environment {
		public static String get(String key, String defaultValue) {
			return SystemValues.get(key, defaultValue, System::getenv, (s) -> s);
		}

		public static int get(String key, int defaultValue) {
			return SystemValues.get(key, defaultValue, System::getenv, Integer::parseInt);
		}

		public static long get(String key, long defaultValue) {
			return SystemValues.get(key, defaultValue, System::getenv, Long::parseLong);
		}

		public static float get(String key, float defaultValue) {
			return SystemValues.get(key, defaultValue, System::getenv, Float::parseFloat);
		}

		public static double get(String key, double defaultValue) {
			return SystemValues.get(key, defaultValue, System::getenv, Double::parseDouble);
		}

		public static boolean get(String key, boolean defaultValue) {
			return SystemValues.get(key, defaultValue, System::getenv, Boolean::parseBoolean);
		}
	}

	public static class Property {

		public static String get(String key, String defaultValue) {
			return SystemValues.get(key, defaultValue, System::getProperty, (s) -> s);
		}

		public static String setIfNotExists(String key, String newValue) {
			return SystemValues.setIfNotExists(key, newValue, (s) -> s);
		}

		public static int get(String key, int defaultValue) {
			return SystemValues.get(key, defaultValue, System::getProperty, Integer::parseInt);
		}

		public static Integer setIfNotExists(String key, int newValue) {
			return SystemValues.setIfNotExists(key, newValue, Integer::parseInt);
		}

		public static Long get(String key, long defaultValue) {
			return SystemValues.get(key, defaultValue, System::getProperty, Long::parseLong);
		}

		public static Long setIfNotExists(String key, long newValue) {
			return SystemValues.setIfNotExists(key, newValue, Long::parseLong);
		}

		public static Float get(String key, float defaultValue) {
			return SystemValues.get(key, defaultValue, System::getProperty, Float::parseFloat);
		}

		public static Float setIfNotExists(String key, float newValue) {
			return SystemValues.setIfNotExists(key, newValue, Float::parseFloat);
		}

		public static Double get(String key, double defaultValue) {
			return SystemValues.get(key, defaultValue, System::getProperty, Double::parseDouble);
		}

		public static Double setIfNotExists(String key, double newValue) {
			return SystemValues.setIfNotExists(key, newValue, Double::parseDouble);
		}

		public static Boolean get(String key, boolean defaultValue) {
			return SystemValues.get(key, defaultValue, System::getProperty, Boolean::parseBoolean);
		}

		public static Boolean setIfNotExists(String key, boolean newValue) {
			return SystemValues.setIfNotExists(key, newValue, Boolean::parseBoolean);
		}

	}

	/* [static] method */

	private static <Type> Type get(String key, Type defaultValue, UnaryOperator<String> source,
			Function<String, Type> converter) {
		String value = source.apply(key);
		if (Judge.notNullAndEmpty(value)) {
			return converter.apply(value);
		} else {
			return defaultValue;
		}
	}

	private static <Type> Type setIfNotExists(String key, Type newValue, Function<String, Type> converter) {
		String oldValue = System.getProperty(key);
		if (Judge.isNullOrEmpty(oldValue)) {
			System.setProperty(key, String.valueOf(newValue));
			return null;
		} else {
			return converter.apply(oldValue);
		}
	}

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	/* [instance] getter/setter */

}
