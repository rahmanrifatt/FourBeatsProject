import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class OpenBrowserAndSendKey {
    static List<String> listofdata=new ArrayList<>();
    String longestoption;
    String shortestoption;
    public void openbrowser(List<String> listOfCellDataFromExcel, String dayName, String projectPath, XSSFWorkbook workbook) throws InterruptedException, IOException {
        listofdata=listOfCellDataFromExcel;
        int rownum=2;
        for (String x: listofdata){
            System.setProperty("webdriver.chrome.driver","D://selenium jar file//webdriver//chromeDriver//New folder/chromedriver.exe");
            Thread.sleep(4000);
            WebDriver driver= new ChromeDriver();
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.get("https://Google.com");
            driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys(x);
            Thread.sleep(3000);
            List<WebElement> list= driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
            List<String> texts = list.stream().map(WebElement::getText).collect(Collectors.toList());

            GetLongestOption longestOption= new GetLongestOption();
            longestOption.longest(texts);
            longestoption=longestOption.longestOption;

            GetShortestOption shortestOption=new GetShortestOption();
            shortestOption.shortest(texts);
            shortestoption=shortestOption.sortestOption;

            System.out.println(longestoption);
            System.out.println(shortestoption);

            LongestDataWriteInExcelFile longestDataWriteInExcelFile=new LongestDataWriteInExcelFile();
            longestDataWriteInExcelFile.longestData(dayName,projectPath,workbook,longestoption,rownum);

            ShortestDataWriteInExcelFille shortestDataWriteInExcelFille=new ShortestDataWriteInExcelFille();
            shortestDataWriteInExcelFille.ShortestData(dayName,projectPath,workbook,shortestoption,rownum);
            rownum++;

            Thread.sleep(2000);
            driver.close();

        }
    }

}
