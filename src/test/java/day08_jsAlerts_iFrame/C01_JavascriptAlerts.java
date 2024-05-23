package day08_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_JavascriptAlerts extends TestBase {

     /*
        Biz bir butona bastigimizda
        websayfasinda bir uyari yazisi (alert) cikabilir

        EGER cikan alert uzerindeki butonlari locate edebiliyorsak
        olusan alert bir HTML ALERT'dur ve (alört)
        diger tum webelement'ler gibi locate edip kullanilabilir

        ANCAK alert JS ile olusturulmussa
        alert uzerindeki yazilar ve butonlar locate edilemez
        dolayisiyla biz alert'i diger webelementler gibi kapatamayiz veya kullanamayiz

        Selenium webdriver'i js alert'e gecirebilmemiz icin ozel bir method olusturmustur
        driver.switchTo().alert()....
     */

    //3 test method'u olusturup asagidaki gorevi tamamlayin

    @Test
    public void test01(){
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");
        ReusableMethods.bekle(3);

        /*
        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
                .click();

        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        String expectedAlertYazısı = "I am a JS Alert";
        String actualAlertYazısı   = driver.switchTo().alert().getText();

        Assertions.assertTrue(expectedAlertYazısı.contains(actualAlertYazısı));

        Assertions.assertEquals(expectedAlertYazısı,actualAlertYazısı);

        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();


         */
         }


    @Test
    public void test02(){
        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 2.alert'e tiklayalim

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"))
                .click();

        //	- Cancel'a basip,
        driver.switchTo().alert().dismiss();


        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@id='result']"));

        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);


    }

    @Test
    public void test03(){
        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");


        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"))
                .click();


        //	- Cikan prompt ekranina "Bugra" yazdiralim
        driver.switchTo().alert().sendKeys("Bugra");
        ReusableMethods.bekle(3);

        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();


        //	- Cikan sonuc yazisinin Bugra icerdigini test edelim

        String expectedSonucYaziIcerigi = "Bugra";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@id='result']"));
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assertions.assertTrue(actualSonucYazisi.contains(expectedSonucYaziIcerigi));


         }

    }
