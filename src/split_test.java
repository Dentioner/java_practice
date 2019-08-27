public class split_test
{
    public static void main(String[] args)
    {
        String a = "asdasdasdads/qweqweweqweqw";
        String[] b = a.split("/");
        for(String c:b)
        {
            System.out.println(c);
        }
    }
}
