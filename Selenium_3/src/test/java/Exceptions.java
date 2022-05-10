import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Exceptions{
    public WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public  void Task_1() throws InterruptedException {
        String url = "https://jqueryui.com/datepicker/";
        driver.get(url);
        try{
            driver.switchTo().frame(0);
            WebElement dateButton = driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
            dateButton.click();
            WebElement lastDay = driver.findElement(By.xpath("((//table//tr)[last()]//td[not (contains(@class, 'ui-datepicker-other-month ui-datepicker-unselectable ui-state-disabled'))])[last()]"));
            lastDay.click();
            System.out.println(lastDay.getText());
            driver.switchTo().defaultContent();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void Task_2_1(){ //Try to invoke TimeOutException exception
        String url = "https://demoqa.com/alerts";
        driver.get(url);

        WebElement clickOnWithId = driver.findElement(By.id("timerAlertButton"));
        clickOnWithId.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.alertIsPresent());
        }catch (TimeoutException  e){
            System.out.println("TimeoutException -- Time is over!");
        }

    }
    @Test
    public void Task_2_2(){ //Try to avoid NoAlertPresentException and Handle possible exception
        String url = "https://demoqa.com/alerts";
        driver.get(url);

            WebElement clickOnWithId = driver.findElement(By.id("timerAlertButton"));
            clickOnWithId.click();
            try{
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                alert.accept();
            }catch (NoAlertPresentException e){
                System.out.println("NoAlertPresentException -- Alert is not present");
            }
    }
    @Test
    public void Task_2_3(){ //Try to invoke StaleElementReferenceException
        String url = "https://demoqa.com/alerts";
        driver.get(url);
        try {
            WebElement clickOnWithId = driver.findElement(By.id("timerAlertButton"));
            driver.navigate().refresh();
            clickOnWithId.click();
        }catch(StaleElementReferenceException e){
            System.out.println("StaleElementReferenceException -- Page is refreshed ! ");
        }
    }


    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}