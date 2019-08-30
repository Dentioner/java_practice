package simple_agent;

public class actuator
{

    public robot_moving move(int max_index, robot_moving robot)
    {
        if (robot.right)
        {
            if(robot.index >= max_index)
            {
                robot.index --;
                robot.right = false;
            }
            else
            {
                robot.index++;
            }
        }
        else
        {
            if(robot.index <= 0)
            {
                robot.index++;
                robot.right = true;
            }
            else
            {
                robot.index--;
            }
        }

        return robot;
    }

    public void clean(environment e, robot_moving r)
    {
        e.rooms.get(r.index).dirty = 0;
    }


}

class robot_moving
{
    int index;
    boolean right;
}