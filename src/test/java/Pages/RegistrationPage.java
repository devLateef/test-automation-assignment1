package Pages;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;

import static Base.TestBase.testData;

public class RegistrationPage extends PageBase {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstNameInput;
    @FindBy(id = "lastName")
    WebElement lastNameInput;
    @FindBy(id = "userEmail")
    WebElement emailInput;
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement radioBtn;
    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    WebElement mobileNum;
    @FindBy(id = "dateOfBirthInput")
    WebElement dobField;
    @FindBy(id = "subjectsContainer")
    WebElement subjectField;
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    WebElement hobbyBtn;
    @FindBy(xpath = "//textarea[@placeholder='Current Address']")
    WebElement addressField;

    public void enterFirstName(){
        enterText(firstNameInput, testData.getProperty("firstName"));
    }
    public void enterLastName(){
        enterText(lastNameInput, testData.getProperty("lastName"));
    }
    public void enterEmail(){
        enterText(emailInput, testData.getProperty("email"));
    }
    public void checkRadioBtn(){
        click(radioBtn);
    }
    public void enterMobileNum(){
        enterText(mobileNum, testData.getProperty("phone"));
    }
    public void clickDob(){
        dobField.clear();
        enterText(dobField, testData.getProperty("dob"));
    }
//    public void enterSubject(){
//        enterText(subjectField, "Subject is subject");
//    }
//    public void checkHubbyBtn(){
//        click(hobbyBtn);
//    }
    public void enterAddressField(){
        enterText(addressField, testData.getProperty("address"));
    }

}
