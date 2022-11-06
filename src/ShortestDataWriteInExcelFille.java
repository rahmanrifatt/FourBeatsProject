import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class ShortestDataWriteInExcelFille {
    private static XSSFSheet sheet;
    public void ShortestData(String dayName, String projectPath, XSSFWorkbook workbook, String shortestoption, int rownum) throws IOException {
        workbook = new XSSFWorkbook(projectPath);
        sheet =workbook.getSheet(dayName);
        Row row = sheet.getRow(rownum);
        Cell longOption= row.createCell(4);
        longOption.setCellValue(shortestoption);
        FileOutputStream out = new FileOutputStream(new File(projectPath));
        workbook.write(out);
        out.close();
    }
}
