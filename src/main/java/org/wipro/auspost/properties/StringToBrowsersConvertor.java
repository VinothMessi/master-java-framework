package org.wipro.auspost.properties;

import org.aeonbits.owner.Converter;
import org.wipro.auspost.browsers.enums.BrowserType;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowsersConvertor implements Converter<BrowserType> {
    @Override
    public BrowserType convert(Method method, String browser) {
        Map<String, BrowserType> map =
                Map.of("CHROME", BrowserType.CHROME,
                        "EDGE", BrowserType.EDGE,
                        "FIREFOX", BrowserType.FIREFOX);
        return map.getOrDefault(browser.toUpperCase(), BrowserType.CHROME);
    }
}