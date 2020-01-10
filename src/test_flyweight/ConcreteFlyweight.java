package test_flyweight;
import java.io.*;
import java.util.Hashtable;

public class ConcreteFlyweight extends Flyweight
{
    @Override
    public void Operation(int ex)
    {
        System.out.println("具体Flyweight:"+ex);
    }
}

class UnsharedFlyweight extends Flyweight
{
    @Override
    public void Operation(int ex)
    {
        System.out.println("不共享的具体Flyweight:"+ex);
    }
}

class FlyweightFactory
{
    private Hashtable flyweights = new Hashtable();

    public FlyweightFactory()
    {
        flyweights.put("X", new ConcreteFlyweight());
        flyweights.put("Y", new ConcreteFlyweight());
        flyweights.put("Z", new ConcreteFlyweight());
    }

    public Flyweight GetFlyweight(String key)
    {
        return ((Flyweight)flyweights.get(key));
    }
}
