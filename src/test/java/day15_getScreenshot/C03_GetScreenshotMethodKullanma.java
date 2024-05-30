package day15_getScreenshot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_GetScreenshotMethodKullanma extends TestBase {


    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        // ve fotografini cekin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assertions.assertNotEquals(unExpectedSonucYazisi,actualSonucYazisi);

        ReusableMethods.bekle(1);
        ReusableMethods.tumSayfaScreenshot(driver);
        ReusableMethods.tumSayfaScreenshot(driver,"arama_sonuc_ekrani");


        // ilk urune tiklayin

        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // acilan sayfada urun isminde case sensitive olmadan phone bulundugunu test edin
        // ve fotografini cekin

        String expectedUrunIsimIcerigi = "phone";

        WebElement urunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
        String actualUrunIsmiKucukHarf = urunIsimElementi.getText()
                .toLowerCase();

        Assertions.assertTrue(actualUrunIsmiKucukHarf.contains(expectedUrunIsimIcerigi));
        ReusableMethods.bekle(1);
        ReusableMethods.tumSayfaScreenshot(driver);
        ReusableMethods.tumSayfaScreenshot(driver, "ilk_urun_resmi");




    }
}
