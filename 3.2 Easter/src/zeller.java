public class zeller {
    public int congruence(int day, int year, int month){
                                         //this is just the zellers congruence algorithm, I took the math off wikipedia and converted it to java, at least I think I did.
                                         //just realized I didn't need this algorithm at all because Easter is always on sunday
                                         //it's ok though because  now I have code for zeller's algorithm that may be useful later on i guess.
        int k = (year%100);
        int j = (year/100);
       
        if (month < 3) {
            month += 12;
            year -= 1;
        }


        int out = ((day + (((month + 1) * 26) / 10) + k + (k / 4) + (j / 4)) +
                (5 * j)) % 7;
        return out;
    }


}
