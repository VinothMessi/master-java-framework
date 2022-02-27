package org.wipro.auspost.browsers;

import org.openqa.selenium.WebDriver;
import org.wipro.auspost.browsers.managers.ChromeManager;
import org.wipro.auspost.browsers.managers.EdgeManager;
import org.wipro.auspost.browsers.managers.FirefoxManager;
import org.wipro.auspost.enums.Browsers;

import java.net.MalformedURLException;
import java.util.EnumMap;
import java.util.function.Supplier;

public class RemoteBrowsers {
    private RemoteBrowsers() {
    }

    private static final String HUB = "http://localhost:4444";
    private static final EnumMap<Browsers, Supplier<WebDriver>> map = new EnumMap<>(Browsers.class);

    private static final Supplier<WebDriver> remoteChrome = () -> {
        try {
            return ChromeManager.getDriver(HUB);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unable to create remoteChrome session");
        }
    };
    private static final Supplier<WebDriver> remoteEdge = () -> {
        try {
            return EdgeManager.getDriver(HUB);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unable to create remoteEdge session");
        }
    };
    private static final Supplier<WebDriver> remoteFirefox = () -> {
        try {
            return FirefoxManager.getDriver(HUB);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unable to create remoteFirefox session");
        }
    };

    static {
        map.put(Browsers.REMOTE_CHROME, remoteChrome);
        map.put(Browsers.REMOTE_EDGE, remoteEdge);
        map.put(Browsers.REMOTE_FIREFOX, remoteFirefox);
    }

    public static WebDriver launch(Browsers browserType) {
        ThreadLocal<WebDriver> browser = ThreadLocal.withInitial(map.get(browserType));
        return browser.get();
    }
}