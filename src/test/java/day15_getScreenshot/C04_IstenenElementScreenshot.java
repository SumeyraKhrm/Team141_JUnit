package day15_getScreenshot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_IstenenElementScreenshot extends TestBase {



    @Test
    public void test01() {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        // ve arama sonuc yazisinin fotografini cekin


        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assertions.assertNotEquals(unExpectedSonucYazisi,actualSonucYazisi);

        // Tum sayfa screenshot ile istenen webelement screenshot arasindaki tek fark
        // 1.adimda tss objesi olusturmak yerine,
        // fotograf cekmek istedigimiz webelementi locate etmemizdir



        ReusableMethods.webElementScreenshot(aramaSonucElementi);

        // ilk urune tiklayin


        // acilan sayfada urun isminde case sensitive olmadan phone bulundugunu test edin
        // ve urun isim yazisinin fotografini cekin



    }
    }
