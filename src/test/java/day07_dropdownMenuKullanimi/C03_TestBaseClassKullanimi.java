package day07_dropdownMenuKullanimi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_TestBaseClassKullanimi extends TestBase {

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
