package day10_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class C02_ActionsClass extends TestBase {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        //2- “DGI Drones” uzerinde sag click yapin

        // 1.adim actions objesi olusturma
        Actions actions = new Actions(driver);

        // 2.adim actions ile kullanacagimiz webElement'i locate etme
        WebElement dgiDronesElementi = driver.findElement(By.id("pic2_thumb"));
        ReusableMethods.bekle(1);   //bu adım önemli

        // 3.adim actions objesi ile baslayip,
        //        istenen webelement uzerinde istenen eylemi yapalim
        //        en sonda perform() diyelim

        actions.contextClick(dgiDronesElementi).perform();

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazisi = driver.switchTo().alert().getText();


        Assertions.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //4- Tamam diyerek alert’i kapatalim
        ReusableMethods.bekle(1);
        driver.switchTo().alert()
                .accept();











        ReusableMethods.bekle(3);


    }
}
