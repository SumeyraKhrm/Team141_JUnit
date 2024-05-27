package day10_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_SwitchingWindows extends TestBase {



    @Test
    public void test01(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");


        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        // yazi bir iFrame'in icinde oldugundan once iFrame'e gecis yapmaliyiz
        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframe);
        WebElement electronicsProductsElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assertions.assertTrue(electronicsProductsElementi.isDisplayed());


        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        String expectedIsim ="DELL Core I3 11th Gen";
        String actualUrunIsmi= driver.findElement(By.xpath("//*[@id='pictext1']"))
                .getText();
        Assertions.assertEquals(expectedIsim,actualUrunIsmi);

        //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.
        driver.findElement(By.xpath("//*[@id='pictext1']")).click();

        // urunu click yaptigimizda bizim kontrolumuz disinda
        // yeni bir window'da urunun sayfasini aciyor
        // bu durumda once urunun acik oldugu window'a gecis yapmaliyiz
        ReusableMethods.windowaGec("https://testotomasyonu.com/product/58",driver);

        // artik istenen testi yapabiliriz
        // acilan sayfada urun fiyatinin $399.00 olduğunu test edin.
        String expectedFiyat = "$399.00";
        String actualFiyat = driver.findElement(By.id("priceproduct"))
                .getText();
        Assertions.assertEquals(expectedFiyat,actualFiyat);

        //5- Ilk sayfaya donun ve Fashion yazisinin gorunur olduğunu test edin

        // ilk window'a donmek icin hazir method'u kullandik
        ReusableMethods.windowaGec("https://testotomasyonu.com/discount",driver);

        // ilk window'da calisirken electronics iframe'i icine gecis yapmistik
        // once oradan anasayfaya cikalim
        driver.switchTo().defaultContent();

        // Fashion yazisini kullanabilmek icin once sagdaki iframe'e gecis yapalim
        WebElement fashionIFrame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIFrame);

        // Fashion yazisini locate edip testimizi yapabiliriz
        WebElement fashionYaziElementi= driver.findElement(By.xpath("//*[text()='Fashion']"));

        Assertions.assertTrue(fashionYaziElementi.isDisplayed());


        //6- Sayfayi kapatin
        ReusableMethods.bekle(3);







    }

    }
