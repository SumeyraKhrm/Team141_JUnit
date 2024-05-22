package day07_dropdownMenuKullanimi;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {


    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //	a. Verilen web sayfasına gidin.
    //  https://testotomasyonu.com/form
    //	b. Cinsiyet Radio button elementlerini locate edin
    //	c. Iki farkli test method’u oluşturup yazidan veya direk buton’dan size uygun olani secin
    //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin


    //CheckBox coklu secimlerin oldugu
    //Radio Button sadece bir secim yapıldıgı

    static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void yazidanSecimTesti() throws InterruptedException {
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        //	b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadınRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));


        //	c.  yazidan size uygun olan radio butonu secin
        driver.findElement(By.xpath("//*[@for='inlineRadio2']"))
                .click();

        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assertions.assertTrue(erkekRadioButton.isSelected());

        // kadin radio butonun secili olmadigini test edin
        Assertions.assertFalse(kadınRadioButton.isSelected());

        // diger radio butonun secili olmadigini test edin
        Assertions.assertFalse(digerRadioButton.isSelected());

    }


    @Test
    public void butondanSecimTesti() throws InterruptedException {
        //	a. Verilen web sayfasına gidin.
        //	      https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");

        //	b. Cinsiyet Radio button elementlerini locate edin
        WebElement kadinRadioButon = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButon = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButon = driver.findElement(By.id("inlineRadio3"));

        //	c.  direk buton’dan size uygun olani secin
        erkekRadioButon.click();

        //	d. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin

        // erkek radio butonun secili oldugunu test edin
        Assertions.assertTrue(erkekRadioButon.isSelected());

        // kadin radio butonun secili olmadigini test edin
        Assertions.assertFalse(kadinRadioButon.isSelected());

        // diger radio butonun secili olmadigini test edin
        Assertions.assertFalse(digerRadioButon.isSelected());
    }


}

