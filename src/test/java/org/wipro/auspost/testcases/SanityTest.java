package org.wipro.auspost.testcases;

import org.testng.annotations.Test;
import org.wipro.auspost.properties.Properties;

public class SanityTest {
    @Test
    public void sanityTest() {
        System.out.println("My Browser:" + Properties.get().browser());
    }
}