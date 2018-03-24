
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegestrationScreen {


    public static String regesterbuton="il.co.mintapp.buyme:id/walletTab";
    public static By googlebuton=MobileBy.id("il.co.mintapp.buyme:id/googleButton");
    public static By creatacount=MobileBy.className("android.widget.Button");
    public static By presspincode=MobileBy.id("com.android.settings:id/password_entry");
    public static By enteremail=MobileBy.id("identifierId");
    public static By next=MobileBy.id("identifierNext");
    public static By getpasswored=MobileBy.id("password");
    public static By next2=MobileBy.className("android.view.View");
    public static By enternumber=MobileBy.id("il.co.mintapp.buyme:id/pinBox");
    public static AndroidDriver<MobileElement> driver;
    @Rule
    public TestName name = new TestName();

    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent ;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test ;



    public static DesiredCapabilities capabilities;
    private static String getData (String keyName) throws ParserConfigurationException, IOException, SAXException {
        File configXmlFile = new File("C:\\Users\\Comp29\\Desktop\\App.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;

        assert dBuilder != null;
        doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    @BeforeClass
    public static void setcapabilites() {
        try {
test.log(Status.INFO,"mobile setup");

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\Comp29\\Desktop\\buymereport2.html");

            // choose to append each test
            htmlReporter.setAppendExisting(true);
            // attach reporter
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            // name your test and add description
            test = extent.createTest("Buymemobileproject", "");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "hawawi p9 lite");
            capabilities.setCapability("appPackage", getData("apppackage"));
            capabilities.setCapability("appActivity", getData("appactivity"));
            getData("appactivity");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
test.log(Status.PASS,"mobile and server hase been set succesfuly");
        }
        catch (Exception e ){
            test.log(Status.FAIL,e.getMessage());
        }
    }

        @Test
    public void test1_regesterbutton(){
        try {
test.log(Status.INFO,"regestration testing");
test.log(Status.INFO,"click the regester buton");
            driver.findElement(MobileBy.id(RegestrationScreen.regesterbuton)).click();
            test.log(Status.PASS,"buton clicked succesfuly");
            test.log(Status.INFO,"click regester by google account");
            //account was regesterd manully from gmail and used in this project
            driver.findElement(RegestrationScreen.googlebuton).click();
            test.log(Status.PASS,"google butoon hase presed succesfuly");
            test.log(Status.INFO,"click contnue");
            driver.findElement(RegestrationScreen.next2).click();
            test.log(Status.PASS," contenu button  presed succefuly");
        }
        catch (Exception e){
            test.log(Status.FAIL,e.getMessage());
        }

        }
        @Test
    public void test2_hoomscreentest(){
        test.log(Status.INFO,"chose catagory and gift");
        test.log(Status.INFO,"chose catagory");
        Homscreen.preescatagory(driver);
        test.log(Status.PASS,"catagory was chosen");
        test.log(Status.INFO,"chose gift");
        Homscreen.pressbusnis(driver);
        test.log(Status.PASS,"gift was chosen");
        test.log(Status.INFO,"enetr amount to pay ");
        Homscreen.entergiftbudgit(driver);
        test.log(Status.PASS,"amount was set succesfuly");
        test.log(Status.INFO,"press to buy button");
        Homscreen.presbuy(driver);
        test.log(Status.PASS,"to buy was preesed succesfuly");

        }

        @Test
    public void test3_receverandsenderinfo(){
            test.log(Status.INFO,"sender and recerver info page");
            test.log(Status.INFO,"recever name txtfiled");
        SenderReceverInformation.enterReceverName(driver);
        test.log(Status.PASS,"recever name was equired ");
            test.log(Status.INFO,"event dropbox");
            SenderReceverInformation.selectEvent(driver);
            test.log(Status.PASS,"event was equired");
            test.log(Status.INFO,"blessing textfiled");
            SenderReceverInformation.getBlesingText(driver);
            test.log(Status.PASS,"text was equired succesfuly");
            test.log(Status.INFO,"sender name textfiled");
            SenderReceverInformation.enterSenderName(driver);
            test.log(Status.PASS,"sender name was equired");
            test.log(Status.INFO,"contenue botton");
            SenderReceverInformation.preeContenu(driver);
            test.log(Status.PASS,"contenu was preesed");

        }




        @Test
    public void test4_howToPay1(){
            test.log(Status.INFO,"how to pay page ");
            test.log(Status.INFO,"send right now radiobutton");
        HowToPay.preeSendRightNow(driver);
        test.log(Status.PASS,"SEND RIGHT NOW WAS CLICKED");
            test.log(Status.INFO,"email checkbox");
            HowToPay.pressEmailSendOption(driver);
            test.log(Status.PASS,"email check box was cliCked and email was enterd in email txt field");
            test.log(Status.INFO,"contenu button");
            HowToPay.pressContenu(driver);
            test.log(Status.PASS,"CONTENU WAS PRESSED");

        }
        @After
        public void sceewnshot() throws IOException {
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Comp29\\Desktop\\karam2")).build());
            extent.flush();
        }
        @AfterClass
    public static void logoutandclosedriver(){
        driver.closeApp();
        }
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }



    }


