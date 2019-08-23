public class guess_game
{
    player p1, p2, p3;

    public void start()
    {
        p1 = new player();
        p2 = new player();
        p3 = new player();

        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        boolean p1_is_right = false;
        boolean p2_is_right = false;
        boolean p3_is_right = false;

        int target = (int) (Math.random() *10);
        System.out.println("I'm thinking of a number between 0 and 9...");

        while (true)
        {
            System.out.println("Number to guess is " + target);
            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.println("Player 1 guessed " + guessp1);
            guessp2 = p2.number;
            System.out.println("Player 2 guessed " + guessp2);
            guessp3 = p3.number;
            System.out.println("Player 3 guessed " + guessp3);

            if (guessp1 == target)
            {
                p1_is_right = true;
            }
            if (guessp2 == target)
            {
                p2_is_right = true;
            }
            if (guessp3 == target)
            {
                p3_is_right = true;
            }

            if (p1_is_right || p2_is_right || p3_is_right)
            {
                System.out.println("We have a winner.");
                System.out.println("Player 1 got it right? " + p1_is_right);
                System.out.println("Player 2 got it right? " + p2_is_right);
                System.out.println("Player 3 got it right? " + p3_is_right);

                System.out.println("Game is over.");
                break;
            }
            else
            {
                System.out.println("players will have to try again.");
            }
        }
    }
}




