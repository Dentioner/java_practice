public class thread_tester
{
    public static void main(String[] args)
    {
        Runnable thread_job = new my_runnable();
        Thread my_thread = new Thread(thread_job);

        my_thread.start();
        System.out.println("back in main");
    }
}

class my_runnable implements Runnable
{
    public void run()
    {
        go();
    }

    public void go()
    {
        doMore();
    }
    public void doMore()
    {
        System.out.println("top o' the stack");
    }

}