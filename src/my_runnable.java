class ThreadTestDrive
{
    public static void main(String[] args)
    {
        Runnable threadJob = new my_runnable();
        Thread myThread = new Thread(threadJob);

        myThread.start();

        System.out.println("back in main");
    }

}
