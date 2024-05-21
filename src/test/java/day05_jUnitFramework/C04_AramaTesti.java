package day05_jUnitFramework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AramaTesti {


    // gerekli ayarlamalari yapip

    // 1- testotomasyonu anasayfaya gidin ve anasayfaya gittiginizi test edin
    // 2- phone icin arama yaptirip, arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmaksizin phone gectigini test edin

    static WebDriver driver ; // butun methodlarda kullnaılması gerektıgı ıcın boyle
    static List<WebElement> bulunanSonucElementleriList;




    @Test
    public void test01() throws InterruptedException {
        // gerekli ayarlamalari yapip
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 1- testotomasyonu anasayfaya gidin ve anasayfaya gittiginizi test edin

        driver.get("https://www.testotomasyonu.com");
        // testotomasyonu sayfasina gittiginizi test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

    }

    @Test
        public void test02(){
        // 2- phone icin arama yaptirip,
          System.out.println(driver.getCurrentUrl());
          WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='global-search']"));
          aramaKutusu.sendKeys("phone" + Keys.ENTER);

       //arama sonucunda urun bulunabildigini test edin
            bulunanSonucElementleriList = driver.findElements(By.xpath("//*[@*='prod-img']"));

            if (bulunanSonucElementleriList.size()>0){
                System.out.println("phone arama testi PASSED");
            }else System.out.println("phone arama testi FAILED");
        }


    @Test
        public void test03() throws InterruptedException {
        // 3- ilk urunu tiklayip, urun isminde case sensitive olmaksizin phone gectigini test edin

            bulunanSonucElementleriList.get(0).click();



           WebElement ilkUrunIsimElementi =
                   driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

           String expectedIlkUrunIcerik = "phone";
           String actualIlkUrunIcerik = ilkUrunIsimElementi.getText().toLowerCase();

           if (expectedIlkUrunIcerik.contains(actualIlkUrunIcerik)){
                   System.out.println("Urun isim testi PASSED");
               }else System.out.println("Urun isim testi FAILED");

               Thread.sleep(2000);
               driver.quit();
           }



    }
