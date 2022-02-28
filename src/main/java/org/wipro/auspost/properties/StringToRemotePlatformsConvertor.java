package org.wipro.auspost.properties;

import org.aeonbits.owner.Converter;
import org.wipro.auspost.browsers.enums.RemoteExecutionTool;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToRemotePlatformsConvertor implements Converter<RemoteExecutionTool> {
    @Override
    public RemoteExecutionTool convert(Method method, String remotePlatform) {
        Map<String, RemoteExecutionTool> map =
                Map.of("SELENIUM", RemoteExecutionTool.SELENIUM,
                        "SELENOID", RemoteExecutionTool.SELENOID,
                        "BROWSER_STACK", RemoteExecutionTool.BROWSER_STACK);
        return map.getOrDefault(remotePlatform.toUpperCase(), RemoteExecutionTool.SELENIUM);
    }
}