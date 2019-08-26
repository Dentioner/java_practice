public class test_autobox
{
    Integer i;
    int j;

    public static void main(String[] args)
    {
        test_autobox t = new test_autobox();
        t.go();
    }

    public void go()
    {
        j = i;
        System.out.println("j = "+j);
        System.out.println("i = "+i);
    }
}
