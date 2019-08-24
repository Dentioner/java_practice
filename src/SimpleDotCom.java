public class SimpleDotCom
{
    int[] location_cells;
    int number_of_hits = 0;

    public void setLocation_cells(int[] locs)
    {
        location_cells = locs;
    }

    public String check_yourself(String stringGuess)
    {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        for (int cell:location_cells)
        {
            if(guess == cell)
            {
                result = "hit";
                number_of_hits++;
                break;
            }
        }

        if (number_of_hits == location_cells.length)
        {
            result = "kill";
        }

        System.out.println(result);
        return result;
    }
}