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
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class SenderAndReceiverScreen {


    public TestName name = new TestName();


    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;
    public static WebDriver driver;
    private static By radiobuton = By.cssSelector("[for=for-friend-radio]");
    private static By forwhos = By.cssSelector("[data-parsley-group=main]");
    private static By sendername = By.id("sender-name");
    private static By event = By.linkText("לאיזה אירוע?");
    private static By choseevent = By.className("active-result");
    private static By uploadimage = By.xpath("//span[contains(@class, 'icon icon-photo')]");
    private static By blesingtext = By.xpath("//textarea");
    private static By radiobuton2 = By.className("send-now");
    private static By chosemail = By.xpath("//span[contains(@class, 'icon icon-envelope')]");
    private static By chosesms = By.className("btn-send-option-inner");
    private static By inputemail = By.cssSelector("[data-parsley-type=email]");
    private static By inputsendernumber = By.cssSelector("[type=tel]");
    private static By inputrecevernumber = By.id("resendReciver");
    private static By saveemail = By.xpath("//button[contains(@class, 'btn btn-theme btn-save')]");
    private static By savereceversendernumber = By.xpath("//button[contains(@class, 'btn btn-theme btn-save')]");
    private static By submitpayment = By.cssSelector("[type=submit]");

    public static void clickforsomneelse(WebDriver driver) {//contain the somone else radiobuon
        driver.findElement(SenderAndReceiverScreen.radiobuton).click();
    }

    public static void enterrecevername(WebDriver driver) {//contain reciver name


        driver.findElement(SenderAndReceiverScreen.forwhos).sendKeys("friend");

    }


    public static void enterSenderName(WebDriver driver) {//contain sender name


        driver.findElement(SenderAndReceiverScreen.sendername).sendKeys("yourfriend");

    }


    public static void selsectocation(WebDriver driver) {//contain the drop box of the events



        driver.findElement(SenderAndReceiverScreen.event).click();
        List <WebElement> eventdropbox = driver.findElements(SenderAndReceiverScreen.choseevent);
        eventdropbox.get(3).click();

        System.out.println(driver.findElement(SenderAndReceiverScreen.blesingtext).getText());


    }


    public static void pickimage(WebDriver driver) {//contain the upload image button


        driver.findElement(SenderAndReceiverScreen.uploadimage).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");

    }

    public static void clicksendrigtnow(WebDriver driver) {//contain send right now radiobutton



        driver.findElement(SenderAndReceiverScreen.radiobuton2).click();


    }


    public static void clickSendByMail(WebDriver driver) {//contain send by mail buton and the email txt field with email save buton



        driver.findElement(SenderAndReceiverScreen.chosemail).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(SenderAndReceiverScreen.inputemail).sendKeys("karm_87_mo@hotmail.com");//input email
       // test.log(Status.PASS, "EMAIL INSERTED");
        driver.findElement(SenderAndReceiverScreen.saveemail).click();
        test.log(Status.PASS, "EMAIL SAVED");

    }


    public static void clicSendBySms(WebDriver driver) {//contain sms button +the sender recever txt filed + save button


     //   test.log(Status.INFO, "SMS");
        driver.findElement(SenderAndReceiverScreen.chosesms).click();
       // test.log(Status.PASS, "CHOSE SMS IS CLICKED");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(SenderAndReceiverScreen.inputsendernumber).sendKeys("0543248877");
        //test.log(Status.PASS, "SENDER  NUMBER INPUTED");
        driver.findElement(SenderAndReceiverScreen.inputrecevernumber).sendKeys("0548765657");
        //test.log(Status.PASS, " RECEVER NUMBER INPUTED");
        driver.findElement(SenderAndReceiverScreen.savereceversendernumber).click();
        //test.log(Status.PASS, "SENDER AND RECEVER NUMBER SAVED");


    }


    public static void clicktopay(WebDriver driver) {//contain submit button


       // test.log(Status.INFO, "SUBMET INFO");
        driver.findElement(SenderAndReceiverScreen.submitpayment).submit();
        //test.log(Status.PASS, "PAGE SUBMITED");
    }
}




