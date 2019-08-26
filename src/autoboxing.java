import java.util.ArrayList;

public class autoboxing
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        int num = list.get(0);
        System.out.println(num);
    }
}
