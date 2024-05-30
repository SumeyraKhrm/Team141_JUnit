package day15_getScreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_GetScreenshot  extends TestBase {


    //failed sonuclanan test caseleri için bug açtıgımızda screenshot fotolarını da koyabiliriz.


    @Test
    public void aramaTesti() throws IOException {

        // testotomasyon anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // Java icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("java" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();



        // Screenshot almak icin 4 adim atariz
        ReusableMethods.bekle(1);     //bekleme suresi koyuyoruz ki "0 product" görünsün !!
        // 1.adim TakeScreenshot objesi olusturalim
        TakesScreenshot tss =(TakesScreenshot) driver;

        // 2.adim cektigimiz screenshot'i kaydedecegimiz dosyayi olusturalim
        //   dosya uzantisi jpg, jpeg, png olabilir
        //   dosya yeri  target/screenshots olsun

        File tumSayfaScreenshot = new File("target/screenshots/ekranResmi.png");


        // 3.adim sayfa fotografini cekip gecici bir dosyaya yukleyelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil olusturdugumuz dosyaya kopyalayalim

        FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);

        Assertions.assertNotEquals(unExpectedSonucYazisi,actualSonucYazisi);




    }
}
