package org.wipro.auspost.browsers;

import org.openqa.selenium.WebDriver;
import org.wipro.auspost.browsers.managers.ChromeManager;
import org.wipro.auspost.browsers.managers.EdgeManager;
import org.wipro.auspost.browsers.managers.FirefoxManager;
import org.wipro.auspost.browsers.enums.BrowserType;
import org.wipro.auspost.properties.Properties;

import java.net.MalformedURLException;
import java.util.EnumMap;
import java.util.function.Supplier;

public class Remote {
    private Remote() {
    }

    private static final String HUB = Properties.get().protocol() +
            "://" + Properties.get().host() + ":" + Properties.get().port();
    private static final EnumMap<BrowserType, Supplier<WebDriver>> map = new EnumMap<>(BrowserType.class);

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
        map.put(BrowserType.REMOTE_CHROME, remoteChrome);
        map.put(BrowserType.REMOTE_EDGE, remoteEdge);
        map.put(BrowserType.REMOTE_FIREFOX, remoteFirefox);
    }

    public static WebDriver launch(BrowserType browserType) {
        ThreadLocal<WebDriver> browser = ThreadLocal.withInitial(map.get(browserType));
        return browser.get();
    }
}