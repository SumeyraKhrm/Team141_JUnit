package day9_switchingWindows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_ReusableMethodsIleKontrolsuzWindowGecisi extends TestBase {


    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();

        // Birden fazla window acildiginda
        // WHD'leri ile islem yaptigimizda
        // test her calistiginda yeni WHD'leri olustugundan, hazir method olusturmak zor
        // ama gececegimiz window'un Url veya title'i sabit oldugundan
        // onlari kullanabiliriz



        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        // once yeni window'a gecelim

        ReusableMethods.windowaGec("https://the-internet.herokuapp.com/windows/new",driver);

        String expectedTitle = "New Window";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);


        //● ilk window'a geri donun
        ReusableMethods.windowaGec("https://the-internet.herokuapp.com/windows",driver);

        // ve sayfa başlığının “The Internet” olduğunu test edin
        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);




    }

}
