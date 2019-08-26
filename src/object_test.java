public class object_test
{
    public static void main(String[] args)
    {
        System.out.println("=============== test 1 ===============");
        dog a = new dog();
        SimpleDotCom b = new SimpleDotCom();
        //dog b = new dog();
        if (a.equals(b))
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }

        System.out.println("=============== test 2 ===============");
        System.out.println(b.getClass());

        System.out.println("=============== test 3 ===============");
        System.out.println("hashcode of a:" + a.hashCode());
        System.out.println("hashcode of b:" + b.hashCode());

        System.out.println("=============== test 4 ===============");
        System.out.println("a toString:" + a.toString());
        System.out.println("b toString:" + b.toString());
    }
}
