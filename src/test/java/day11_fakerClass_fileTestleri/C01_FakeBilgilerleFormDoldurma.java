package day11_fakerClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import static org.openqa.selenium.Keys.PAGE_DOWN;

public class C01_FakeBilgilerleFormDoldurma extends TestBase {


    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath(" //*[text()=' Sign Up']"))
                .click();


        //4- Ad, soyad, mail ve sifre kutularina fake degerler yazalim

         /*
        System.out.println(faker.food().fruit()); // Plums
        System.out.println(faker.address().zipCodeByState("TX")); // 798XX
        System.out.println(faker.name().fullName()); // Shaniqua Legros
        System.out.println(faker.company().name()); // Kulas, Toy and Mueller
        System.out.println(faker.internet().emailAddress()); // joselyn.parisian@gmail.com
         System.out.println(faker.address());
        System.out.println(faker.name().firstName());


         */

        Faker faker = new Faker();

        WebElement firstNameKutusu = driver.findElement(By.id("firstName"));
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        String sifre = faker.internet().password();
        String fakemail = faker.internet().emailAddress();

        actions.click(firstNameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakemail)
                .sendKeys(Keys.TAB)
                .sendKeys(sifre)
                .sendKeys(Keys.TAB)
                .sendKeys(sifre)
                .perform();
        //ve Sign Up butonuna basalim
        ReusableMethods.bekle(2);

        actions.sendKeys(PAGE_DOWN).perform();  //sayfanın asagı inmesi ıcın gereklı
        driver.findElement(By.xpath("//*[@id='btn-submit-form']")).click();

        //5- Kaydin olusturuldugunu test edin
        ReusableMethods.bekle(3);

        // test etmek icin sisteme giris yapalim
        WebElement emailAdresKutusu = driver.findElement(By.id("email"));

        actions.click(emailAdresKutusu)
                .sendKeys(fakemail)
                .sendKeys(Keys.TAB)
                .sendKeys(sifre)
                .perform();

        driver.findElement(By.id("submitlogin"))
                .click();


        WebElement logoutButonu = driver.findElement(By.xpath("//span[text()='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        ReusableMethods.bekle(5);

        }
    }


