import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SwitchToTest {
    public WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Task_1(){
        String url = "http://the-internet.herokuapp.com/iframe ";
        driver.get(url);

        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
        element.click();
        element.clear();
        element.sendKeys("Here Goes");

        driver.switchTo().defaultContent();
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[2]/div/div[4]/button[2]/span"));
        element1.click();

    }

    @Test
    public void Task_2(){
        String url = "https://demoqa.com/alerts";
        driver.get(url);

        WebElement element = driver.findElement(By.xpath("//*[@id=\"alertButton\"]"));
        element.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }


}
