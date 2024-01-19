package Pages;

import Base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage extends PageBase {
    WebDriver driver;
    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    RegistrationPage registrationPage = new RegistrationPage(driver);

    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[3]")
    WebElement alertFrameBtn;
    @FindBy(xpath = "(//div[@class='header-wrapper'])[2]")
    WebElement formBtn;
    @FindBy(xpath = "//div[@class='element-list collapse show']")
    WebElement practiceBtn;
    @FindBy(xpath = "(//div[@class='header-wrapper'])[3]")
    WebElement alertBtn;
    @FindBy(id = "item-0")
    WebElement browserWindowsBtn;
    @FindBy(id = "tabButton")
    WebElement newTabBtn;

    public void clickAlertFrameBtn(){
        click(alertFrameBtn);
    }
    public void clickFormBtn(){
        click(formBtn);
    }
    public void clickPracticeBtn(){
        click(practiceBtn);
    }
    public void clickAlertBtn(){
        click(alertBtn);
    }
    public void clickBrowserWindowsBtn(){
        click(browserWindowsBtn);
    }
    public void clickNewTabBtn(){
        click(newTabBtn);
    }
}
