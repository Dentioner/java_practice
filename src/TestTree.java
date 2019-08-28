import java.io.ObjectOutputStream;
import java.util.*;

public class TestTree
{
    public static void main(String[] args)
    {
        new TestTree().go();
    }

    public void go()
    {
        book b1 = new book("A");
        book b2 = new book("B");
        book b3 = new book("C");

        TreeSet<book> tree = new TreeSet<book>();
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println(tree);
    }
}

class book implements Comparable
{
    String title;
    public book(String t)
    {
        title = t;
    }

    public int compareTo(Object b)
    {
        book booook = (book) b;
        return (title.compareTo(booook.title));
    }
}
