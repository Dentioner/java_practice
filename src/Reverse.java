import java.util.Scanner;
public class Reverse {
    public static StringBuffer start(String data) {
        StringBuffer ans = new StringBuffer(data);
        /********** Begin *********/

        ans = ans.reverse();


        /********** End *********/
        return ans;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        s += " ";
        String sub = "";
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if('a' <= ch && 'z' >= ch)
            {
                sub += ch;
            }
            else if ('A' <= ch && 'Z' >= ch)
            {
                sub += ch;
            }
            else
            {
                System.out.print(Reverse.start(sub) + " ");
                sub = "";
            }
        }


        /*
        String[] ss = s.split(" ");
        StringBuffer sb = new StringBuffer();
*/


        /*
        //method 1
        for(String a : ss)
        {
            sb = Reverse.start(a);
            System.out.print(sb.toString() + " ");
        }

        */
/*
        //method 2
        for(int i = 0; i < ss.length; i++)
        {
            String a = ss[i];
            sb = Reverse.start(a);
            System.out.print(sb.toString() + " ");
        }*/

    }
}
