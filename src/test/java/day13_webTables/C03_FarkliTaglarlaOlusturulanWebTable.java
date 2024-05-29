package day13_webTables;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C03_FarkliTaglarlaOlusturulanWebTable  extends TestBase {

    @Test
    public void test01(){

        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //      //*[@role='rowgroup'] [1] // *[@role ='gridcell'] [3]


        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslikElementleriList =
                driver.findElements(By.xpath("//*[@class='rt-tr']  // *[@role ='columnheader'] "));

        System.out.println("Basliklar : " + ReusableMethods.stringListesineDonustur(baslikElementleriList));
        //Basliklar : [First Name, Last Name, Age, Email, Salary, Department, Action]


        //  3. 3.sutunun basligini yazdirin
        System.out.println("3.sutun basligi : " + baslikElementleriList.get(2).getText()); // Age

        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tablodakiTumDataElementleri =
                driver.findElements(By.xpath("//*[@role='rowgroup'] // *[@role ='gridcell'] "));

        System.out.println("Tablodaki tum datalar : " +
                ReusableMethods.stringListesineDonustur(tablodakiTumDataElementleri));


        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        int bosOlmayanHucreSayisi = 0;
        for (int i = 0; i < tablodakiTumDataElementleri.size() ; i++) {

            if ( ! tablodakiTumDataElementleri.get(i).getText().isBlank()){
                bosOlmayanHucreSayisi++;
            }

        }
        System.out.println("Bos olmayan hucre sayisi : " + bosOlmayanHucreSayisi);
        // Bos olmayan hucre sayisi : 18


        //  6. Tablodaki satir sayisini yazdirin

        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@role='rowgroup']"));
        System.out.println("Satir sayisi : " + satirElementleriList.size());
        // Satir sayisi : 10


        //  7. Tablodaki sutun sayisini yazdirin
        //     herhangi bir satirdaki data sayisina bakabiliriz

        System.out.println("Tablodaki sutun sayisi : " + baslikElementleriList.size());
        //Tablodaki sutun sayisi : 7

        //  8. Tablodaki 3.kolonu yazdirin

        List<WebElement> ucuncuSutunElementleri =
                driver.findElements(By.xpath("//*[@role='rowgroup'] // *[@role ='gridcell'] [3]"));

        System.out.println("Ucuncu sutun : " + ReusableMethods.stringListesineDonustur(ucuncuSutunElementleri));
        //Ucuncu sutun : [39, 45, 29,  ,  ,  ,  ,  ,  ,  ]

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        for (int i = 1; i <=  satirElementleriList.size() ; i++) {

            //*[@role='rowgroup'] [1] // *[@role ='gridcell'] [3]

            String satirdakiIsimDinamikLocator =  "//*[@role='rowgroup'] [" + i + "] // *[@role ='gridcell'] [1]";
            String satirdakiMaasDinamikLocator =  "//*[@role='rowgroup'] [" + i + "] // *[@role ='gridcell'] [5]";

            String satirdakiIsim = driver.findElement(By.xpath(satirdakiIsimDinamikLocator))
                    .getText();

            String satirdakiMaas = driver.findElement(By.xpath(satirdakiMaasDinamikLocator))
                    .getText();

            if (satirdakiIsim.equalsIgnoreCase("Kierra")){
                System.out.println("Kierra'nin maasi : " + satirdakiMaas);
            }

            //Kierra'nin maasi : 2000

        }


















    }


    }
