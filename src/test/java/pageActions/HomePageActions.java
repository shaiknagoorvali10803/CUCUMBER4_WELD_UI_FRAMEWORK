package pageActions;


import Utils.SeleniumUtil;
import Utils.WebDriverProvider;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePageLocators;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.time.Duration;

@Singleton
public class HomePageActions {
    @Inject
    private HomePageLocators homePageLocators;
    @Inject
    WebDriverProvider driverProvider;

    @PostConstruct
    public void setUp() throws IOException {
        PageFactory.initElements(driverProvider.getInstance(), homePageLocators);
    }

    public String getHomePageText() {
        System.out.println("HomePage Text is : " + SeleniumUtil.getValueByElement(driverProvider.getInstance(), homePageLocators.homePageUserName));
        SeleniumUtil.waitForElement(driverProvider.getInstance(), homePageLocators.homePageUserName, 30);
        return homePageLocators.homePageUserName.getText();
    }

}