public class Film
{
    public int getId()
    {
        return id;
    }

    private final int id;
    private double avMark;
    private int countMark;
    private int[] marks = new int[5];

    public Film(int id)
    {
        this.id = id;
    }

    public void addMark(int mark)
    {
        marks[mark - 1]++;
    }

    public void caclAvMark()
    {
        double sum = 0;
        caclCountMark();

        for (int i = 0; i < 5; i++)
        {
            sum += marks[i] * (i + 1);
            countMark += marks[i];
        }

        sum /= countMark;
        avMark = sum;
    }

    public double getAvMark()
    {
        return avMark;
    }

    public void caclCountMark()
    {
        int countMark = 0;
        for (int i = 0; i < 5; i++)
        {
            countMark += marks[i];
        }
    }

    public int getCountMark()
    {
        return countMark;
    }

    public int[] getMarks()
    {
        return marks;
    }
}
