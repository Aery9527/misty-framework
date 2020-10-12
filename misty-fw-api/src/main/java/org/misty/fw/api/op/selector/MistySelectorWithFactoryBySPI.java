package org.misty.fw.api.op.selector;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.misty.fw.api.generic.MistyApiConstant;
import org.misty.fw.api.op.Misty;
import org.misty.fw.api.op.MistyFactory;
import org.misty.util.generic.SystemValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MistySelectorWithFactoryBySPI {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private final Logger logger = LoggerFactory.getLogger(getClass()); // slf4j

	/* [instance] constructor */

	/* [instance] method */

	public Misty find(String[] args) {
		MistyFactory misty = null;
		boolean findOtherImplement = false;

		Class<MistyFactory> service = MistyFactory.class;
		ServiceLoader<MistyFactory> serviceLoader = ServiceLoader.load(service);
		Iterator<MistyFactory> iterator = serviceLoader.iterator();
		while (iterator.hasNext()) {
			boolean isFirstImplement = misty == null;
			if (isFirstImplement) {
				misty = iterator.next();
				logger.debug("use \"" + service.getName() + "\" implement with \"" + misty.getClass().getName()
						+ "\" by SPI.");
			} else {
				findOtherImplement = true;
				logger.warn("find \"" + service.getName() + "\" implement with \""
						+ iterator.next().getClass().getName() + "\" by SPI.");
			}
		}

		String key = MistyApiConstant.SystemPropertyKeys.ACCEPT_SPI_MULTIPLE_MISTY_IMPLEMENT;
		final boolean acceptSPIMultipleMistyImplement = SystemValues.Property.get(key, false);
		if (findOtherImplement && !acceptSPIMultipleMistyImplement) {
			throw new IllegalStateException("accept only one implement of \"" + service.getSimpleName() + "\" by SPI.");
		}

		if (misty == null) {
			throw new IllegalStateException("can't find \"" + service.getName() + "\" implement by SPI.");
		} else {
			return misty.create(args);
		}
	}

	/* [instance] getter/setter */

}
