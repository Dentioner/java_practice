import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        // 键盘录入你的出生年月日 格式为yyyy-MM-dd
        // 把该字符串转换为一个日期
        // 通过该日期得到一个毫秒值
        // 获取2020年10月1日的毫秒值
        // 两者想减得到一个毫秒值
        // 把该毫秒值转换为天 打印输出
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String future = "2020-10-01";
        /********* Begin *********/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date t;
        Date fu_t;

        try
        {
            t = sdf.parse(line);
            fu_t = sdf.parse(future);
            long distance = fu_t.getTime() - t.getTime();
            System.out.println("你的出生日期距离2020年10月1日:" + distance/(1000*3600*24)+ "天");
        }
        catch (ParseException pe)
        {
            System.out.println("Unparseable using " + sdf);
        }
        /********* End *********/
    }
}