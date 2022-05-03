import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsTest {

    public  WebDriver driver;

    @BeforeTest
    public  void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://demoqa.com/progress-bar";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public  void Task_1() throws InterruptedException {

        WebElement startButton  = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/button"));
        startButton.click();
        WebElement progressBur = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(progressBur, "100%"));
        System.out.println("100%");
    }

    @AfterTest
    public  void Quit(){
        driver.quit();
    }
}
