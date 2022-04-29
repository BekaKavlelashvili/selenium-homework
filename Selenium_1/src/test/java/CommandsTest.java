import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class CommandsTest {
    @Test
    public void Open(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "http://the-internet.herokuapp.com/dynamic_controls";
        driver.get(url);

    }

    @Test
    public void ClickMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "http://the-internet.herokuapp.com/dynamic_controls";
        driver.get(url);
        WebElement element = driver.findElement(By.id("input-example"));
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        actions.contextClick().perform();
    }

    @Test
    public void IsEnabledAndCheckinButtonText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "http://the-internet.herokuapp.com/dynamic_controls";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement inputField = driver.findElement(By.id("input-example"));
        WebElement button = driver.findElement(By.id("input-example"));
        WebElement message = driver.findElement(By.id("input-example"));
        String text = button.getText();
        if(!inputField.isEnabled() && !text.contains("Enable") && !message.isDisplayed()){
            System.out.println("Input field is Disabled; return " + inputField.isEnabled() + "." + "Button inner text is not changed" +
                    "  Message is not displayed" );

        }else{
            System.out.println("Input field is enabled; return " + inputField.isEnabled() + "." + " Button inner text is changed. " +
                    " Message is displayed");
        }
        driver.close();
    }

    @Test
    public void YCoordinatesIsSame() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = " http://the-internet.herokuapp.com/drag_and_drop";
        driver.get(url);
        driver.manage().window().maximize();

        int box_a = driver.findElement(By.id("columns")).getLocation().getY();
        int box_b = driver.findElement(By.id("columns")).getLocation().getY();

        if(box_a == box_b){
            System.out.println("Columns Y coordinates are same");
        }else{
            System.out.println("Columns Y coordinates are different");
        }
        driver.close();
    }
}
