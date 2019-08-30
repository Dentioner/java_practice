package simple_agent;

import java.util.Random;

public class actuator
{
    static boolean[] memories;

    public actuator(environment e)
    {
        int room_number = e.room_size;
        memories = new boolean[room_number];
        for (boolean i : memories)
        {
            i = false;
        }
    }

    public robot_moving move(int max_index, robot_moving robot)
    {
        memories[robot.index] = true;
        if(!finish())
        {
            if (robot.right)
            {
                if (robot.index >= max_index)
                {
                    robot.index--;
                    robot.right = false;
                }
                else
                {
                    robot.index++;
                }
            }
            else
            {
                if (robot.index <= 0)
                {
                    robot.index++;
                    robot.right = true;
                }
                else
                {
                    robot.index--;
                }
            }

            robot.stop = false;
        }
        else
        {
            robot.stop = true;
        }
        return robot;
    }

    public void clean(environment e, robot_moving r)
    {
        e.rooms.get(r.index).dirty = 0;

    }

    public boolean finish()
    {
        for(boolean i : memories)
        {
            if (!i)
                return false;
        }

        return true;
    }
}

class robot_moving
{
    int index;
    boolean right;
    boolean stop;
    int score;
    public robot_moving(environment en)
    {
        Random r = new Random();
        index = r.nextInt(en.room_size);
        right = true;
        stop = false;
        score = 0;
    }
}