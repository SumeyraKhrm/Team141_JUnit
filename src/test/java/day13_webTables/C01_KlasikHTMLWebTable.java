package day13_webTables;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_KlasikHTMLWebTable extends TestBase {

    @Test
    public void test01(){

        // Bir web tablosu klasik HTML tag'lari ile olusturulmussa
        // (table-thead-tbody-td-tr) sadece tag'lari kullanarak
        // istedigimiz tum webelementleri locate edebiliriz

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2. Web table tum body’sini yazdirin
        WebElement tumBodyElementi = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum Body" + tumBodyElementi.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedTabloIcerik = "Comfortable Gaming Chair";
        String actualTumBody = tumBodyElementi.getText();

        Assertions.assertTrue(actualTumBody.contains(expectedTabloIcerik));

        //4. Web table’daki satir sayisinin 5 oldugunu test edin
        int expectedSatirSayısi = 5;
        List<WebElement> satırElementleriListesi = driver.findElements(By.xpath("//tbody/tr"));
        int actualSatirSayısi =satırElementleriListesi.size();

        Assertions.assertEquals(expectedSatirSayısi,actualSatirSayısi);

        //5. Tum satirlari yazdirin
        System.out.println("Tum satirlar : " );

        for (int i = 0; i <satırElementleriListesi.size() ;i++) {
            System.out.println(i+1 +". satir : \n" +satırElementleriListesi.get(i).getText());
        }

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        //   sutun sayisi web table'da YOKTUR, bir satirdaki data sayisi vardir
        //   kac sutun oldugunu gormek icin, herhangi bir satirdaki data sayisina bakabiliriz

        List<WebElement> birinciSatirElementleriList =
                driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedSutunSayisi = 4;
        int actualSutunSayisi = birinciSatirElementleriList.size();

        Assertions.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        //7. 3.sutunu yazdirin
        //   Web tablosunda sutun yoktur
        //   ama HER satirdaki 3.DATA'yi alip sutunu elde edebiliriz
        List<WebElement> ucuncuSutunElementleriList =
                driver.findElements(By.xpath("//tbody/tr/td[3]"));

        System.out.println("3. sutundaki bilgiler : " + ReusableMethods.stringListesineDonustur(ucuncuSutunElementleriList));


        //8. Tablodaki basliklari yazdirin
        List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//thead//th"));
        System.out.println("Basliklar : " + ReusableMethods.stringListesineDonustur(baslikElementleriList));


        //9. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        System.out.println(getData(4, 1)); // Comfortable Gaming Chair
        System.out.println(getData(1,3)); // $399.00


        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin
        String expectedData = "Furniture";
        String actualData = getData(4,2);

        Assertions.assertEquals(expectedData,actualData);

        // 11. tabloda category'si "Men Fashion" olan urun bulundugunu test edin
        boolean menFashionVarMi = false;


        for (int i = 1; i <= actualSatirSayısi ; i++) {
            if (getData(i,2).equals("Men Fashion")){
                menFashionVarMi =true;
            }
        }


        Assertions.assertTrue(menFashionVarMi);

    }



    public String getData (int satirNo,int sutunNo){

        // 4.satir, 1.sutundaki data icin locator :  //tbody/tr[4]/td[1]
        // dinamik halde yazarsak

        String dinamikXpath = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement  istenenDataElement = driver.findElement(By.xpath(dinamikXpath));

        return istenenDataElement.getText();

    }

}
