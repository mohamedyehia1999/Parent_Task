package tests;

import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateEventPage;
import pages.LoginPage;
import pages.DashboardPage;

public class CreateEventTest extends  BaseTest
{
    private SHAFT.TestData.JSON createEventData;
    private SHAFT.TestData.JSON loginData;


    @Test(description = "Verify that User Can Create New Event Successfully")
    public void UserCanCreateEventSuccessfully()
    {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterLoginInformation(loginData.getTestData("Email"),
                loginData.getTestData("Password")).ValidateOnLoginSuccess();
        DashboardPage dashboardPagePage = new DashboardPage(driver);
        dashboardPagePage.OpenInstitutePageAndCreateEventPage();
        CreateEventPage createEventPage = new CreateEventPage(driver);
        createEventPage.EnterEventInformation(createEventData.getTestData("Event_title")
                , createEventData.getTestData("Description")
                , createEventData.getTestData("RecipientText")
                , createEventData.getTestData("start_Time")
                , createEventData.getTestData("end_Time") );

        createEventPage
                .ValidateAnEventIsAddedSuccessfully(createEventData.getTestData("EventCreatedSuccessMessage"));

    }

    @BeforeClass
    public void CreateEventDataDriven()
    {
        loginData= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/LoginData.json");
        createEventData= new SHAFT.TestData.JSON("src/test/resources/testDataFiles/CreateEventData.json");
    }


}
