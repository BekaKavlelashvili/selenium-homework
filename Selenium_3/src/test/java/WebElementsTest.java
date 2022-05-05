import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebElementsTest {
    public WebDriver driver;
    @BeforeTest
    public  void afterTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public  void Task_1()
    {
        String url = "http://the-internet.herokuapp.com/add_remove_elements/";
        driver.get(url);

        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        for (int i = 0; i <= 2; i++){
            element.click();
        }

        String  deleteButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button[3]")).getText();
        System.out.println(deleteButton);

        List<WebElement> elementList = driver.findElements(By.cssSelector("button[class^='added']"));
        for (int i = elementList.size()-1; i >= 0; i--)
        {
            System.out.println(elementList.get(i).getText());
            break;
        }

        WebElement lastDeleteButton_RelativePath = driver.findElement(By.xpath("//*[contains(@class,'manually') and text()='Delete']"));
        System.out.println(lastDeleteButton_RelativePath.getText());
    }

    @Test
    public void Task_2(){
        String url = "http://the-internet.herokuapp.com/challenging_dom";
        driver.get(url);

        String element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[10]//child::td[1]")).getText();
        System.out.println(element);

        String element1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[10]/td[2]//following-sibling::td")).getText();
        System.out.println(element1);
    }

    @AfterTest
    public  void afteTest(){
        driver.quit();
    }
}
