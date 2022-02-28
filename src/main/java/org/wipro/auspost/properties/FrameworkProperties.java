package org.wipro.auspost.properties;

import org.aeonbits.owner.Config;
import org.wipro.auspost.browsers.enums.BrowserType;
import org.wipro.auspost.browsers.enums.ExecutionType;
import org.wipro.auspost.browsers.enums.RemoteExecutionTool;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/main/resources/framework.properties"
})
public interface FrameworkProperties extends Config {
    @DefaultValue("chrome")
    @ConverterClass(StringToBrowsersConvertor.class)
    BrowserType browser();

    @DefaultValue("local")
    @ConverterClass(StringToPlatformsConvertor.class)
    ExecutionType executionType();

    @DefaultValue("selenium")
    @ConverterClass(StringToRemotePlatformsConvertor.class)
    RemoteExecutionTool remoteExecutionTool();
}