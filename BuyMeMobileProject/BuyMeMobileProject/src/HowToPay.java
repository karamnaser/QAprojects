import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

public class HowToPay {
    private static By rightnow = MobileBy.id("il.co.mintapp.buyme:id/nowRadioButton");
    private static By howtosendoption = MobileBy.className("android.widget.CheckBox");
    private static By email = MobileBy.className("android.widget.EditText");
    private static By contenu = MobileBy.id("il.co.mintapp.buyme:id/goNextButton");


    public static void preeSendRightNow(AndroidDriver<MobileElement> driver) {
driver.findElement(HowToPay.rightnow).click();

    }


    public static void pressEmailSendOption(AndroidDriver <MobileElement> driver) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/goNextButton\"))"));
        List<MobileElement>options=driver.findElements(HowToPay.howtosendoption);
        options.get(2).click();
        driver.findElement(HowToPay.email).sendKeys("katds_m_12@hotmail.com");


    }


    public static void pressContenu(AndroidDriver <MobileElement> driver) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."
                +"scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/goNextButton\"))"));
        driver.findElement(HowToPay.contenu).click();

    }
}






