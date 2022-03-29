package services;

import sponsor.Sponsor;
import java.util.ArrayList;
import java.util.Arrays;


public class SponsorService {
    ArrayList<Sponsor> sponsors = new ArrayList<Sponsor>();
    static Integer id = 0;

    public void createSponsor(String parameters) {
        id++;
        String[] parametersArray = parameters.split(", ");
        System.out.println(Arrays.toString(parametersArray));
        Sponsor sponsor = new Sponsor(id, parametersArray[0], parametersArray[1]);
        System.out.println(sponsor);
        sponsors.add(sponsor);
    }
    public void updateSponsor(String parameters) {
        String[] parametersArray = parameters.split(", ");
        System.out.println(Arrays.toString(parametersArray));
        Sponsor sponsor = getSponsorById(Integer.parseInt(parametersArray[0]));
        sponsor.setName(parametersArray[1]);
        sponsor.setType(parametersArray[2].toLowerCase());
    }
    public Sponsor getSponsorById(Integer sponsorId) {
        for (Sponsor sponsor : sponsors) {
            if (sponsor.getId().equals(sponsorId))
                return sponsor;
        }
        return null;
    }
    public void getSponsors() {
        if (this.sponsors.size() == 0) {
            System.out.println("There are 0 sponsors :(.");
        } else for (Sponsor sponsor : this.sponsors) {
            System.out.println(sponsor);
        }
    }
    public void getSponsorsByType(String type) {
        for (Sponsor sponsor : sponsors) {
            if (sponsor.getType().equals(type.toLowerCase()))
                System.out.println(sponsor);
        }
    }
    public void deleteSponsorById(Integer id) {
        for (Sponsor sponsor : sponsors) {
            if (sponsor.getId().equals(id)) {
                this.sponsors.remove(sponsor);
                System.out.println(sponsor + " has been successfully removed.");
                break;
            }
        }
    }
}

