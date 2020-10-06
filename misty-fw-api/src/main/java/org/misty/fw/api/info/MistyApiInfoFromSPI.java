package org.misty.fw.api.info;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.misty.util.generic.SystemValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MistyApiInfoFromSPI {

	/* [static] field */

	private static Object LOCK = new Object();

	private static MistyApiInfo INSTANCE = null;

	/* [static] */

	/* [static] method */

	public static MistyApiInfo get() {
		if (INSTANCE != null) {
			return INSTANCE;
		}

		synchronized (LOCK) {
			if (INSTANCE != null) {
				return INSTANCE;
			}

			INSTANCE = findMistyInfoBySPI();
			return INSTANCE;
		}
	}

	private static MistyApiInfo findMistyInfoBySPI() {
		Logger logger = LoggerFactory.getLogger(MistyApiInfoFromSPI.class); // slf4j

		MistyApiInfo mistyInfo = null;
		boolean findOtherImplement = false;

		Class<MistyApiInfo> service = MistyApiInfo.class;
		ServiceLoader<MistyApiInfo> serviceLoader = ServiceLoader.load(service);

		Iterator<MistyApiInfo> iterator = serviceLoader.iterator();
		while (iterator.hasNext()) {
			boolean isFirstImplement = mistyInfo == null;
			if (isFirstImplement) {
				mistyInfo = iterator.next();
				logger.debug("use \"" + mistyInfo.getClass() + "\" implement with \"" + service + "\" by SPI.");
			} else {
				findOtherImplement = true;
				logger.warn("find \"" + iterator.next().getClass() + "\" implement with \"" + service
						+ "\" by SPI. (ignore)");
			}
		}

		String key = MistyApiConstant.SystemPropertyKeys.ACCEPT_MULTIPLE_MISTY_API_INFO_IMPLEMENT;
		final boolean acceptMultipleMistyApiInfoImplement = SystemValues.Property.get(key, false);
		if (findOtherImplement && !acceptMultipleMistyApiInfoImplement) {
			throw new IllegalStateException("accept only one implement of \"" + service + "\" by SPI.");
		}

		if (mistyInfo == null) {
			throw new IllegalStateException("can't find \"" + service + "\" implement by SPI.");
		} else {
			return mistyInfo;
		}
	}

	/* [instance] field */

	/* [instance] constructor */

	/* [instance] method */

	/* [instance] getter/setter */

}
