public class Main
{
    public static void main(String[] args)
    {
        System.out.println(encode("Prespecialized"));
    }

    static String encode(String word)
    {
        word = word.toLowerCase();
        String out = "";
        for (int i = 0; i < word.length(); i++)
        {
            int count = word.length() - word.replace(String.valueOf(word.charAt(i)), "").length();
            out += (count > 1) ? ")" : "(";
        }

        return out;
    }
}