package com.intuit.domain.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDetails {

    // region Fields

    private String playerID;
    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDay;
    private String birthCountry;
    private String birthState;
    private String birthCity;
    private Integer deathYear;
    private Integer deathMonth;
    private Integer deathDay;
    private String deathCountry;
    private String deathState;
    private String deathCity;
    private String nameFirst;
    private String nameLast;
    private String nameGiven;
    private Integer weight;
    private Integer height;
    private Character bats;
    @JsonProperty("throws")
    private Character _throws;
    private String debut;
    private String finalGame;
    private String retroID;
    private String bbrefID;

    // endregion

    // region Constructors

    public PlayerDetails() {
    }

    public PlayerDetails(String playerID, Integer birthYear, Integer birthMonth,
                         Integer birthDay, String birthCountry, String birthState,
                         String birthCity, Integer deathYear, Integer deathMonth,
                         Integer deathDay, String deathCountry, String deathState,
                         String deathCity, String nameFirst, String nameLast, String nameGiven,
                         Integer weight, Integer height, Character bats, Character _throws,
                         String debut, String finalGame, String retroID, String bbrefID) {
        this.playerID = playerID;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthCountry = birthCountry;
        this.birthState = birthState;
        this.birthCity = birthCity;
        this.deathYear = deathYear;
        this.deathMonth = deathMonth;
        this.deathDay = deathDay;
        this.deathCountry = deathCountry;
        this.deathState = deathState;
        this.deathCity = deathCity;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.nameGiven = nameGiven;
        this.weight = weight;
        this.height = height;
        this.bats = bats;
        this._throws = _throws;
        this.debut = debut;
        this.finalGame = finalGame;
        this.retroID = retroID;
        this.bbrefID = bbrefID;
    }

    // endregion

    // region Getters and Setters

    public String getPlayerID() {
        return playerID;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public String getBirthState() {
        return birthState;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public Integer getDeathMonth() {
        return deathMonth;
    }

    public Integer getDeathDay() {
        return deathDay;
    }

    public String getDeathCountry() {
        return deathCountry;
    }

    public String getDeathState() {
        return deathState;
    }

    public String getDeathCity() {
        return deathCity;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }

    public Character getBats() {
        return bats;
    }

    public Character get_throws() {
        return _throws;
    }

    public String getDebut() {
        return debut;
    }

    public String getFinalGame() {
        return finalGame;
    }

    public String getRetroID() {
        return retroID;
    }

    public String getBbrefID() {
        return bbrefID;
    }

    // endregion
}
