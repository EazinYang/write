package method;

import config.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Method extends Driver {
    public static By idOrXpath(String locator){
        if(locator.matches("//.*")){
            return By.xpath(locator);
        }else {
            return By.id(locator);
        }
    }

    public static WebElement find(By by){
        try{
            wait(by);
            return getDriver().findElement(by);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<WebElement> finds(By by){
        try{
            wait(by);
            return getDriver().findElements(by);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void wait(By by){
        WebDriverWait wait=new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}

