import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.junit.Test;
import org.junit.BeforeClass;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuyMeGiftPage {

    public TestName name = new TestName();


    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;
    private static By pickgift = By.className("promo-item-cover");
    private static By giftcardamount = By.cssSelector("[type=tel]");
    private static By tobuy = By.xpath("//div/div[contains(@class, 'btn-wrapper')]/button[contains(@class, 'btn btn-theme')]");
    private static WebDriver driver;

    public static void clickongift(WebDriver driver) {


        List <WebElement> gifts = driver.findElements(BuyMeGiftPage.pickgift);
        gifts.get(1).click();
        // test.log(Status.INFO, "GIFT IS CLICKED");
        driver.findElement(BuyMeGiftPage.giftcardamount).sendKeys("80");
        driver.findElement(BuyMeGiftPage.tobuy).click();

    }


}