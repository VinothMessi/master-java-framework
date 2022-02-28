package org.wipro.auspost.properties;

import org.aeonbits.owner.Converter;
import org.wipro.auspost.browsers.enums.ExecutionType;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToPlatformsConvertor implements Converter<ExecutionType> {
    @Override
    public ExecutionType convert(Method method, String platform) {
        Map<String, ExecutionType> map =
                Map.of("LOCAL", ExecutionType.LOCAL,
                        "REMOTE", ExecutionType.REMOTE);
        return map.getOrDefault(platform.toUpperCase(), ExecutionType.LOCAL);
    }
}