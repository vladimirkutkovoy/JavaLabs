public class Main
{
    public static void main(String[] args)
    {
        System.out.println(high("what time are we climbing up to the volcano"));
    }

    public static String high(String s)
    {
        String str[] = s.split(" ");
        int sum = 0, ind = 0;

        for (int i = 0; i < str.length; i++)
        {
            int cur_sum = 0;
            for (int j = 0; j < str[i].length(); j++)
                cur_sum += str[i].charAt(j) - 'a' + 1;

            if (cur_sum > sum)
            {
                sum = cur_sum;
                ind = i;
            }
        }
        return str[ind];
    }
}