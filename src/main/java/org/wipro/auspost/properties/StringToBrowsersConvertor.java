package org.wipro.auspost.properties;

import org.aeonbits.owner.Converter;
import org.wipro.auspost.enums.Browsers;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowsersConvertor implements Converter<Browsers> {
    @Override
    public Browsers convert(Method method, String browser) {
        Map<String, Browsers> map =
                Map.of("CHROME", Browsers.CHROME,
                        "EDGE", Browsers.EDGE,
                        "FIREFOX", Browsers.FIREFOX);
        return map.getOrDefault(browser.toUpperCase(), Browsers.CHROME);
    }
}