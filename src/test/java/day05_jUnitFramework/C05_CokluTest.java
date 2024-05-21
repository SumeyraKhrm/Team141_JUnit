package day05_jUnitFramework;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_CokluTest {

    //Bir test method'unu gecici olarak kullanim disina almak icin @Disabled kullanilabilir !!



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

    //Bir test method'unu gecici olarak kullanim disina almak icin @Disabled kullanilabilir

    @Test @Disabled
    public void test01() throws InterruptedException {

        // ayarlari yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // youtube anasayfaya gidin
        driver.get("https://www.google.com");
        // anasayfaya gittiginizi test edin
        String expectedUrlIcerik = "google";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("google testi PASSED");
        } else System.out.println("google testi FAILED");
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
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

        // sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();
    }


}
