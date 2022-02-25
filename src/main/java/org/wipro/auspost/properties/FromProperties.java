package org.wipro.auspost.properties;

import org.aeonbits.owner.ConfigFactory;

public class FromProperties {
    private FromProperties() {}

    public static FrameworkProperties get() {
        return ConfigFactory.create(FrameworkProperties.class);
    }
}