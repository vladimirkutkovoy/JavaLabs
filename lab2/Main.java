import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main
{

    private static final String DIR_PATH = "D:\\Java\\archive";

    public static void main(String[] args) throws IOException
    {
        File dir = new File(DIR_PATH);

        String[] fileNames = dir.list(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.startsWith("combined_data_");
            }
        });

        int[] ratings = new int[5];
        int c = 0;
        //int[] cc = new int[20000];
        //int[] users = new int[2649430];
        int[] marks = new int[6];
        final int countFilm = 17771;
        int countFilm1 = 0;

        Film[] myFilms = new Film[countFilm];
        myFilms[0] = new Film(-1);
        final int countUser = 2649430;
        int[] topUsers = new int[countUser];

        User[] myUsers = new User[countUser];

        if (fileNames != null)
        {
            for (String fileName : fileNames)
            {
                FileReader fl = new FileReader(DIR_PATH + "\\" + fileName);
                Scanner scanner = new Scanner(fl);

                String filmIdStr = scanner.nextLine();
                while (scanner.hasNextLine())
                {
                    filmIdStr = filmIdStr.substring(0, filmIdStr.length() - 1);
                    int my_id = Integer.parseInt(filmIdStr);
                    myFilms[my_id] = new Film(my_id);

                    while (scanner.hasNextLine())
                    {
                        filmIdStr = scanner.nextLine();
                        if (filmIdStr.contains(":")) break;

                        int my_mark = Integer.parseInt(filmIdStr.split(",")[1]);
                        int id_user = Integer.parseInt(filmIdStr.split(",")[0]);
                        topUsers[id_user]++;


//                        myUsers[id_user].addFilmMark(my_id, my_mark);
                        myFilms[my_id].addMark(my_mark);
                    }

                    myFilms[my_id].caclAvMark();
                    countFilm1 = my_id;
                }
            }
        }

        // 1th que
        System.out.println("1.");
        int max = Integer.MIN_VALUE;
        int ind_max = -1;

        for (int i = 1; i < countFilm; i++)
        {
            if (myFilms[i] != null && myFilms[i].getCountMark() > max)
            {
                max = myFilms[i].getCountMark();
                ind_max = i;
            }
        }

        System.out.println("Film:");
        System.out.println("Id: " + ind_max);
        System.out.println("Count: " + max);

        // 2th que
        System.out.println("2.");
        Film filmMax = myFilms[1], filmMin = myFilms[1];
        for (int i = 1; i < countFilm; i++)
        {
            if (myFilms[i] == null)
                continue;

           // myFilms[i].caclAvMark();
            if (filmMax.getAvMark() > myFilms[i].getAvMark())
                filmMax = myFilms[i];

            if (filmMin.getAvMark() < myFilms[i].getAvMark())
                filmMin = myFilms[i];
        }
        System.out.println("Film:");
        System.out.println("Id: " + filmMax.getId());


        // 3th que
        System.out.println("3.");
        max = Integer.MIN_VALUE;
        ind_max = -1;
        for (int i = 1; i < countUser; i++)
        {
            if (topUsers[i] > max)
            {
                max = topUsers[i];
                ind_max = i;
            }
        }

        System.out.println("Top user:");
        System.out.println("Id: " + ind_max);
        System.out.println("Count of mark: " + max);

        // 4th que
        System.out.println("4.");
        max = Integer.MIN_VALUE;
        ind_max = -1;

        int temp[] = new int[5];
        for (int i = 1; i < countFilm; i++)
        {
            if (myFilms[i] == null)
                continue;
            for (int j = 0; j < 5; j++)
                temp[j] += myFilms[i].getMarks()[j];
        }

        for (int i = 0; i < 5; i++)
            if (temp[i] > max)
            {
                max = temp[i];
                ind_max = i;
            }

        System.out.println("Mark " + (ind_max + 1));

        // 5th que
        System.out.println("5.");
        Arrays.sort(myFilms , new Comparator<Film>()
        {
            @Override
            public int compare(Film o1, Film o2)
            {
                if(o1.getAvMark()> o2.getAvMark())
                    return 1;
                return 0;
            }
        });

        //Arrays.sort(myFilms, Comparator.comparing(obj-> obj.getAvMark()));
        System.out.println("Sort top");
        System.out.println(myFilms[1]);
        System.out.println(myFilms[1].getId());
        System.out.println(myFilms[1].getAvMark());

        System.out.println("Sort top");
        System.out.println(myFilms[2]);
        System.out.println(myFilms[2].getId());
        System.out.println(myFilms[2].getAvMark());

        System.out.println("Sort bottom");
        System.out.println(myFilms[17771-1]);
        System.out.println(myFilms[17771-1].getId());
        System.out.println(myFilms[17771-1].getAvMark());
    }
}
