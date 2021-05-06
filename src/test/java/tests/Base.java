package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {

    public static WebDriver driver;
    public static ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();

    public WebDriver init() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        
        driver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"), options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        tDriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tDriver.get();
    }
}
