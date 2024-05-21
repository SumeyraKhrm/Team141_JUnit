package day06_jUnit_assertions;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyTesti {

     // https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
     //asagidaki testleri yapin
     //Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
     //titleTest=> Sayfa başlığının “Rest” içermediğini(contains) test edin
     //logoTest => BestBuy logosunun görüntülendigini test edin
     //FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver ;

    @BeforeAll  // Hic bir @Test method'u calismadan en basta sadece 1 kere calisir
    public static void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll // Tum @Test method'lari calisip bittikten sonra en sonda sadece 1 kere calisir
    public static void teardown(){
        driver.quit();
    }


    @Test @Order(1)
    // https://www.bestbuy.com/ Adresine gidin ve sayfanın bu URL'e esit oldugunu test edin
    public void anasayfaTesti() throws InterruptedException {
        driver.get(" https://www.bestbuy.com/");

        String expectedUrl ="https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl,actualUrl);
    }

    //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

    @Test @Order(2)
    public void titleTest(){

        String expectedTitleIcerik = "Rest";
        String actualTitle = driver.getTitle();

        Assertions.assertFalse(actualTitle.contains(expectedTitleIcerik));
    }



    //	○ logoTest => BestBuy logosunun görüntülendigini test edin
    @Test @Order(3)
    public void logoTest(){

        WebElement logoElementi = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assertions.assertTrue(logoElementi.isDisplayed());
    }


    @Test @Order(4)
    //	○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    public void FrancaisLinkTest(){

        WebElement francaisLinkElementi = driver.findElement(By.xpath("//*[text()='Français']"));

        Assertions.assertTrue(francaisLinkElementi.isDisplayed());


         }


    }
