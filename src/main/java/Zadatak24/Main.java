package Zadatak24;

//Napisati program koji na sajtu:
//http://automationpractice.com
//dodaje najmanje 3 proizvoda u cart, nastavlja do cart-a, izbacuje jedan proizvod, a drugom povecava kolicinu za 1.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\IdeaProjects\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        WebElement article1 = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[4]"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(article1).perform();

        WebElement article1AddToCart = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[4]/div/div[2]/div[2]/a[1]/span"));
        article1AddToCart.click();

        WebElement continueShopping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
        continueShopping.click();

        WebElement article2 = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(article2).perform();

        WebElement article2AddToCart = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[1]/span"));
        article2AddToCart.click();

        continueShopping.click();

        WebElement article3 = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div"));
        Actions action3 = new Actions(driver);
        action3.moveToElement(article3).perform();


        WebElement article3AddToCart = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]/span"));
        article3AddToCart.click();

        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
        proceedToCheckout.click();

        WebElement delete = driver.findElement(By.xpath("//*[@id=\"2_7_0_0\"]/i"));
        delete.click();

        WebElement addOneMore = driver.findElement(By.xpath("//*[@id=\"cart_quantity_up_3_13_0_0\"]/span"));
        addOneMore.click();
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
}
