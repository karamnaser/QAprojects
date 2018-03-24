import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

public class Homscreen {
    private static By catagory= MobileBy.AndroidUIAutomator("new UiSelector().index(0)");
    private static By busnis=MobileBy.id("il.co.mintapp.buyme:id/businessName");
private static By budget=MobileBy.id("il.co.mintapp.buyme:id/priceEditText");
private static By buy=MobileBy.id("il.co.mintapp.buyme:id/purchaseButton");




    public static void preescatagory(AndroidDriver<MobileElement>driver){
        List<MobileElement>catagorys=driver.findElements(Homscreen.catagory);
        catagorys.get(0).click();


    }



    public static void pressbusnis(AndroidDriver<MobileElement>driver){

driver.findElement(Homscreen.busnis).click();


    }


    public static void entergiftbudgit(AndroidDriver<MobileElement>driver){
        TouchAction keys=new TouchAction(driver);
        driver.findElement(Homscreen.budget).click();
        driver.getKeyboard().sendKeys("80");


    }


    public static void presbuy(AndroidDriver<MobileElement>driver){
        driver.findElement(Homscreen.buy).click();
    }


}
