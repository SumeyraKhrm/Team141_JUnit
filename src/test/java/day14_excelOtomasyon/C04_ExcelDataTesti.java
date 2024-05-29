package day14_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ExcelDataTesti {


    @Test
    public void test01() throws IOException {

        // Ulkeler excelinde Sayfa1'e gidin
        String dosyaYolu ="src/test/java/day14_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // kayitli ulkeler arasinda ingilizce ismi Netherlands olan bir ulke bulundugunu test edin

        int sonSatirIndexi = sayfa1.getLastRowNum();

        boolean netherlandsVarMı = false;


        for (int i = 0; i <=sonSatirIndexi ; i++) {

            // o satirdaki ingilizce ulke ismini kontrol edip, Netherlans ise flag'i true yapalim
            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();

            if (satirdakiUlkeIsmi.equalsIgnoreCase("Netherlands")){
                netherlandsVarMı = true;
            }
        }

        Assertions.assertTrue(netherlandsVarMı);



        // kayitli ulkeler icinde ingilizce baskent ismi Ankara olan ulkenin
        // ingilizce isminin Turkey oldugunu test edin

        for (int i = 0; i <=sonSatirIndexi ; i++) {

            // her satirdaki ingilizce baskent ismine bakalim
            // Ankara bulursak, O satirdaki ingilizce ulke isminin Turkey oldugunu test edelim

            String satirdakiBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

            if (satirdakiBaskentIsmi.equalsIgnoreCase("Ankara")){
                String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();

                Assertions.assertEquals("Turkey",satirdakiUlkeIsmi);

            }
        }





    }
}
