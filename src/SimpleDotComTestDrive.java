public class SimpleDotComTestDrive
{
    public static void main(String[] args)
    {
        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = {2,3,4};
        dot.setLocation_cells(locations);
        String userGuess = "2";
        String result = dot.check_yourself(userGuess);
    }
}

