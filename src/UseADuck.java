public class UseADuck
{
    public static void main(String[] args)
    {
        int size = 1551;
        duck d = new duck(size);
    }
}

class duck
{
    int duck_size;
    public duck(int size)
    {

        duck_size = size;
        System.out.println("Quack, my size is " + duck_size);
    }
}
