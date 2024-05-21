package day05_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_DisardanWebDriverKullanma {
    public static void main(String[] args) throws InterruptedException {


        //WebDriverManager.firefoxdriver().setup();

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");


        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerık = "testotomasyon";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedUrlIcerık)){
            System.out.println("Url test PASSED");}
        else System.out.println("Url test FAILED");


        // sayfayi kapatin
        Thread.sleep(2000);
        driver.quit();


    }
}
