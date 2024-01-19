package Tests;

import Base.TestBase;
import Pages.RegistrationPage;
import Pages.NavigationPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TestAssignment extends TestBase {
    RegistrationPage registrationPage;
    NavigationPage navigationPage;
    String current;
    JavascriptExecutor jsExecutor;
    @Test(priority = 1, description = "validate all input fields are filled in a form")
    public void validateAllInputFieldsAreFilled(){
        navigationPage = new NavigationPage(driver);
        registrationPage = new RegistrationPage(driver);
        getUrl(testData.getProperty("baseUrl"));
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 400)");
        navigationPage.clickAlertFrameBtn();
        sleep(10);
        navigationPage.clickFormBtn();
        sleep(10);
        navigationPage.clickPracticeBtn();
        sleep(5);
        registrationPage.enterFirstName();
        registrationPage.enterLastName();
        registrationPage.enterEmail();
        registrationPage.checkRadioBtn();
        jsExecutor.executeScript("window.scrollBy(0, 200)");
        registrationPage.enterMobileNum();
        registrationPage.clickDob();
//        registrationPage.enterSubject();
        jsExecutor.executeScript("window.scrollBy(0, 200)");
        registrationPage.checkHubbyBtn();
        registrationPage.enterAddressField();
        navigationPage.clickAlertBtn();
        navigationPage.clickBrowserWindowsBtn();
        sleep(10);
    }
}
