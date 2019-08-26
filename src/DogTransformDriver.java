public class DogTransformDriver
{
    public static void main(String[] args)
    {
        dog a = new dog();
        Object b = DogTransform.getObject(a);

        System.out.println(b.getClass());
        if (b instanceof dog)
        {
            dog nb = (dog) b;
            nb.bark();
        }
    }

}
