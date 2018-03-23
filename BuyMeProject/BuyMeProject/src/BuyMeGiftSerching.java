
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuyMeGiftSerching {
    private static String webpageurl;
    private TestName name = new TestName();
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;
    private static WebDriver driver;
    private static By pricelist = By.className("select-wrapper");
    private static By choseprice = By.className("chosen-results");
    private static By adreslist = By.cssSelector("[id=ember600_chosen]");
    private static By choseadris = By.cssSelector("li.active-result:nth-child(2)");
    private static By catagorylist = By.id("ember609_chosen");
    private static By chosechatagore = By.className("active-result");
    private static By search = By.cssSelector("[type=submit]");


    public static void selectprice(WebDriver driver) {



            driver.findElement(BuyMeGiftSerching.pricelist).click();
            driver.findElement(BuyMeGiftSerching.choseprice).click();


        }


    public static void selectadres(WebDriver driver) {



            driver.findElement(BuyMeGiftSerching.adreslist).click();
            driver.findElement(BuyMeGiftSerching.choseadris).click();

        }

    public static void selectcatagory(WebDriver driver) {


        driver.findElement(BuyMeGiftSerching.catagorylist).click();
        List <WebElement> chosechatagore0 = driver.findElements(BuyMeGiftSerching.chosechatagore);
        chosechatagore0.get(4).click();


    }


    public static void search(WebDriver driver) {//contain search button + the gift card price text field+ to buy button
        driver.findElement(BuyMeGiftSerching.search).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         webpageurl = driver.getCurrentUrl();
        System.out.println(webpageurl);
        Assert.assertEquals(webpageurl, driver.getCurrentUrl());
    }
}




