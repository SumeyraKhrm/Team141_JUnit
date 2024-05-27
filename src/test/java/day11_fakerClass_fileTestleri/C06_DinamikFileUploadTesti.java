package day11_fakerClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_DinamikFileUploadTesti extends TestBase {


    @Test
    public void test01(){

        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile butonuna basalim
        //3.day12 altindaki upload.png dosyasini dinamik olarak secelim.

        String yuklenecekDosyaninDosyaYolu = System.getProperty("user.dir") +
                "/src/test/java/day11_fakerClass_fileTestleri/selenium-snapshot.png";

        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));
        chooseFileButonu.sendKeys(yuklenecekDosyaninDosyaYolu);

        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();


        //“File Uploaded!” textinin goruntulendigini test edelim.
        String expectedYazi = "File Uploaded!";
        String actualYazi = driver.findElement(By.tagName("h3")).getText();
        Assertions.assertEquals(expectedYazi,actualYazi);



        System.out.println( "user.dir ===>> " + System.getProperty("user.dir"));



    }
}
