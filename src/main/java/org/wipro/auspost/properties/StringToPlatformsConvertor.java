package org.wipro.auspost.properties;

import org.aeonbits.owner.Converter;
import org.wipro.auspost.enums.Platforms;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToPlatformsConvertor implements Converter<Platforms> {
    @Override
    public Platforms convert(Method method, String platform) {
        Map<String, Platforms> map =
                Map.of("LOCAL", Platforms.LOCAL,
                        "REMOTE", Platforms.REMOTE);
        return map.getOrDefault(platform.toUpperCase(), Platforms.LOCAL);
    }
}