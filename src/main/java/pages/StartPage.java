package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
    protected WebDriver driver;
    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public WebDriver getDriver() {
        return driver;
    }

    public void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10); //seconds
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10); //seconds
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clickElement(WebElement element){
        waitUntilVisible(element);
        waitForElementToBeClickable(element);
        element.click();
    }
    public void enterText(WebElement element, String text){
        waitUntilVisible(element);
        waitForElementToBeClickable(element);
        element.sendKeys(text);
    }

    /** Buttons */
    @FindBy (xpath = "//form//descendant::input[@type='email']")
    private WebElement accountInputField;
    @FindBy (xpath = "//span[contains(text(),'Next')]")
    private WebElement nextButton;
    @FindBy (xpath = "//form//descendant::input[@type='password']")
    private WebElement passwordInputField;

    /** Actions */
    public void enterEmailAddress(String email){enterText(accountInputField,email);}
    public void clickNextButton(){clickElement(nextButton);}
    public void enterPassword(String password){enterText(passwordInputField,password);}
}
