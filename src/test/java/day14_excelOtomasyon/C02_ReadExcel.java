package day14_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {


    @Test
    public void test01() throws IOException {

        String dosyaYolu ="src/test/java/day14_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");


        //		- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1)); //Başkent (İngilizce)


        //		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String satir1hucre2 = sayfa1.getRow(0).getCell(1).toString();
        System.out.println(satir1hucre2); // Başkent (İngilizce)

        //		- 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim

        String expectedData_2_4 = "Kabil";
        String actualData_2_4 = sayfa1.getRow(1).getCell(3).toString();

        Assertions.assertEquals(expectedData_2_4,actualData_2_4);

        //		- Satir sayisinin 191 oldugunu test edin
        // getLastRowNum() kullanilan son satirin index'ini bize verir


        int expectedSatirSayisi = 191 ;
        int actualSatirSayisi = sayfa1.getLastRowNum()+1;

        Assertions.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        //		- Fiziki olarak kullanilan satir sayisini bulun

        System.out.println("Fiziki olarak kullanilan satir sayisi : "+ sayfa1.getPhysicalNumberOfRows()); //

        // getPhysicalNumberOfRows() bize fiziki olarak kullanilan satir sayisini verir
        // ONEMLI NOT : getLastRowNumber() arada bos olan satirlar olsa da
        //              son kullanilan satira gider ve index'ini bize getirir
        //              getPhysicalNumberOfRows() ise aradaki bos olan satirlari saymaz



        }
    }
