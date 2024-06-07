package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CreateEventPage
{
    private SHAFT.GUI.WebDriver driver;
    private By eventTitle = By.id("eventTitle");
    private By eventDescription = By.id("eventDescription");
    private By RecipientField = By.xpath("//*[@id='Recipients']/div/div/div[2]/input");
    private By Recipient= By.xpath("//div[@id='option_0']//div[@class='recipient__name']");
    private By Date = By.xpath("//*[@data-intercom-target='Datepicker input wrapper manage event dateundefined']");
    private By DayAndMonth = By.xpath("//span[text()='20']");
    private By HourFrom = By.id("timepickerStartTime");
    private By HourTo = By.id("timepickerEndTime");
    private  By ReminderbBeforeEvent = By.id("reminder_before_event__wrapper");
    private By ZoomBtn =By.xpath("//div[@id='isZoomMeeting__wrapper']//span[@class='clickable picon switch__toggle picon-toggle_left']");
    private By SubmitCreateEventBtn = By.id("submitCreateEventBtn");
    private By SuccessMessage= By.xpath("//div[@aria-label='Calendar event registered']");


    public CreateEventPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("Enter Event Information")
    public CreateEventPage EnterEventInformation(String EventTitle , String Description,String RecipientText  , String StartTime , String EndTime ) {
        driver.element()
                .type(eventTitle, EventTitle)
                .type(eventDescription, Description).hover(RecipientField)
                .type(RecipientField,RecipientText).click(Recipient)
                .click(Date)
                .click(DayAndMonth)
                .type(HourFrom,StartTime).keyPress(HourFrom,Keys.ENTER)
                .type(HourTo,EndTime).keyPress(HourTo,Keys.ENTER)
                .click(ReminderbBeforeEvent).click(ZoomBtn)
                .click(SubmitCreateEventBtn);
        return this;
    }
    @Step("Validate that an Event is Added Successfully")
    public CreateEventPage ValidateAnEventIsAddedSuccessfully(String expectedResult){
        driver.element().assertThat(SuccessMessage).text().isEqualTo(expectedResult).perform();
        return this;
    }
}
