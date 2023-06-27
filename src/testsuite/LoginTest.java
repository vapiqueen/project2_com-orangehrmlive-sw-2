package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "= https://opensource-demo.orangehrmlive.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {

//Enter the Username in Username field
        driver.findElement(By.name("username")) .sendKeys("Admin");


        // Find the password Field and Enter Password
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Click on Login Button
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
//Verify the text 'Dashboard'
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals("Forgot your password is not diplayed", expectedText, actualText);




    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
