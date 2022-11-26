package Deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class Test01 {

    @Test
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.trendyol.com/");

        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        WebElement searchBox = driver.findElement(By.xpath("//input[@data-testid='suggestion']"));
        searchBox.sendKeys("Nutella");

        driver.findElement(By.xpath("//i[@class='ft51BU2r']")).click();

        driver.findElement(By.xpath("//button[@class='add-to-basket-button']")).click();
        Thread.sleep(2500);

        driver.findElement(By.xpath("//p[text()='Sepetim']")).click();

        driver.findElement(By.xpath("//span[text()='Sepeti Onayla']")).click();

        //Display Login Screen
        WebElement loginScreen = driver.findElement(By.xpath("//h3[text()='Trendyol’a giriş yap veya hesap oluştur, indirimleri kaçırma!']"));
        Assert.assertTrue(loginScreen.isDisplayed());
        Thread.sleep(1000);

        //Action Class
        WebElement loginInput = driver.findElement(By.xpath("//input[@id='login-email']"));
        Actions actions = new Actions(driver);
        actions.click(loginInput)
                .sendKeys("tilejaj719@turuma.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Asd123.")
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(1000);

        //Choose svg
        driver.findElement(By.xpath("//*[name()='svg']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@class='on-boarding-turn-address-selection']")).click();

        driver.findElement(By.xpath("//img[@src ='https://cdn.dsmcdn.com/web/master/ty-web.svg']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//i[@class='i-trash']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//button[text()='Sil']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//i[@class='i-close']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//button[text()='Sil']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//img[@src='https://cdn.dsmcdn.com/web/logo/ty-web.svg']")).click();
        Thread.sleep(500);

        String expectedUrl = "https://www.trendyol.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        driver.close();
    }
}
