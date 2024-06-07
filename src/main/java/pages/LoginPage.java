package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    private SHAFT.GUI.WebDriver driver;

    private By email_login = By.id("txtEmail");
    private By password_login = By.id("txtPassword");
    private By signInbtn = By.id("submitBtn");
    private By companyName = By.cssSelector("div.company-name");





    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Enter Login Information")
    public LoginPage EnterLoginInformation(String Email, String Password)
    {
        driver.element()
                .type(email_login,Email)
                .type(password_login,Password)
                .click(signInbtn);
        return this;
    }
    @Step("Validate on User Login Successfully")
    public LoginPage ValidateOnLoginSuccess(){
        driver.element().assertThat(companyName).exists().perform();
        return this;
    }


}
