package day05_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_JUnitIlkTest {

     /*
        - @Test notasyonu siradan bir method'u bagimsiz olarak calistirilabilen
          bir test method'una donusturur

        - JUnit bir class'da birden fazla test method'u oldugunda
          hangisinin once calistirilacagina kendisi karar verir
          biz bu konuda bir ongoruye sahip olamayiz !! ve siralamayi belirleyemeyiz
          (eger method isimleri test01, test02,test03... gibi yazilirsa, bu siralamaya uyar)

        - ikinci bir yol olarak
          class deklarasyonunun ustunde : @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
          her @Test method'unda ise @Order(1) kullanarak
          istedigimiz siralamada calistirabiliriz
     */



    @Test
    public void test01() throws InterruptedException {

        // ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");
        // anasayfaya gittiginizi test edin
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        } else System.out.println("Youtube testi FAILED");
        // sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();

    }


    @Test
    public void test02() throws InterruptedException {

        // ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");
        // anasayfaya gittiginizi test edin
        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        } else System.out.println("Wisequarter testi FAILED");

        // sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();
    }


    @Test
    public void test03() throws InterruptedException {

        // ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");


        // anasayfaya gittiginizi test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrlIcerik =driver.getCurrentUrl();

        if(actualUrlIcerik.contains(expectedUrlIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

        // sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();

    }

}
