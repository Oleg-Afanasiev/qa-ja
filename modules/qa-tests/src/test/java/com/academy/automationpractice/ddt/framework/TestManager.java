package com.academy.automationpractice.ddt.framework;

import com.academy.automationpractice.ddt.framework.helper.*;
import com.academy.automation.taf.BaseUiManager;
import com.academy.automation.taf.Configuration;
import com.academy.automation.taf.util.PropertyManager;

public class TestManager extends BaseUiManager {
    private static int IMPLICITLY_WAIT = 30;

    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private AccountHelper accountHelper;
    private VerifyHelper verifyHelper;
    private AddressHelper addressHelper;
    private WomenHelper womenHelper;

    // Конструктор
    public TestManager() {
        // Вызов конструктора базового класса
        super(new Configuration()
                .withChromeDriverLocation(PropertyManager.from("common").getProperty("chrome.driver"))
                .withGeckoDriverLocation(PropertyManager.from("common").getProperty("gecko.driver"))
                .withBaseUrl(PropertyManager.from("automation").getProperty("baseurl"))
                .withImplicitlyWait(IMPLICITLY_WAIT)
                .withLogin(PropertyManager.from("automation").getProperty("username"))
                .withPassword(PropertyManager.from("automation").getProperty("password"))
                .withScreenShotLocation(PropertyManager.from("automation").getProperty("screenshots"))
                .withLogBrowser(PropertyManager.from("automation").getBoolean("log.browser"))
                .withLogHttp(PropertyManager.from("automation").getBoolean("log.http"))
                .withLogPerformance(PropertyManager.from("automation").getBoolean("log.performance"))
                .withCloseBrowser(PropertyManager.from("common").getBoolean("close.browser"))
                .withReuseSession(PropertyManager.from("common").getBoolean("reuse.session"))
        );

    }

    @Override
    protected void initHelpers() {
        navigationHelper = new NavigationHelper(driver, PropertyManager.from("automation").getProperty("baseurl"));
        sessionHelper = new SessionHelper(driver, PropertyManager.from("automation").getProperty("username"), PropertyManager.from("automation").getProperty("password"));
        accountHelper = new AccountHelper(driver);
        addressHelper = new AddressHelper(driver);
        verifyHelper = new VerifyHelper(driver);
        womenHelper = new WomenHelper(driver);
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper session() {
        return sessionHelper;
    }

    public AccountHelper account() {
        return accountHelper;
    }

    public VerifyHelper verify() {
        return verifyHelper;
    }

    public AddressHelper address() {
        return addressHelper;
    }

    public  WomenHelper women(){return  womenHelper;}
}
