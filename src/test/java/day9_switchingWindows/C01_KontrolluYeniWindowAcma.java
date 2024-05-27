package day9_switchingWindows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_KontrolluYeniWindowAcma extends TestBase {

    /*
        IKI SEY COK KOLAY

        1- yeni bir window olusturup driver'i o window'a gecirmek

           driver.switchTo().newWindow(istedigimizWindowTuru)

        2- Bir test sirasinda yeni window'lar actiysak
           kullandigimiz her window'un windowHandleDegerini kaydetti isek
           istenen window'a gecmek

           driver.switchTo().window(gecmekIstedigimizWindowunWHD)
     */

    @Test
    public void test01(){

        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        String toWHD = driver.getWindowHandle();

        // phone icin arama yapip,
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);


        //urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));
        Assertions.assertTrue(bulunanUrunElementleriList.size()>0);
        ReusableMethods.bekle(2);
        System.out.println("switchTo().newWindow kullanmadan once driver'in Url : " + driver.getCurrentUrl());


        // yeni bir tab'da youtube'a gidin

        // ister tab ister ayri bir window acmak istedigimizde
        // Selenium 4 ile gelen switchTo().newWindow() method'u KULLAILMALIDIR

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com");
        String youtubeWHD = driver.getWindowHandle();
        System.out.println("switchTo().newWindow kullandiktan sonra driver'in Url : " + driver.getCurrentUrl());


        // COK ONEMLI : switchTo().newWindow() kullandigimizda
        //              yeni window'u driver'a olusturttugumuz icin
        //              driver OTOMATIK OLARAK yeni acilan WINDOW'a gecis yapar

        // url'in youtube icerdigini test edin
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

        ReusableMethods.bekle(3);

        // yeni bir window acip bestbuy'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        String bestbuyWHD = driver.getWindowHandle();
        driver.get("https://www.bestbuy.com");

        // title'in Best icerdigini test edin
        String expectedTitleIcerik = "Best";
        String actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // youtube'un acik oldugu window'a geri donun
        // ve title'in YouTube icerdigini test edin

        // EGER testimiz sirasinda birden fazla window acildi
        // ve bu window'lar arasinda gecis yapilmasi gerekiyorsa
        // kullandigimiz her window'un WindowHandle degerlerini kaydetmeli
        // ve ihtiyac duyuldugunda bu WindowHandle degerleri ile o window'a gecis yapmaliyiz

        //bu satir itibariyle driver bestbuy'in acik oldugu window'da duruyor  !!!
        System.out.println("to WHD : " + toWHD);
        System.out.println("youtube WHD : " + youtubeWHD);
        System.out.println("bestbuy WHD : " + bestbuyWHD);

        System.out.println("acilan 3 window'un WHD'leri : " +driver.getWindowHandles());
        ReusableMethods.bekle(2);


        // youtube'un acik oldugu window'a geri donun
        // ve title'in YouTube icerdigini test edin
        driver.switchTo().window(youtubeWHD);   //window diyerek geçiş yapmıs olduk

        expectedTitleIcerik = "YouTube";
        actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // testotomasyonu'nun acik oldugu window'a geri donun
        // ve title'in "Test Otomasyonu" icerdigini test edin

        ReusableMethods.bekle(2);
        driver.switchTo().window(toWHD);
        expectedTitleIcerik = "Test Otomasyonu";
        actualTitle = driver.getTitle();

        Assertions.assertTrue(actualTitle.contains(expectedTitleIcerik));

        ReusableMethods.bekle(3);






    }



}
