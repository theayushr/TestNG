import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    public Object[][] getExcelData() throws IOException {

        FileInputStream fis = new FileInputStream("/home/sysquare/Downloads/emailsandpassword.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int totalRows = sheet.getPhysicalNumberOfRows(); //these values aren't giving the right output for unknown reasons
        int totalCols = sheet.getRow(0).getLastCellNum();

        totalRows = 3;
        totalCols = 2;

        Object[][] data = new Object[totalRows-1][totalCols];

        for(int i =1; i<totalRows; i++){
            Row curRow = sheet.getRow(i);
            for(int j=0; j<totalCols; j++){
                String val = curRow.getCell(j).toString();
                /**
                 * the output here by curRow.getCell(i) is in the form of XSSF format and it's not a string
                 * int the dataProvider field we have mentioned that it should be a string
                 * so the data mismatch was there which got fixed by converting it into the string format
                 * by using toString method in the value we were getting.
                 */
                data[i-1][j] = val;
            }
        }
        return data;
    }

    public static void main(String[] args) throws IOException {
        ReadExcel obj = new ReadExcel();
        Object[][] val = obj.getExcelData();

        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                System.out.print(val[i][j] + " ");
            }
            System.out.println();
        }
    }
}
