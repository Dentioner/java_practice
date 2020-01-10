package test_flyweight;

public class FlyDriver
{
    public static void main(String args[])
    {
        int ex = 22;
        FlyweightFactory f = new FlyweightFactory();

        Flyweight fx =  f.GetFlyweight("X");
        fx.Operation(--ex);

        Flyweight fy =  f.GetFlyweight("Y");
        fy.Operation(--ex);

        Flyweight fz =  f.GetFlyweight("Z");
        fz.Operation(--ex);

        Flyweight uf = new UnsharedFlyweight();
        uf.Operation(--ex);


    }
}
