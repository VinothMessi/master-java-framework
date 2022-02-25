package org.wipro.auspost.testcases;

import org.testng.annotations.Test;
import org.wipro.auspost.properties.FromProperties;

public class SanityTest {
    @Test
    public void sanityTest() {
        System.out.println(FromProperties.get().browser());
    }
}