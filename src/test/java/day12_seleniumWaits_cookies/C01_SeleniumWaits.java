package day12_seleniumWaits_cookies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_SeleniumWaits {

   //explicitlyWait daha çok tercih edilir thread.sleep e gore !!

    @Test
    public void implicitlyWaitTesti(){
        //WebDriver'i bu method'da olusturup, ayarlarini yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());

        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();

        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        ReusableMethods.bekle(3); //Thread.sleep gerekli buraya yoksa beklemiyor

        Assertions.assertTrue(textBox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        String expectedSonucYazisi = "It's enabled!";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='message']"))
                .getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);

        driver.quit();

    }


    @Test
    public void explicitlyWaitTesti(){
        //WebDriver'i bu method'da olusturup, ayarlarini yapin
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
        Assertions.assertFalse(textBox.isEnabled());

        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();

        // beklemeyi explicitly wait ile yapalim

        // 1.adim : mumkunse bekleyecegimiz webelementi locate edin
        //          textBox gorunur oldugu icin locate ettik

        // 2.adim : bir wait objesi olusturun
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));

        // 3.adim : wait objesini kullanarak,
        //          istenen durum gerceklesinceye kadar driver'i bekletin
        //          biz textBox etkin oluncaya kadar beklemesini istiyoruz
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textBox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        String expectedSonucYazisi = "It's enabled!";
        String actualSonucYazisi = driver.findElement(By.xpath("//*[@id='message']"))
                .getText();
        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);

        driver.quit();

        }
    }
