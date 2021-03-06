package com.company.services;

import com.company.models.Sponsor;
import com.company.repository.SponsorRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class SponsorService {
    private static List<Sponsor> sponsors = new ArrayList<Sponsor>();
    private static Integer id = 0;
    private static SponsorService instance = null;
    SponsorRepository sponsorRepository = SponsorRepository.getInstance();
    private SponsorService() throws IOException {

    }

    public static SponsorService getInstance() throws IOException {
        if (instance != null) {
            return instance;
        }
        instance = new SponsorService();
        return instance;
    }

    public Sponsor createSponsor(List<String[]> parametersArray, boolean fromCsv) {
        id = Sponsor.getIdSponsor() + 1;
        if (fromCsv) {
            try {
                if (parametersArray.get(id)[2].toLowerCase().equals("gold") || parametersArray.get(id)[2].toLowerCase().equals("silver")
                        || parametersArray.get(id)[2].toLowerCase().equals("bronze")) {
                    Sponsor sponsor = new Sponsor(parametersArray.get(id)[1], parametersArray.get(id)[2].toLowerCase());
                    sponsors.add(sponsor);
                    sponsorRepository.addSponsor(sponsor);
                    return sponsor;
                }
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        } else {
            try {
                if (parametersArray.get(0)[1].toLowerCase().equals("gold") || parametersArray.get(0)[1].toLowerCase().equals("silver")
                        || parametersArray.get(0)[1].toLowerCase().equals("bronze")) {
                    Sponsor sponsor = new Sponsor(parametersArray.get(0)[0], parametersArray.get(0)[1].toLowerCase());
                    sponsors.add(sponsor);
                    sponsorRepository.addSponsor(sponsor);
                    return sponsor;
                }
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        }
        return null;
    }

    public void updateSponsor(String parameters) {
        String[] parametersArray = parameters.split(", ");
        Sponsor sponsor = getSponsorById(Integer.parseInt(parametersArray[0]));
        sponsor.setName(parametersArray[1]);
        sponsorRepository.updateSponsorName(sponsor.getName(), sponsor.getId());
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

    public void getSponsorsByType(String type) throws IOException {
        sponsors.stream().filter(sponsor -> sponsor.getType().equals(type.toLowerCase())).forEach(sponsor -> System.out.println(sponsor));
        System.out.println("From the database: ");
        System.out.println(sponsorRepository.getSponsorByType(type));
    }

    public void deleteSponsorById(Integer id) throws SQLException, IOException {
        for (Sponsor sponsor : sponsors) {
            if (sponsor.getId().equals(id)) {
                sponsors.remove(sponsor);
                sponsorRepository.deleteSponsor(id);
                System.out.println(sponsor + " has been successfully removed.");
                break;
            }
        }
    }
}

