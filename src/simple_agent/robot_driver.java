package simple_agent;

public class robot_driver
{


    public static void main(String[] args)
    {
        environment en = new environment(4);
        actuator a = new actuator(en);
        detector d = new detector();
        robot_moving robot = new robot_moving(en);

        System.out.println("Before cleaning:");
        d.show_condition(en, robot);

        while(!robot.stop)
        {
            if(d.detect(en, robot.index))
            {
                a.clean(en, robot);
                System.out.println("Suck");
                robot.score += 10;
            }
            robot = a.move(en.room_size -1, robot);
            robot.score -= 1;
            if(robot.right)
            {
                System.out.println("Right");
            }
            else
            {
                System.out.println("Left");
            }
        }

        System.out.println(" ");
        System.out.println("After cleaning:");
        d.show_condition(en, robot);
        System.out.println("Score: " + robot.score);
    }


}

