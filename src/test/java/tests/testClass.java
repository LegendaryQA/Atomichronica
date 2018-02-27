package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tools.BasicTestConditions;
import tools.PropertiesProvider;

public class testClass extends BasicTestConditions {

    private static  String email = PropertiesProvider.getProperty("account");
    private static  String password = PropertiesProvider.getProperty("password");
    private static  String message = PropertiesProvider.getProperty("email.message");

    @Test
    public void test(){
        startPage.enterEmailAddress(email);
        startPage.clickNextButton();
        startPage.enterPassword(password);
        startPage.clickNextButton();
        mailBoxPage.clickComposeButton();
        mailBoxPage.clickOnRecipientsLabel();
        mailBoxPage.enterRecipientsEmail(email);
        mailBoxPage.clickOnTextInputArea();
        mailBoxPage.enterEmailText(message);
        mailBoxPage.clickSendButton();
        mailBoxPage.openInboxList();
        mailBoxPage.openFirstEmail();
        Assert.assertEquals(mailBoxPage.getFirstEmailText().toString(), "Hello, world!");
    }
}
