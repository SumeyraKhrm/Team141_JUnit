package day11_fakerClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_FileUploadTesti extends TestBase {



    @Test
    public void test(){

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        ReusableMethods.bekle(1);

        //chooseFile butonuna basalim
        //upload.png dosyasini secelim.

        /*
            chooseFile butonuna bastigimizda,
            bilgisayarimizdaki dosyalar acilir
            driver'in bilgisayarimizdaki dosyalara erisimi YOKTUR

            bunun yerine
            selenium kullanarak dosya secimi yapmak istedigimizde
            chooseFile butonunu locate edip
            yukleyecegimiz dosyanin dosyaYolunu sendKeys() ile yollariz
         */

        String yuklenecekDosyaYolu = "/Users/erolkahraman/IdeaProjects/Team141_JUnit/src/test/java/day11_fakerClass_fileTestleri/selenium-snapshot.png";

        WebElement chooseFileButtonu = driver.findElement(By.id("file-upload"));

        chooseFileButtonu.sendKeys(yuklenecekDosyaYolu);
        ReusableMethods.bekle(5);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit"))
                .click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        String expectedYazi = "File Uploaded!";
        String actualYazi = driver.findElement(By.tagName("h3")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(2);


    }
}
