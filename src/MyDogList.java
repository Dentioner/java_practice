public class MyDogList
{
    private dog[] dogs = new dog[5];
    private int nextindex = 0;

    public void add(dog d)
    {
        if(nextindex < dogs.length)
        {
            dogs[nextindex] = d;
            System.out.println("Dog added at "+ nextindex);
            nextindex++;

        }
    }
}


