import java.text.SimpleDateFormat;
import java.util.Date;
public class GetDayName {
    public String day(){
        Date currentdate=new Date();
        SimpleDateFormat dayname=new SimpleDateFormat("EEEE");
        String DayName = (dayname.format(currentdate));
        return DayName;
    }
}
