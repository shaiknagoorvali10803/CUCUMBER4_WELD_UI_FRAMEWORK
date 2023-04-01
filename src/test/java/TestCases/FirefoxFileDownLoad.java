package TestCases;

import Utils.SeleniumUtil_New;
import Utils.WebDriverProvider;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;

@Singleton
public class FirefoxFileDownLoad {
    @Test
    public void FirefoxTest(){
        String downloadFilepath = System.getProperty("user.dir");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", downloadFilepath);
        profile.setPreference("browser.download.useDownloadDir", true);
        profile.setPreference("browser.download.viewableInternally.enabledTypes", "");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/xlsx;application/msword;application/ms-doc;application/doc;application/pdf;text/plain;application/text;text/xml;application/xml");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(profile);
        firefoxOptions.setHeadless(false);
        firefoxOptions.addArguments("--disable-web-security");
        firefoxOptions.addArguments("--allow-running-insecure-content");
        firefoxOptions.addArguments("--whitelist-ip *");
        firefoxOptions.addArguments("--ignore-certificate-errors", "--ignore-ssl-errors");
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

        // to launch chrome in incognito mode
        firefoxOptions.addArguments("start-maximized");
        firefoxOptions.addArguments("--private");
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.get("http://www.seleniumhq.org/download/");
        SeleniumUtil_New.waitForElement(driver, driver.findElement(By.linkText("32 bit Windows IE")));
        driver.findElement(By.linkText("32 bit Windows IE")).click();
        SeleniumUtil_New.waitByTime(5000);
        driver.close();
    }
}
