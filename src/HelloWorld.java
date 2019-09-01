
import java.util.Scanner;
public class HelloWorld {

    public void judge(String fileName,String email)
    {
        int index1 = fileName.indexOf(".java");
        int index1_2 = fileName.indexOf(".");
        if(index1 == 0 || index1 == -1)
        {
            System.out.println("Java文件名无效");
        }
        else if(index1 != index1_2)
        {
            System.out.println("Java文件名无效");
        }
        else
        {
            String sub2 = fileName.substring(index1 + 5);
            int index1_3 = sub2.indexOf(".java");
            if(sub2.equals(""))
            {
                System.out.println("Java文件名正确");
            }
            else if(index1_3 != -1)
            {
                System.out.println("Java文件名正确");
            }
            else
            {
                System.out.println("Java文件名无效");
            }
        }

        int index2 = email.indexOf("@");
        int index3 = email.indexOf(".");

        if(index2 == 0 || index2 == -1)
        {
            System.out.println("邮箱名无效");
        }
        else if (index3 == 0 || index3 == -1)
        {
            System.out.println("邮箱名无效");
        }
        else if(index2 > index3)
        {
            System.out.println("邮箱名无效");
        }
        else if(index3 - index2 == 1)
        {
            System.out.println("邮箱名无效");
        }
        else
        {
            String sub = email.substring(index2 + 1);
            index2 = sub.indexOf("@");
            index3 = sub.indexOf(".");
            if(index2 != -1)
            {
                System.out.println("邮箱名无效");
            }
            else if(index3 == -1)
            {
                System.out.println("邮箱名无效");
            }
            else
            {
                System.out.println("邮箱名正确");
            }

        }

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        String email = sc.nextLine();
        HelloWorld h = new HelloWorld();
        h.judge(fileName, email);

    }
}
