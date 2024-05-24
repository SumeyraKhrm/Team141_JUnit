package day9_switchingWindows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C02_KontrolsuzAcilanYeniWindowaGecis extends TestBase {

    //yeni bir sayfa mı acılıyor tıklamamızda yoksa yeni bir window mu?
    //yeni sayfa aynı sayfamızı korur, window a geçmeye gerek yok ozmn


    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWHD = driver.getWindowHandle();

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedYazi = "Opening a new window";
        String actualyazi =driver.findElement(By.tagName("h3"))
                .getText();

        Assertions.assertEquals(expectedYazi,actualyazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        System.out.println("click yapmadan once driver whd : " + driver.getWindowHandle());
        System.out.println("click yapmadan acik olan tum window'larin WHD'leri : " + driver.getWindowHandles());

        //● Click Here butonuna basın.

        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();
        // bu linki tikladigimizda KONTROLSUZ yeni bir window aciliyor
        // driver, kontrolsuz acilan window'u BILMEZ ve otomatik olarak ILK WINDOW'da kalir
        // testimiz icin driver'i yeni window'a gecirmemiz gerekiyorsa
        // bunu BIZ YAPMALIYIZ
        // driver.switchTo().window(yeniAcilanWindowWHD)


        System.out.println("=====================================");
        System.out.println("click yaptiktan sonra driver whd : " + driver.getWindowHandle());
        System.out.println("click yaptiktan sonra olan tum window'larin WHD'leri : " + driver.getWindowHandles());

         /*
            Kontrolsuz acilan bir window varsa
            acilan kontrolsuz window'un WHD'ini bulmaliyiz

            1- click yapmadan ilk window'un WHD'ini kaydettik (ornegin A1.....)

            2- click yaptiktan sonra elimizde 2 window ve 2 WHD olacak
               2 WHD'ini bir Set olarak kaydedelim
               (ornegin  A1......., 83......)

            3- Bu set'deki WHD'lerinden ilk sayfanin WHD esit olmayani
               ikinciSayfaWHD olarak kaydedelim

            4- artik ikinci window'un WHD'ini biliyoruz
              o zaman driver.switchTo().window(ikinciSayfaWHD) ile
              ikinci window'a gecis yapabiliriz

         */

        Set<String> ikiSayfaninWHDleri = driver.getWindowHandles();

        String ikinciWindowWHD ="";

        for (String eachWHD : ikiSayfaninWHDleri
        ) {
            if ( !  eachWHD.equals(ilkSayfaWHD) ){
                ikinciWindowWHD = eachWHD;
            }

        }
        driver.switchTo().window(ikinciWindowWHD);



        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);



        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedText = "New Window";
        String actualText = driver.findElement(By.tagName("h3"))
                .getText();

        Assertions.assertEquals(expectedText,actualText);


        //● ilk acilan window'a  geri dönup
        //  sayfa başlığının “The Internet” olduğunu test edin

        driver.switchTo().window(ilkSayfaWHD);

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        ReusableMethods.bekle(3);













    }
}
