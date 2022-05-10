import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

public class WebTablesTest {
    public WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://techcanvass.com/Examples/webtable.html";
        driver.get(url);
    }

    @Test
    public void Task1(){
        String car = "Honda";
        List<WebElement> allRows = driver.findElements(By.xpath("//*[@id=\"t01\"]/tbody/tr"));
        for(int i=2;i<=allRows.size();i++)
        {
            WebElement carCol=driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody/tr["+i+"]/td[1]"));
            if(carCol.getText().toLowerCase().equalsIgnoreCase(car))
            {
                WebElement carPrice=driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody/tr["+i+"]/td[3]"));
                System.out.println(car +"'s price is " +carPrice.getText());
            }
        }
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
