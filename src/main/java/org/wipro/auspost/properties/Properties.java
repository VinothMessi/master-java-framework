package org.wipro.auspost.properties;

import org.aeonbits.owner.ConfigFactory;

public class Properties {
    private Properties() {}

    public static FrameworkProperties get() {
        return ConfigFactory.create(FrameworkProperties.class);
    }
}