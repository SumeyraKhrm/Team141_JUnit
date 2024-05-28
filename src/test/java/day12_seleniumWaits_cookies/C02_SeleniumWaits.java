package day12_seleniumWaits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_SeleniumWaits {


    @Test
    public void implicitlyWaitTesti(){
        //WebDriver'i bu method'da olusturup, ayarlarini yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']"))
                .click();

        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement sonucMesajElementi = driver.findElement(By.xpath("//*[@id='message']"));

        String expectedSonucYazisi = "It's gone!";
        String actualSonucYazisi = sonucMesajElementi.getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);

        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']"))
                .click();

        //5. It’s back mesajinin gorundugunu test edin

        expectedSonucYazisi = "It's back!";
        sonucMesajElementi = driver.findElement(By.xpath("//*[@id='message']"));
        actualSonucYazisi = sonucMesajElementi.getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);

        driver.quit();

    }


    @Test
    public void explicitlyWaitTesti(){

        //WebDriver'i bu method'da olusturup, ayarlarini yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']"))
                .click();
        //3. “It’s gone!” mesajinin goruntulendigini dogrulayin.


        // 1.adim : mumkunse beklemek istedigimiz it's gone elementini locate edin
        // 2.adim : WebDriverWait objesi olusturun
        // 3.adim : wait objesi ve expectedConditions ile bekleme islemini yap

        // EGER beklemek istedigimiz elementi locate etmemiz mumkun degilse
        //      onu locate etmek icin beklemek gerekiyorsa 1. ve 3.adimi birlestirebiliriz

        // 2.adim
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        // 1.(locate) ve 3.adim(bekleme) birlikte yazacagiz
        WebElement itsGoneElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        //its gone yazısı görünür oluncaya kadar..

        Assertions.assertTrue(itsGoneElementi.isDisplayed());

        //4. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']"))
                .click();

        //5. It’s back mesajinin gorundugunu test edin

        WebElement itsBackElementi =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        Assertions.assertTrue(itsBackElementi.isDisplayed());

        driver.quit();





    }
}
