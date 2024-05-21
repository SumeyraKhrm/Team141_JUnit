package day06_jUnit_assertions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C05_CheckBox {


    //checkBoxTesti  birden fazla seçim hakkı oldugu durumlarda yapılır
    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }

    @Test
    public void checkBoxTesti() throws InterruptedException {
        //	a. Verilen web sayfasına gidin.
        //	     https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");


        //	b. Sirt Agrisi ve Carpinti checkbox’larini secin
        //     secme islemi hem yazidan hem kutudan yapilabildiginden testin daha efektif olmasi icin
        //     sirt agrisini kutudan, carpintiyi yazidan secelim


        Thread.sleep(3000);

        WebElement sirtAgrisiKutusu = driver.findElement(By.id("gridCheck5"));

        sirtAgrisiKutusu.sendKeys(Keys.PAGE_DOWN);  //sayfanın asagısına ınmesı icin
        sirtAgrisiKutusu.click();

        WebElement carpintiYaziElementi = driver.findElement(By.xpath("//*[@for='gridCheck4']"));
        carpintiYaziElementi.click();

        //	c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        //     carpintiyi yazidan sectik ama yazidan test yapamayiz
        WebElement carpintiKutusu = driver.findElement(By.id("gridCheck4"));

        // 1- sirt agrisi checkbox'in secili oldugunu test edin
        Assertions.assertTrue(sirtAgrisiKutusu.isSelected());
        // 2- carpinti checkbox'in secili oldugunu test edin
        Assertions.assertTrue(carpintiKutusu.isSelected());

        // seker ve epilepsi kutulari gorunmediginden driver objesi bu kutulari test EDEMEYEBILIR !!
        // bu durumda page down yapmak gerekir
        Thread.sleep(3000);


        //	d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        //Actions actions = new Actions(driver);
        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Thread.sleep(3000);

        WebElement sekerCheckbox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckbox = driver.findElement(By.id("hastalikCheck7"));


        //1-Seker checkbox’inin seçili olmadigini test edin

        Assertions.assertFalse(sekerCheckbox.isSelected());

        //2-Epilepsi checkbox’inin seçili olmadigini test edin

        Assertions.assertFalse(epilepsiCheckbox.isSelected());

        Thread.sleep(3000);
    }









}
