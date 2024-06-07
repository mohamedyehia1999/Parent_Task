package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class DashboardPage
{
    private SHAFT.GUI.WebDriver driver;
    private By dialog= By.id("pushActionRefuse");
    private By DemoCompanyCanada = By.xpath("//div[normalize-space()='Demo company Canada']");
    private By calendarBtn = By.xpath("//div[@class='container align-items-center']//a[@id='calendarTab']");
    private By createEventBtn = By.id("createEventBtn");
    public DashboardPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public DashboardPage OpenInstitutePageAndCreateEventPage(){
        driver.element()
                .click(dialog).click(DemoCompanyCanada)
                .click(calendarBtn)
                .click(createEventBtn);
        return this;
    }


}
