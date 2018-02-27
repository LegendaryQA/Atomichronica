package tools;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

public class BasicTestConditions {

    protected static final String BASEURL = PropertiesProvider.getProperty("base.url");
    private static final int TIMEOUT = Integer.parseInt(PropertiesProvider.getProperty("time.out"));

    protected static WebDriver driver;
    protected static StartPage startPage;
    protected static MailBoxPage mailBoxPage;

    private static String webdriverName = PropertiesProvider.getProperty("webdriver.name");
    /** This methods will be executed before every test class*/

    @BeforeClass (alwaysRun = true)
    public void beforeClassSetUp() throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        driver = (WebDriver) Class.forName(webdriverName).getConstructor().newInstance();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASEURL);
        startPage = new StartPage(driver);
        mailBoxPage = new MailBoxPage(driver);
    }
    /** This methods will be executed after every test class*/
    @AfterClass (alwaysRun = true)
    public static void afterClassTearDown() {
        driver.quit();
    }
}
