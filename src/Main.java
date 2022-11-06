import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    static String projectPath="C:\\Users\\User\\IdeaProjects\\FourBeatsProject\\src\\Excel\\Excel.xlsx";
    static XSSFWorkbook Workbook;
    static XSSFSheet sheet;
    static int rownum;
    static String DayName;
    static List<String> ListOfCellDataFromExcel=new ArrayList<>();
    public static void main(String[] args) throws IOException, InterruptedException {
        GetDayName getDay=new GetDayName();
        DayName= getDay.day();

        RowCounter rowcount=new RowCounter();
        rownum= rowcount.Row(DayName,projectPath,Workbook);

        GetCellData c=new GetCellData();
        c.CellData(DayName,projectPath,Workbook,rownum);
        ListOfCellDataFromExcel=c.celdatalist;

        OpenBrowserAndSendKey  opn=new OpenBrowserAndSendKey();
        opn.openbrowser(ListOfCellDataFromExcel,DayName,projectPath,Workbook);


    }
}