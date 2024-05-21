package day06_jUnit_assertions;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  //bu order sıralaması ıcın gereklı
public class C01_BeforeAll_AfterAll {

    // gerekli ayarlamalari yapip

    // 1- testotomasyonu anasayfaya gidin ve anasayfaya gittiginizi test edin
    // 2- phone icin arama yaptirip, arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayip, urun isminde case sensitive olmaksizin phone gectigini test edin

    /*
        Bir class'da birden fazla @Test method'u varsa
        oncelikle setup ve teardown method'larinin nasil calismasi gerektigine karar vermeliyiz
        JUnit bize iki alternatif sunuyor
        1- herbir(each) method'dan once ve sonra calismalarini istiyorsak
           @BeforeEach ve @AfterEach kullaniriz

        2- eger @Test method'lari birbirine bagli ise
           ve her @Test method'undan sonra KAPATMAMAMIZ gerekiyorsa
           hepsinden(All) once ve sonra bir kere calismasini istiyorsak
           @BeforeAll ve @AfterAll kullaniriz

           ONEMLI NOT : @BeforeAll ve @AfterAll kullanan method'lar STATIC olmak ZORUNDADIR
     */


    static WebDriver driver;
    static List<WebElement> bulunanSonucElementleriList;

    @BeforeAll // Hic bir @Test method'u calismadan en basta sadece 1 kere calisir
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

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");
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

        if (bulunanSonucElementleriList.size()>0){
            System.out.println("phone arama testi PASSED");
        }else System.out.println("phone arama testi FAILED");
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

        if (actualUrunIsmi.contains(expectedUrunIsimIcerigi)){
            System.out.println("Urun isim testi PASSED");
        }else System.out.println("Urun isim testi FAILED");

        Thread.sleep(2000);
    }


}
