import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class LongestDataWriteInExcelFile {
    private static XSSFSheet sheet;
    public void longestData(String dayName, String projectPath, XSSFWorkbook workbook, String longestoption, int rownum) throws IOException {
        workbook = new XSSFWorkbook(projectPath);
        sheet =workbook.getSheet(dayName);
        Row row = sheet.getRow(rownum);
        Cell longOption= row.createCell(3);
        longOption.setCellValue(longestoption);
        FileOutputStream out = new FileOutputStream(new File(projectPath));
        workbook.write(out);
        out.close();
    }
}
