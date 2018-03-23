
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BuyMeUserRegestration {
    @Rule
    public TestName name = new TestName();


    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;



    public static WebDriver driver;
    public static By rgesterandenter = By.className("seperator-link");

    public static By regesterwindow = By.xpath("//strong");
    public static By username = By.cssSelector("[type=text]");
    public static By passwored = By.id("valPass");
    public static By confirmpasswored = By.id("ember859");
    public static By email = By.cssSelector("[type=email]");
    public static By radiobutton = By.cssSelector("[for=register-consent]");
    public static By submitpage = By.cssSelector("[type=submit]");

    private static String getData(String keyName) throws ParserConfigurationException, IOException, SAXException, NullPointerException {
        File configXmlFile = new File("C:\\Users\\Comp29\\Desktop\\xmlbrowser1.xml");
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
    public static void beforStart() throws IOException, SAXException, ParserConfigurationException, NullPointerException {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\Comp29\\Desktop\\buymereport.html");
        extent = new ExtentReports();
        htmlReporter.setAppendExisting(false);
        extent.attachReporter(htmlReporter);
        test = extent.createTest("BuyMeTesting ", "Sample description");
        extent.setSystemInfo("company","dell");


        test.log(Status.INFO, "@Before class");

        String databrowser = getData("Browsertype1");
        switch (databrowser) {
            case "Chrom":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Comp29\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.get("http://www.buyme.co.il");
                if (driver==null){
                    test.log(Status.FATAL,"driver faild to actevate");
                }
                else {
                    test.log(Status.PASS, "Driver established successfully");
                }
                break;
            case "Firfox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Comp29\\Desktop\\New folder\\geckodriver-v0.19.1-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.get("http://www.buyme.co.il");
                if (driver==null){
                    test.log(Status.FATAL,"driver faild to actevate");
                }
                else {
                    test.log(Status.PASS, "Driver established successfully");
                }


        }

    }

    @Before
    public void waitforaction(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
        @Test
        public void test1_openWithChrom() {//contain all user regester information
          try {
                test.log(Status.INFO, "@test1");

                ArrayList <String> newwindows = new ArrayList <String>(driver.getWindowHandles());//array for new windows
                driver.findElement(BuyMeUserRegestration.rgesterandenter).click();//click regester and enter button
                test.log(Status.PASS, "regstration buton clicked");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.switchTo().window(newwindows.get(0));//take me to regester window
                driver.findElement(BuyMeUserRegestration.regesterwindow).click();//click on not yet regesterd
                test.log(Status.PASS, " buton clicked");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.findElement(BuyMeUserRegestration.username).sendKeys("karam");//contain username
                test.log(Status.PASS, "user name is fild");
            driver.findElement(BuyMeUserRegestration.email).sendKeys(generateString()+"@"+"hotmail.com");//contain email
            test.log(Status.PASS, "email is inputed");
                driver.findElement(BuyMeUserRegestration.passwored).sendKeys("eeeeeeeeee");//contain passowred
                test.log(Status.PASS, "passwored is inputed");
                driver.findElement(BuyMeUserRegestration.confirmpasswored).sendKeys("eeeeeeeeee");//contain confirming passwored
                test.log(Status.PASS, "confirme passowred is inputed");
                driver.findElement(BuyMeUserRegestration.radiobutton).click();//contain i accept condition
                test.log(Status.PASS, "radiobutton is clicked");
                driver.findElement(BuyMeUserRegestration.submitpage).submit();//contain submit button
                test.log(Status.PASS, "submit succesfully");
            }catch (Exception e){
                test.log(Status.FAIL,e.getMessage());
            }

       }
       @Test

    public void test2_searchForGift() {
           try {


               test.log(Status.INFO, "selectedprice");
               BuyMeGiftSerching.selectprice(driver);
               test.log(Status.PASS, "price is selected");
               test.log(Status.INFO, "selectedres");
               BuyMeGiftSerching.selectadres(driver);
               test.log(Status.PASS, "adres is selected");
               test.log(Status.INFO, "selctedcatagory");
               BuyMeGiftSerching.selectcatagory(driver);
               test.log(Status.PASS, "catagory is selected");
               test.log(Status.INFO, "check searchin button");
               BuyMeGiftSerching.search(driver);
               test.log(Status.PASS, "button checked");
           }
           catch (Exception e){
               test.log(Status.FAIL,e.getMessage());
           }
       }
    @Test
    public void test3_pickGift() {
        try {


            test.log(Status.INFO, "CLICKEDGIFT");
            BuyMeGiftPage.clickongift(driver);
            test.log(Status.PASS, "VOUCHER IS PICKED");

        }
        catch (Exception e){
            test.log(Status.FAIL,e.getMessage());
        }

    }
@Test
    public void test4_submitinformation() {
    try {


        test.log(Status.INFO, "@radiobuton");
        SenderAndReceiverScreen.clickforsomneelse(driver);
        test.log(Status.PASS, "RADIOBUTTON CLICKED");
        test.log(Status.INFO, "RECEVER FILED TXT");
        SenderAndReceiverScreen.enterrecevername(driver);
        test.log(Status.PASS, "RECERVER NAME IS ENTERED");
        test.log(Status.INFO, "SENDER FILED TXT");
        SenderAndReceiverScreen.enterSenderName(driver);
        test.log(Status.PASS, "SENDER NAME IS ENTERED");
        test.log(Status.INFO, "CHOSE EVENT ");
        SenderAndReceiverScreen.selsectocation(driver);
        test.log(Status.PASS, "EVENT IS SELECTED");
        test.log(Status.PASS, "BLESING MASSEG IS ENTERD");
        test.log(Status.INFO, "uploadimage");
        SenderAndReceiverScreen.pickimage(driver);
        test.log(Status.INFO, "EMAIL");
        SenderAndReceiverScreen.clickSendByMail(driver);
        test.log(Status.PASS, "SEND BY EMAIL IS CLICKED");
        SenderAndReceiverScreen.clicSendBySms(driver);
        test.log(Status.INFO, "SENDRIGHT NOW BUTTON");
        SenderAndReceiverScreen.clicksendrigtnow(driver);
        test.log(Status.PASS, "SEND NOW IS SELECTED");
        SenderAndReceiverScreen.clicktopay(driver);
        test.log(Status.PASS, "PAGE SUBMITED");
    }
    catch (Exception e){
        test.log(Status.FAIL,e.getMessage());
    }
}

    @After
    public  void takescreenshotandclose() throws IOException {
        try {


            test.log(Status.INFO, "screen shot");

            test.pass("translateion", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\Comp29\\Desktop\\karam")).build());
            test.log(Status.PASS, "SCRENSHOT TAKEN");
            extent.flush();
        }
        catch (Exception e){
            test.log(Status.FAIL,e.getMessage());
        }
    }
@AfterClass
public static void closewindow(){
    driver.close();
}
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
   }
        public static String generateString() {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "").replaceAll("=","");
            return  uuid;
        }

    }






