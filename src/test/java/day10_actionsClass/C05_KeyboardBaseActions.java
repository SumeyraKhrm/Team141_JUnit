package day10_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_KeyboardBaseActions extends TestBase {


    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Arama kutusuna actions method’larini kullanarak
        //   “DELL Core I3” yazdirin ve Enter’a basarak arama yaptirin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        // aramaKutusu.sendKeys("DELL Core I3");

        Actions actions = new Actions(driver);

        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT) // shift tusuna 2.emre kadar basili tutar
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT) // basili tuttugumuz shift'den elimizi kaldirir
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("ı")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .sendKeys(Keys.ENTER)
                .perform();

        //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin

        String expectedUrunIsimIcerigi = "DELL Core I3";
        String actualUrunIsmi = driver.findElement(By.xpath("//*[@class='prod-title mb-3 ']"))
                .getText();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerigi));

        ReusableMethods.bekle(3);




    }
}
