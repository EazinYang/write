package page;

import method.Method;
import org.openqa.selenium.By;

public class LoginPage extends Method {
    public static By username_btn=idOrXpath("//input[@placeholder='Username']");
    public static By password_btn=idOrXpath("//input[@placeholder='Password']");
    public static By login_btn=idOrXpath("//button[@type='button']");
    public static By loginWithAccount_btn=idOrXpath("//button[@type='button'][2]");

    public static HomePage loginSuccess(String username,String password){
        find(loginWithAccount_btn).click();
        find(username_btn).sendKeys(username);
        find(password_btn).sendKeys(password);
        find(login_btn).click();
        return new HomePage();
    }
}
