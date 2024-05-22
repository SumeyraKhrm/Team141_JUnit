package day07_dropdownMenuKullanimi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C02_BeforeAfterMethodlarininOnemi {


     // driver olusturma ve driver'i kapama islemlerinin
     // @Test method'unun icinde mi olmasi daha iyidir
     // yoksa @Before... ve @After... ile yapilmasi mi daha iyidir  ?

    /*

    @Test
    public void aramaTesti(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("java" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.className("prod-img"));

        Assertions.assertTrue(bulunanUrunElementleriList.size()>0);
        // bu satırda hata verdiği için browser kapanmadı bu birden fazla test case oldugu durumlarda sıkıntı olur


        driver.quit();
    }

     */

    WebDriver driver;
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void aramaTesti(){
        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("java" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        List<WebElement> bulunanUrunElementleriList =
                driver.findElements(By.className("prod-img"));

        Assertions.assertTrue(bulunanUrunElementleriList.size()>0);


        ReusableMethods.bekle(3);
        // her seferinde thread koymamık için method ile cagırıyoruz

    }

}



