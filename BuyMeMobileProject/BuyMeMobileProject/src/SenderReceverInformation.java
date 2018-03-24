import com.android.resources.TouchScreen;
import com.sun.glass.events.GestureEvent;
import com.sun.glass.events.SwipeGesture;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.lang.ref.PhantomReference;
import java.security.Key;
import java.time.Duration;

public class SenderReceverInformation {
    private static By recevername = MobileBy.id("il.co.mintapp.buyme:id/toEditText");
    private static By eventsdropbox = MobileBy.id("android:id/text1");
    private static By eventclicked = MobileBy.AndroidUIAutomator("childSelector(new UiSelector().index(4))");
    private static By blesingtext = MobileBy.id("il.co.mintapp.buyme:id/blessEditText");
    private static By scroldownbuton = MobileBy.id("il.co.mintapp.buyme:id/blessEditText");
    private static By sndername=MobileBy.id("il.co.mintapp.buyme:id/userFrom");
    private static By contenu=MobileBy.id("il.co.mintapp.buyme:id/goNextButton");


    public static void enterReceverName(AndroidDriver <MobileElement> driver) {
        TouchAction keys = new TouchAction(driver);
        driver.findElement(SenderReceverInformation.recevername).click();
        driver.getKeyboard().sendKeys("friend");
        driver.hideKeyboard();


    }

    public static void selectEvent(AndroidDriver <MobileElement> driver) {

        //driver.findElement( MobileBy.AndroidUIAutomator( "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().id(il.co.mintapp.buyme:id/userFrom))")).click();
        TouchAction action = new TouchAction(driver);
        action.press(driver.findElement(SenderReceverInformation.recevername)).moveTo(driver.findElement(SenderReceverInformation.eventsdropbox)).perform();
        driver.findElement(SenderReceverInformation.eventsdropbox).click();
        driver.findElement(SenderReceverInformation.eventclicked).click();


    }
    public static void getBlesingText(AndroidDriver <MobileElement> driver){

        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/blessEditText\"))"));
       System.out.println( driver.findElement(SenderReceverInformation.blesingtext).getText());

    }


    public static void enterSenderName(AndroidDriver <MobileElement> driver){
        driver.findElement(SenderReceverInformation.sndername).click();
        driver.getKeyboard().sendKeys(Keys.BACK_SPACE);
        driver.getKeyboard().sendKeys("yourfriend");
        driver.hideKeyboard();

    }


    public static void preeContenu(AndroidDriver <MobileElement> driver){
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/goNextButton\"))"));
driver.findElement(SenderReceverInformation.contenu).click();
    }
}

