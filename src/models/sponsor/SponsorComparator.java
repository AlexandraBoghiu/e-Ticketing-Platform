package models.sponsor;

import java.util.Comparator;

public class SponsorComparator implements Comparator<Sponsor> {
    public int compare(Sponsor s1, Sponsor s2) {
        if ((s1.getType().equals("gold")) && (s2.getType().equals("silver") || s2.getType().equals("bronze")))
            return -1;
        else if ((s1.getType().equals("silver")) && s2.getType().equals("bronze"))
            return -1;
        else if ((s1.getType().equals("bronze")) && (s2.getType().equals("silver")))
            return 1;
        else if ((s2.getType().equals("gold")) && (s1.getType().equals("silver") || s1.getType().equals("bronze")))
            return 1;
        else return 1;
    }
}
