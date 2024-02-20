package page;

import method.Method;
import org.openqa.selenium.By;

public class HomePage extends Method {
    public static By account_icon=idOrXpath("//button[@title='Admin User']/span");

    public static String getName(){
        return find(account_icon).getText();
    }
}
