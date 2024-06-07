package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

@Feature("Login")
public class LoginTest extends BaseTest
{
    private SHAFT.TestData.JSON loginData;

    @Test(description = "Verify that User Can Login to Website Successfully")
    public void UserCanLoginSuccessfully(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .EnterLoginInformation(loginData.getTestData("Email"),
                loginData.getTestData("Password"))
                .ValidateOnLoginSuccess();
    }
    @BeforeClass
    public void LoginDataDriven()
    {
        loginData= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/LoginData.json");
    }



}
