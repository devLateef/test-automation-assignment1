package Tests;

import Base.TestBase;
import Pages.RegistrationPage;
import Pages.NavigationPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TestAssignment extends TestBase {
    RegistrationPage registrationPage;
    NavigationPage navigationPage;
    String current;
    JavascriptExecutor jsExecutor;
    @Test(priority = 1, description = "validate all input fields are filled in a form")
    public void validateAllInputFieldsAreFilled() {
        navigationPage = new NavigationPage(driver);
        registrationPage = new RegistrationPage(driver);
        getUrl(testData.getProperty("baseUrl"));
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 400)");
        navigationPage.clickAlertFrameBtn();
        navigationPage.clickFormBtn();
        navigationPage.clickPracticeBtn();
        registrationPage.enterFirstName();
        registrationPage.enterLastName();
        registrationPage.enterEmail();
        registrationPage.checkRadioBtn();
        sleep(5);
        jsExecutor.executeScript("window.scrollBy(0, 200)");
        registrationPage.enterMobileNum();
        registrationPage.clickDob();
        sleep(5);
//        registrationPage.enterSubject();
        jsExecutor.executeScript("window.scrollBy(0, 200)");
//        registrationPage.checkHubbyBtn();
        registrationPage.enterAddressField();
    }

    @Test(priority = 2, description = "validate new tab implementation")
    public void validateWindowNavigation(){
        navigationPage = new NavigationPage(driver);
        registrationPage = new RegistrationPage(driver);
        navigationPage.clickAlertBtn();
        navigationPage.clickBrowserWindowsBtn();
        navigationPage.clickNewTabBtn();
        sleep(5);
        current = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();
        Iterator<String> iterator = allTabs.iterator();
        while(iterator.hasNext()) {
            String child = iterator.next();
            if(!current.equals(child)) {
                driver.switchTo().window(child);
            }
        }
        sleep(5);
        driver.close();
        driver.switchTo().window(current);
        sleep(5);
    }
}
