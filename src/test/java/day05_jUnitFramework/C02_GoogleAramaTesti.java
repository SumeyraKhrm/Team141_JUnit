package day05_jUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_GoogleAramaTesti {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        //eger sirket sana driver vermezse ve selenium kullan derse buna gerek yok
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");


        //3- cookies uyarisini kabul ederek kapatin
        // otomasyanda her seferinde kopya broowser olustugu ıcın tekrardan onay ıster
        driver.findElement(By.xpath("//*[text()='Tümünü kabul et']"))
                .click();


        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin

        String expectedtitleicerik = "Google";
        String actualtitleicerik = driver.getTitle();

        if(actualtitleicerik.contains(expectedtitleicerik)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");


        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@name='q']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);


        //6- Sayfayi kapatin

        Thread.sleep(5000);
        driver.quit();




    }
}
