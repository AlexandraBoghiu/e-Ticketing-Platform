package com.company.models;

public class Sponsor {
    final private Integer id;
    private static Integer idSponsor = 0;
    private String name;
    private String type;

    public Sponsor(String name, String type) {
        idSponsor++;
        this.id = idSponsor;
        this.name = name;
        this.type = type;
    }

    public static Integer getIdSponsor() {
        return idSponsor;
    }

    public static void setIdSponsor(Integer idSponsor) {
        Sponsor.idSponsor = idSponsor;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
