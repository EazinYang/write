package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static ThreadLocal<WebDriver> threadLocal=new ThreadLocal();

    public static void start(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        threadLocal.set(driver);
        Config config=Config.load("/data/config.yaml");
        getDriver().get(config.url);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static ThreadLocal<WebDriver> getThreadLocal() {
        return threadLocal;
    }

    public static WebDriver getDriver(){
        return threadLocal.get();
    }
}
