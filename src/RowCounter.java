import org.apache.poi.hssf.record.aggregates.RowRecordsAggregate;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
public class RowCounter {
    private static XSSFSheet sheet;
    public int Row(String dayName, String projectPath, XSSFWorkbook workbook) throws IOException {
        workbook = new XSSFWorkbook(projectPath);
        RowCounter.sheet =workbook.getSheet(dayName);
        int  rowcount = RowCounter.sheet.getPhysicalNumberOfRows();
        return rowcount;

    }
}
