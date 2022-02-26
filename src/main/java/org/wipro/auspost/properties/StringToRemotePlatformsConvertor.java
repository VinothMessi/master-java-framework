package org.wipro.auspost.properties;

import org.aeonbits.owner.Converter;
import org.wipro.auspost.enums.Platforms;
import org.wipro.auspost.enums.RemotePlatforms;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToRemotePlatformsConvertor implements Converter<RemotePlatforms> {
    @Override
    public RemotePlatforms convert(Method method, String remotePlatform) {
        Map<String, RemotePlatforms> map =
                Map.of("SELENIUM", RemotePlatforms.SELENIUM,
                        "SELENOID", RemotePlatforms.SELENOID,
                        "BROWSER_STACK", RemotePlatforms.BROWSER_STACK);
        return map.getOrDefault(remotePlatform.toUpperCase(), RemotePlatforms.SELENIUM);
    }
}