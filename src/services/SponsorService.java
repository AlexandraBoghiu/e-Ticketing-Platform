package services;

import sponsor.Sponsor;
import sponsor.SponsorComparator;

import java.util.ArrayList;
import java.util.Arrays;


public class SponsorService {
    static ArrayList<Sponsor> sponsors = new ArrayList<Sponsor>();
    static Integer id = 0;

    public SponsorService() {
    }

    public void createSponsor(String parameters) {
        id++;
        String[] parametersArray = parameters.split(", ");
        if (parametersArray[1].toLowerCase().equals("gold") || parametersArray[1].toLowerCase().equals("silver") || parametersArray[1].toLowerCase().equals("bronze")) {
            Sponsor sponsor = new Sponsor(id, parametersArray[0], parametersArray[1].toLowerCase());
            sponsors.add(sponsor);
        }
    }

    public void updateSponsor(String parameters) {
        String[] parametersArray = parameters.split(", ");
        System.out.println(Arrays.toString(parametersArray));
        Sponsor sponsor = getSponsorById(Integer.parseInt(parametersArray[0]));
        sponsor.setName(parametersArray[1]);
    }

    public Sponsor getSponsorById(Integer sponsorId) {
        for (Sponsor sponsor : sponsors) {
            if (sponsor.getId().equals(sponsorId))
                return sponsor;
        }
        return null;
    }

    public void getSponsors() {
        if (sponsors.size() == 0) {
            System.out.println("There are 0 sponsors :(.");
        } else for (Sponsor sponsor : sponsors) {
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

