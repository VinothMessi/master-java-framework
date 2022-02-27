package org.wipro.auspost.browsers;

import org.openqa.selenium.WebDriver;
import org.wipro.auspost.browsers.managers.ChromeManager;
import org.wipro.auspost.browsers.managers.EdgeManager;
import org.wipro.auspost.browsers.managers.FirefoxManager;
import org.wipro.auspost.enums.Browsers;

import java.util.EnumMap;
import java.util.function.Supplier;

public class LocalBrowsers {
    private LocalBrowsers() {
    }

    private static final EnumMap<Browsers, Supplier<WebDriver>> map = new EnumMap<>(Browsers.class);

    private static final Supplier<WebDriver> chrome = ChromeManager::getDriver;
    private static final Supplier<WebDriver> edge = EdgeManager::getDriver;
    private static final Supplier<WebDriver> firefox = FirefoxManager::getDriver;
    private static final Supplier<WebDriver> headlessChrome = () -> ChromeManager.getDriver(true);
    private static final Supplier<WebDriver> headlessEdge = () -> EdgeManager.getDriver(true);
    private static final Supplier<WebDriver> headlessFirefox = () -> FirefoxManager.getDriver(true);

    static {
        map.put(Browsers.CHROME, chrome);
        map.put(Browsers.EDGE, edge);
        map.put(Browsers.FIREFOX, firefox);
        map.put(Browsers.HEADLESS_CHROME, headlessChrome);
        map.put(Browsers.HEADLESS_EDGE, headlessEdge);
        map.put(Browsers.HEADLESS_FIREFOX, headlessFirefox);
    }

    public static WebDriver launch(Browsers browserType) {
        ThreadLocal<WebDriver> browser = ThreadLocal.withInitial(map.get(browserType));
        return browser.get();
    }
}