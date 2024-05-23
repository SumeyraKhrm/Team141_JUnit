package day08_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_IFrame extends TestBase {

    @Test
    public void iFrameTest(){

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");


        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        // Electronics Products yazisinin bir iframe icinde oldugunu gorduk
        // o yaziya ulasabilmek icin 3 adim atmamiz gerekir
        // ilk adim : Electronics Products'in icinde oldugu iFrame'i locate edelim

        WebElement electronicsIframe = driver.findElement(By.xpath("(//iframe)[1]"));

        // ikinci adim : locate ettigimiz iFrame'e gecis yapalim

        driver.switchTo().frame(electronicsIframe);

        // ucuncu adim : artik bu iframe icindeki elementleri kullanabilirsiniz
        // ONEMLI : bir iFrame'e gecis yapinca, siz oradan cikmadikca
        //          driver o iFrame'in icinde kalacaktir

        ReusableMethods.bekle(3);


        WebElement electronicsyaziElementi = driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assertions.assertTrue(electronicsyaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin

        String expectedUrunismi = "DELL Core I3 11th Gen";

        String actualUrunIsmi = driver
                .findElement(By.xpath("//*[text()='DELL Core I3 11th Gen ']"))
                .getText();

        Assertions.assertEquals(expectedUrunismi,actualUrunIsmi);

        //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin
        // biz soldaki iFrame'in icinde oldugumuzdan
        // sagdaki iFrame'e gecmek icin ONCE soldakinden cikmaliyiz

        //driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();


        // sagdaki iFrame'e gecis yapmak icin 3 adim atmaliyiz
        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframe);

        // artik sagdaki iframe'in icindeyiz
        // istedigimiz locate'leri yapabiliriz


        // iframe icindeki tum urunleri bir liste olarak locate ettik
        List<WebElement> urunIsimElement = driver.findElements(By.tagName("p"));

        System.out.println("bulunan urun sayisi : " + urunIsimElement.size());

        // listedeki tum urun isimlerini tek tek ele alip
        // ‘Men Slim Fit’ iceren var mi kontrol edelim

        boolean menSlimFitVarMi = false;

        for (WebElement eachUrunIsimElementi : urunIsimElement
        ) {

            if (eachUrunIsimElementi.getText().contains("Men Slim Fit")){
                menSlimFitVarMi = true;
            }
        }

        Assertions.assertTrue(menSlimFitVarMi);


        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin

        WebElement fashionYaziElementi = driver.findElement(By.xpath("//*[text()='Fashion']"));
        Assertions.assertTrue(fashionYaziElementi.isDisplayed());

        //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin

        // sagdaki iframe'in icinde oldugumuzdan
        // here are... yazisini locate edebilmek ve kullanabilmek icin
        // oncelikle sagdaki iframe'den anasayfaya cikmaliyiz


        //driver.switchTo().defaultContent(); // nerede oldugu onemli degil, direk anasayfaya gecis yapar
        driver.switchTo().parentFrame(); // ic ice birden fazla iframe katmani varsa
        // bu komut bizi bir ust katmana cikartir
        // yaptigimiz ornek icin bu iki method'un farki YOK

        WebElement hereAreYaziElemnti = driver.findElement(By.xpath("//*[text()='Here are some products.']"));
        Assertions.assertTrue(hereAreYaziElemnti.isDisplayed());

        ReusableMethods.bekle(3);


    }
}
