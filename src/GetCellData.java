import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class GetCellData {
    private static XSSFSheet sheet;
    public List<String> celdatalist=new ArrayList<>();
    public String CellData(String dayName, String projectPath, XSSFWorkbook workbook, int rownum) throws IOException {
        int row = 2;
        int cell = 2;
        String cellData = null;
        workbook = new XSSFWorkbook(projectPath);
        GetCellData.sheet =workbook.getSheet(dayName);
        for (row = 2; row <= rownum; row++) {
             cellData = sheet.getRow(row).getCell(cell).getStringCellValue();
            celdatalist.add(cellData);
        }
        return celdatalist.toString();
    }

}
