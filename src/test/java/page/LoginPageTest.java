package page;

import config.Config;
import config.Driver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginPageTest {
    @BeforeClass
    public void beforeClass(){
        Driver.start();
    }

    @AfterClass
    public void afterClass(){
        Driver.getDriver().quit();
        Driver.getThreadLocal().remove();
    }

    @Description("这是一条成功登录页面的测试用例")
    @Story("登录页面")
    @Test
    public void login_success(){
        Config config=Config.load("/data/config.yaml");
        String name=new LoginPage().loginSuccess(config.username,config.password).getName();
        assertEquals("Admin User",name);
    }
}