package day13_webTables;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C02_FarkliTaglarlaOlusturulanWebTable extends TestBase {


    //klasik olmasada illaki bir standardı vardır

    @Test
    public void test01(){

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //*[@role='trow'] [2] / *[@role ='tdata'][3]

        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslıkElementleriList =
                driver.findElements(By.xpath("//*[@role='hrow']  / *[@role ='hdata']"));

        System.out.println("Baslıklar :" + ReusableMethods.stringListesineDonustur(baslıkElementleriList));
        //Basliklar : [Product Name, Category, Price, Actions]

        //  3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : " + baslıkElementleriList.get(2).getText());
        //  3.sutun basligi : Price


        //  4. Tablodaki tum datalari yazdirin
        WebElement tumTableElementi = driver.findElement(By.className("table"));
        System.out.println("Tum body : \n" + tumTableElementi.getText());

        //  5. Tabloda kac tane cell (data) oldugunu yazdirin

        List<WebElement> bodydekiDataElementleriList =
                driver.findElements(By.xpath("//*[@role='trow'] / *[@role ='tdata']"));

        System.out.println("Body'deki cell sayisi : " + bodydekiDataElementleriList.size() );
        //Body'deki cell sayisi : 20


        //  6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirElementleriList =
                driver.findElements(By.xpath("//*[@role='trow']"));

        System.out.println("satır sayısı :" + satirElementleriList.size());
        //Tablodaki satir sayisi : 5


        //  7. Tablodaki sutun sayisini yazdirin
        //     Yukarda basliklari bir liste olarak kaydetmistik
        System.out.println("Tablodaki sutun sayisi : " + baslıkElementleriList.size());
        //  Tablodaki sutun sayisi : 4


        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleriList =
                driver.findElements(By.xpath("//*[@role='trow'] / *[@role ='tdata'] [3]"));

        System.out.println("3. sutun datalari : " + ReusableMethods.stringListesineDonustur(ucuncuSutunElementleriList));
        // 3. sutun datalari : [$399.00, $399.00, $399.00, $40.00, $15.00]


        // 9. Bir method olusturun, Test sayfasindan satir ve sutun verildiginde datayi dondursun
        // 3.satir, 2.sutundaki elementi yazdiralim
        System.out.println(getData(3, 2)); // Furniture



        //  10. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin
        System.out.println("Furniture kategorisindeki urunlerin fiyatlari : "); // $399.00

        for (int i = 1; i <= satirElementleriList.size() ; i++) {

            if (getData(i,2).equalsIgnoreCase("Furniture")){

                System.out.println(getData(i,3));
            }

        }





    }

    public String getData (int satirNo,int sutunNo){

        // 4.satir, 1.sutundaki data icin locator :  //tbody/tr[4]/td[1]
        // dinamik halde yazarsak

        String dinamikXpath = "//*[@role='trow'][" + satirNo + "]/*[@role ='tdata']["+ sutunNo + "]";

        WebElement  istenenDataElement = driver.findElement(By.xpath(dinamikXpath));

        return istenenDataElement.getText();


    }

}
