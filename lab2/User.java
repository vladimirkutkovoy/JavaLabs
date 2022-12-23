public class User
{
    private int id;
    private int film[] = new int [2649430];
    
    public User(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void addFilmMark(int id, int mark)
    {
        film[id] = mark;
    }
}
