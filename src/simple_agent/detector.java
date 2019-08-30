package simple_agent;

public class detector
{
    public boolean detect(environment e, int index)
    {
        if (e.rooms.get(index).dirty == 1)
            return true;
        else
            return false;
    }

    public void show_condition(environment e)
    {
        int a = 0;
        System.out.println("room size : "+ e.rooms.get(0).shape);
        System.out.println("rooms condition:");
        for(room r : e.rooms)
        {
            System.out.println(a + " : "+r.dirty);
            a++;
        }
    }
}
