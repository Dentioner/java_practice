package simple_agent;

public class robot_driver
{


    public static void main(String[] args)
    {
        environment en = new environment(2);
        actuator a = new actuator();
        detector d = new detector();
        robot_moving robot = new robot_moving();

        System.out.println("Before cleaning:");
        d.show_condition(en);

    }
}

