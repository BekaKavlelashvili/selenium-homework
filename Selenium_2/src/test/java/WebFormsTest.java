import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class WebFormsTest {
    public WebDriver driver;

    @BeforeTest
    public  void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void SelectLan(){
        WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/select[1]"));
        Select select = new Select(element);
        select.selectByValue("c#");
        WebElement options = select.getFirstSelectedOption();
        String getText = options.getText();
        System.out.println("Selected " + getText);
    }

    @Test
    public void SelectAllInCheckbox() {
        List<WebElement> checkboxes = driver.findElements(By.xpath("/html/body/div/div[3]/div/div"));
        for(int i = 0; i < checkboxes.size(); i++) {
            if(!checkboxes.get(i).isSelected()){
                checkboxes.get(i).click();
            }
        }
    }

    @Test
    public void ChooseYellow(){
        List<WebElement> element = driver.findElements(By.name("color"));
        for(int i = 0; i < element.size(); i++) {
           String value = element.get(i).getAttribute("value");
           if(value.contains("yellow")){
               element.get(i).click();
               System.out.println("Selected " + value);
               break;
           }
        }
    }
    @Test
    public void CheckDisable(){
        WebElement all = driver.findElement(By.id("fruit-selects"));
        List<WebElement> elements = all.findElements(By.xpath("//*[@id=\"fruit-selects\"]/option[2]"));
            for(WebElement x : elements){
                if(!x.isEnabled()) {
                    System.out.println(x.getText() + " is disable");
                }
            }
    }
    @AfterTest
    public void Quit(){
        driver.quit();
    }
}
