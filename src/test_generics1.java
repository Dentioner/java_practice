import java.util.ArrayList;

public class test_generics1
{
    public static void main(String[] args)
    {
        //new test_generics1().go();
        new test_generics1().go2();
    }

    public void go()
    {
        animal[] animals = {new dog(), new cat(), new dog()};
        dog[] dogs = {new dog(), new dog(), new dog()};
        takeAnimals(animals);
        takeAnimals(dogs);
    }

    public void go2()
    {
        ArrayList<animal> animals = new ArrayList<animal>();
        animals.add(new dog());
        animals.add(new cat());
        animals.add(new dog());

        takeAnimals2(animals);
    }

    public void go3()
    {
        ArrayList<animal> animals = new ArrayList<animal>();
        animals.add(new dog());
        animals.add(new cat());
        animals.add(new dog());

        takeAnimals2(animals);

        ArrayList<dog> dogs = new ArrayList<dog>();
        dogs.add(new dog());
        dogs.add(new dog());
        //takeAnimals2(dogs);
    }


    public void takeAnimals(animal[] animals)
    {
        for (animal a : animals)
        {
            a.roam();
        }
    }

    public void takeAnimals2(ArrayList<animal> animals)
    {
        for(animal a: animals)
        {
            a.roam();
        }
    }

    public void takeAnimals3(ArrayList<? extends animal> animals)
    {
        for(animal a: animals)
        {
            a.roam();
        }
    }
}
