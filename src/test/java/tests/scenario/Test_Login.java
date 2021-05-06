package tests.scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import others.AllureListener;
import pages.Page_Login_Module;
import pages.Page_Start;
import pages.Page_User;
import tests.Base;

import java.net.MalformedURLException;

@Listeners({AllureListener.class})
public class Test_Login {

    public WebDriver driver;

    Page_Start page_Start;
    Page_Login_Module page_Login_Module;
    Page_User page_User;

    Test_Login()
    {
        page_Start = new Page_Start();
        page_Login_Module = new Page_Login_Module();
        page_User = new Page_User();
    }

    @BeforeClass
    public void setUp() throws MalformedURLException {
        Base bs= new Base();
        driver = bs.init();
        driver.get("https://e-uczelnia.ue.katowice.pl/wu/start");

    }

    @Test(description="Verify logo")
    @Description("Verify logo visibility on Start Page")
    @Epic("Epic: EP001")
    @Feature("Feature: Login")
    @Story("Story: Correct login")
    @Step("Verify logo visibility")
    public void logoVisibility() {

        String title = "Wirtualna Uczelnia";
        Assert.assertEquals(driver.getTitle(), title);

    }

    @Test(description="Verify user login", dependsOnMethods = {"logoVisibility"})
    @Description("Verify user login with valid credentials")
    @Epic("Epic: EP001")
    @Feature("Feature: Login")
    @Story("Story: Correct login")
    @Step("Verify login")
    public void loginTest()
    {
        String username = "username";
        String password = "password";
        String user = "PRZEMYSŁAW PIWONI (STUDENT)";

        page_Start.open_Login_Module();
        page_Login_Module.enter_Login_Details_And_Click_Button(username, password);

        Assert.assertEquals(page_User.verify_User(), user);

    }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}