package day06_jUnit_assertions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyTesti {

     // https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
     //asagidaki testleri yapin
     //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin// titleTest
     //=> Sayfa başlığının “Rest” içermediğini(contains) test edin
     // logoTest => BestBuy logosunun görüntülendigini test edin
     // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

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








}
