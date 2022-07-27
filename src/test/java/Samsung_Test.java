import amazon.factories.DriverFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Samsung_Test {

     WebDriver driver = DriverFactory.getDriver();

    @Test
    public void step1(){




        driver.get("https://www.amazon.in/");

        WebElement hamburger_menu = driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]/i"));
        hamburger_menu.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a/div")));

         driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a/div")).click();

         WebElement televisions = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[9]/li[3]/a"));
         televisions.click();


        JavascriptExecutor js = (JavascriptExecutor) driver;

        //a.  750 pixels down 10 times.
        for (int i = 0; i <14 ; i++) {

            js.executeScript("window.scrollBy(0,750)");
        }


         driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[21]/ul/li[4]/span/a/span")).click();

        WebElement sortBy = driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]"));

        sortBy.click();

        WebElement highToLow = driver.findElement(By.xpath("//*[@id=\"s-result-sort-select_2\"]"));

        highToLow.click();

        WebElement secondPrice = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div[1]/span/a/div/img"));

        secondPrice.click();

      Set<String> secondWindow = driver.getWindowHandles();

        for (String each : secondWindow) {
            driver.switchTo().window(each);
        }


       WebElement aboutItem = driver.findElement(By.xpath("//*[@id=\"feature-bullets\"]/h1"));

        Assertions.assertTrue(aboutItem.isDisplayed());




    }



}
