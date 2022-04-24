package com.company.services;

import com.company.models.Sponsor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class SponsorService {
    static private List<Sponsor> sponsors = new ArrayList<Sponsor>();
    static private Integer id = 0;
    private static SponsorService instance = null;

    private SponsorService() {

    }
    public static SponsorService getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new SponsorService();
        return instance;
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
        } else {
            sponsors.forEach((sponsors) -> System.out.println(sponsors));
        }
    }

    public void getSponsorsByType(String type) {
        sponsors.stream().filter(sponsor -> sponsor.getType().equals(type.toLowerCase())).forEach(sponsor -> System.out.println(sponsor));
    }

    public void deleteSponsorById(Integer id) {
        for (Sponsor sponsor : sponsors) {
            if (sponsor.getId().equals(id)) {
                sponsors.remove(sponsor);
                System.out.println(sponsor + " has been successfully removed.");
                break;
            }
        }
    }
}

