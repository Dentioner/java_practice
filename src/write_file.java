import java.io.*;

public class write_file
{
    public static void main(String[] args)
    {
        try
        {
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("Hello, Foo!");
            writer.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
