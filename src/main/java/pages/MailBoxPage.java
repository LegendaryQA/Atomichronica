package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailBoxPage extends StartPage{
    public MailBoxPage(WebDriver driver) {
        super(driver);
    }

    /** Buttons */
    @FindBy (xpath = "//*[@class='aic']/div/div")
    private WebElement composeButton;
    @FindBy(xpath = "//a[@href='https://mail.google.com/mail/#inbox']")
    private WebElement inboxList;
    @FindBy (xpath = "//div[@class='oj']//textarea")
    private WebElement recipientsInputField;
    @FindBy (xpath = "//div[@aria-label='Message Body']")
    private WebElement textInputArea;
    @FindBy (xpath = "//div[@class='J-J5-Ji']//following-sibling::div[@role='button']")
    private WebElement sendEmailButton;
    @FindBy (xpath = "//table//tbody//tr[1]//span[@class='bog']")
    private WebElement firstInboxItem;
    @FindBy (xpath = "//div[@class='adn ads']//descendant::div[@class='gs']//div[@dir='ltr']")
    private WebElement firstInboxItemContent;

    /** Actions */
    public void clickComposeButton(){clickElement(composeButton);}
    public void clickSendButton(){clickElement(sendEmailButton);}
    public void clickOnRecipientsLabel(){clickElement(recipientsInputField);}
    public void clickOnTextInputArea(){clickElement(textInputArea);}
    public void enterRecipientsEmail(String emailAddress){enterText(recipientsInputField,emailAddress);}
    public void enterEmailText(String message){enterText(textInputArea,message);}
    public void openInboxList(){ clickElement(inboxList);}
    public void openFirstEmail(){
        while (!firstInboxItem.isDisplayed()){
            openInboxList();
        }
        clickElement(firstInboxItem);
        }
    public String getFirstEmailText(){return firstInboxItemContent.getText();}
    public boolean waitUntilEmailIsReceived(){
        return firstInboxItem.isDisplayed();
    }

}
