public class Main
{
    public static void main(String[] args)
    {
        System.out.println(tidyNumber(39));
    }

    public static boolean tidyNumber(int number)
    {
        int t = number % 10;
        do
        {
            int g = number % 10;
            if (t < g)
                return false;

            t = g;
        } while ((number /= 10) > 0);

        return true; // Do your magic!
    }
}