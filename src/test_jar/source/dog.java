


import java.util.ArrayList;

class dog extends animal
{
    int size;
    String breed;
    String name;

    void bark()
    {
        System.out.println("Ruff! Ruff!");
    }

    public void roam()
    {
        bark();
    }
}

class dog_test_drive
{
    public static void main(String[] args)
    {
        dog d = new dog();
        d.size = 40;
        d.bark();
    }
}

