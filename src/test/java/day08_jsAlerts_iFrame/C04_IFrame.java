package day08_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_IFrame extends TestBase {

    @Test
    public void test01(){
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2 ) Bir metod olusturun: iframeTest
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.

        WebElement anIframeYaziElementi = driver.findElement(By.tagName("h3"));

        Assertions.assertTrue(anIframeYaziElementi.isDisplayed());

        System.out.println(anIframeYaziElementi.getText());

        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("//div[@aria-label='Close']"))
                .click();
        ReusableMethods.bekle(1);


        //	- Text Box’a “Merhaba Dunya!” yazin.
        // Textbox'in iframe icinde oldugunu gorduk

        WebElement iFrameElementi = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
        // oncelikle o iframe'e gecis yapalim
        driver.switchTo().frame(iFrameElementi);
        ReusableMethods.bekle(2);

        // *** web sayfasi textbox'a yazmaya izin vermediginden IPTAL


        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");


        //	- TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin
        //    ve  yazisini konsolda yazdirin.

        ReusableMethods.bekle(3);


    }
}

