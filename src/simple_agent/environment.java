package simple_agent;

import java.util.ArrayList;
import java.util.Random;

public class environment
{
    int room_size;
    ArrayList<room> rooms = new ArrayList<room>();



    public environment(int size_input)
    {
        room_size = size_input;
        for (int i = 0; i < room_size; i++)
        {
            room new_room = new room();
            Random r = new Random();
            new_room.dirty = r.nextInt(2);
            rooms.add(new_room);
        }
    }


}

class room
{
    int dirty;
    String shape = "square";
}
