package day06_jUnit_assertions;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class C03_JUnitAssertions {

    /*
      JUNit assertions calistiginda failed olursa
      kod'un hata verdigi yeri daha kolay bulabilmemiz icin
      JUnit altini TURUNCU NOKTALAR ile isaretler

      turuncu noktalar KIRMIZI ALT CIZGI (CTE) degildir
      testin nerede hata verdigini bize gosteren gecici isaretlerdir
      testi PASSED oldugunda bu turuncu noktalar kaybolur

      EGER failed oldugunda konsolda bir aciklama yazmasini istersek
      assertion'da message ekleyebiliriz
   */


    static WebDriver driver;
    static List<WebElement> bulunanSonucElementleriList;

    @BeforeAll  // Hic bir @Test method'u calismadan en basta sadece 1 kere calisir
    public static void setup(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll // Tum @Test method'lari calisip bittikten sonra en sonda sadece 1 kere calisir
    public static void teardown(){
        driver.quit();
    }

    @Test @Order(1)
    public void anasayfaTesti() throws InterruptedException {
        // 1- testotomasyonu anasayfaya gidin ve anasayfaya gittiginizi test edin
        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // testotomasyonu sayfasina gittiginizi test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        // actual url'in expectedUrlIcerik icerdigini test edin
        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik),"Url istenen icerigi barindirmiyor");


        Thread.sleep(2000);
    }

    @Test @Order(2)
    public void phoneAramaTesti() throws InterruptedException {
        // 2- phone icin arama yaptirip,
        System.out.println(driver.getCurrentUrl());
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='global-search']"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        //arama sonucunda urun bulunabildigini test edin
        bulunanSonucElementleriList =
                driver.findElements(By.xpath("//*[@*='prod-img']"));

        // listenin size'inin 0'dan buyuk oldugunu test edin

        Assertions.assertTrue(bulunanSonucElementleriList.size()>0, "listenin size'i 0'dan buyuk degil");

        Thread.sleep(2000);
    }

    @Test @Order(3)
    public void ilkUrunIsimTesti() throws InterruptedException {
        // 3- ilk urunu tiklayip, urun isminde case sensitive olmaksizin phone gectigini test edin

        bulunanSonucElementleriList.get(0).click();

        WebElement ilkUrunIsimElementi =
                driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsimIcerigi = "phone";
        String actualUrunIsmi = ilkUrunIsimElementi
                .getText()
                .toLowerCase();

        // urun isminin case sensitive olmadan phone icerdigini test edin

        Assertions.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerigi),"urun ismi case sensitive olmadan phone icermiyor");

        Thread.sleep(2000);
    }




}



