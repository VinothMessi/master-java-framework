package org.wipro.auspost.properties;

import org.aeonbits.owner.Config;
import org.wipro.auspost.enums.Browsers;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/main/resources/framework.properties"
})
public interface FrameworkProperties extends Config {
    @DefaultValue("chrome")
    @ConverterClass(StringToBrowsersConvertor.class)
    Browsers browser();
}