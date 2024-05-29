package day14_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C05_MapIleExcelDataTesti {

    @Test
    public void test01() throws IOException {

        // Ulkeler excelinde Sayfa1'e gidin
        String dosyaYolu ="src/test/java/day14_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        int sonSatirIndexi = sayfa1.getLastRowNum();

        // Java ile ingilizce ulke isimleri ve ingilizce baskent isimlerini
        // bir Map olarak kaydedebiliriz
        // her satiri ele alip ulke ismini key, baskent ismini value olarak map'e ekleyelim

        Map<String,String> ulkelerVeBaskentlerMapi = new TreeMap<>();

        for (int i = 0; i <=sonSatirIndexi ; i++) {

            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();

            String satirdakiBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

            ulkelerVeBaskentlerMapi.put(satirdakiUlkeIsmi,satirdakiBaskentIsmi);
        }


        // kayitli ulkeler arasinda ingilizce ismi Netherlands olan bir ulke
        // bulundugunu test edin
        Assertions.assertTrue( ulkelerVeBaskentlerMapi.containsKey("Netherlands"));


        // kayitli ulkeler icinde ingilizce ulke ismi Turkey olan ulkenin
        // ingilizce baskent isminin Ankara oldugunu test edin
        Assertions.assertEquals("Ankara", ulkelerVeBaskentlerMapi.get("Turkey"));


        // ingilizce baskent ismi Berlin olan bir ulke oldugunu test edin
        Assertions.assertTrue(  ulkelerVeBaskentlerMapi.containsValue("Berlin")  );



        }
    }
