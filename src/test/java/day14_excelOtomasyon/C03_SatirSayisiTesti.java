package day14_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_SatirSayisiTesti {


    @Test
    public void test01() throws IOException {

        String dosyaYolu ="src/test/java/day14_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa2 = workbook.getSheet("Sayfa2");


        // son satir index'inin 19 oldugunu test edelim
        int expectedSonSatirIndexi = 19;
        int actualSonSatirIndexi = sayfa2.getLastRowNum(); //son satır numarası deseydi 1 eklerdik

        Assertions.assertEquals(expectedSonSatirIndexi,actualSonSatirIndexi);

        // fiziki olarak kullanilan satir sayisinin 8 oldugunu test edelim
        int expectedFizikiKullanilanSatirsayisi = 8;
        int actualFizikiKullanilanSatirSayisi = sayfa2.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedFizikiKullanilanSatirsayisi,actualFizikiKullanilanSatirSayisi);


        // bos birakilan satirdaki hucreyi yazdirmak istersek
        // bos birakilan satirlari java row olarak olusturmaz   !!!
        // olmayan bir row'dan cell bilgisi isterseniz NPE olur

        // System.out.println(sayfa2.getRow(4).getCell(2)); // NullPointerException
        // System.out.println(sayfa2.getRow(14).getCell(3)); // NullPointerException


        // var olan bir satirda
        // KULLANILAN ALAN ICINDEKI bos bir cell'i yazdirirsak HICLIK,
        // KULLANILAN ALAN DISINDAKI bos bir cell'i yazdirirsak null yazdirir


        // var olan satirda kullanilmayan cell'i yazdiralim
        System.out.println(sayfa2.getRow(2).getCell(2)); // hiclik

        // 20.satir, 1.cell'i yazdiralim
        System.out.println(sayfa2.getRow(19).getCell(0));// hiclik

        // 3.satir, 10.cell'i yazdiralim
        System.out.println(sayfa2.getRow(2).getCell(9)); // null

        // 13.satir, 13.cell'i yazdiralim
        System.out.println(sayfa2.getRow(2).getCell(9)); // null



    }
}
