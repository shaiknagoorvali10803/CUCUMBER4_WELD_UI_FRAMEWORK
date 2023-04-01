package pageActions;

import Utils.SeleniumUtil;
import Utils.WebDriverProvider;
import org.openqa.selenium.support.PageFactory;
import pageobjects.LoginPageLocators;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class LoginPageActions {
    @Inject
    private LoginPageLocators loginPageLocators;
    @Inject
    WebDriverProvider driverProvider;

    @PostConstruct
    public void setUp() throws IOException {
        PageFactory.initElements(driverProvider.getInstance(), loginPageLocators);
    }

    public void setUserName(String strUserName) {
        SeleniumUtil.setValueToElement(driverProvider.getInstance(), loginPageLocators.userName, strUserName);
    }

    public void setPassword(String strPassword) {
        SeleniumUtil.setValueToElement(driverProvider.getInstance(), loginPageLocators.password, strPassword);
    }

    public void clickLogin() {
        SeleniumUtil.clickElementbyWebElement(driverProvider.getInstance(), loginPageLocators.login);
    }

    public String getLoginTitle() {
        return SeleniumUtil.getValueByElement(driverProvider.getInstance(), loginPageLocators.titleText);
    }

    public String getErrorMessage() {
        return SeleniumUtil.getValueByElement(driverProvider.getInstance(), loginPageLocators.errorMessage);
    }

    public Boolean getLinkedInIcon() {
        return SeleniumUtil.isElementDisplayed(loginPageLocators.linkedInIcon);
    }

    public Boolean getFaceBookIcon() {
        return SeleniumUtil.isElementDisplayed(loginPageLocators.faceBookIcon);

    }

    public void clickOnForgetYourPasswordLink() {
        SeleniumUtil.clickElementbyWebElement(driverProvider.getInstance(), loginPageLocators.ForgotYourPasswordLink);

    }

    public void login(String strUserName, String strPassword) {
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickLogin();

    }
}
