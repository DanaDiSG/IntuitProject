package com.intuit.domain.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.join;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PlayerResponseRecord {
    private static final String DELIMITER = ", ";

    // region Fields

    private String playerID;
    private LocalDate birthDate;
    private String birthAddress;
    private LocalDate deathDate;
    private String deathAddress;
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

    public PlayerResponseRecord() {
    }

    public PlayerResponseRecord(String playerID, LocalDate birthDate, String birthAddress, LocalDate deathDate, String nameFirst, String nameLast, String nameGiven,
                                Integer weight, Integer height, Character bats, Character _throws,
                                String debut, String finalGame, String retroID, String bbrefID) {
        this.playerID = playerID;
        this.birthDate = birthDate;
        this.birthAddress = birthAddress;
        this.deathDate = deathDate;
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

    public PlayerResponseRecord(PlayerDetails playerDetails) {
        this.playerID = playerDetails.getPlayerID();
        this.birthDate =
                playerDetails.getBirthYear() != null && playerDetails.getBirthMonth() != null & playerDetails.getBirthDay() != null
                        ? LocalDate.of(playerDetails.getBirthYear(), playerDetails.getBirthMonth(), playerDetails.getBirthDay()) : null;
        this.birthAddress =
                !playerDetails.getBirthCountry().isEmpty() && !playerDetails.getBirthState().isEmpty() && !playerDetails.getBirthCity().isEmpty()                        ? join(DELIMITER, playerDetails.getBirthCountry(), playerDetails.getBirthState(), playerDetails.getBirthCity()) : "";
        this.deathDate =
                playerDetails.getDeathYear() != null && playerDetails.getDeathMonth() != null && playerDetails.getDeathDay() != null
                        ? LocalDate.of(playerDetails.getDeathYear(), playerDetails.getDeathMonth(), playerDetails.getDeathDay()) : null;
        this.deathAddress =
                !playerDetails.getDeathCountry().isEmpty() && !playerDetails.getDeathState().isEmpty() && !playerDetails.getDeathCity().isEmpty()
                        ? join(DELIMITER, playerDetails.getDeathCountry(), playerDetails.getDeathState(), playerDetails.getDeathCity()) : "";
        this.nameFirst = playerDetails.getNameFirst();
        this.nameLast = playerDetails.getNameLast();
        this.nameGiven = playerDetails.getNameGiven();
        this.weight = playerDetails.getWeight();
        this.height = playerDetails.getHeight();
        this.bats = playerDetails.getBats();
        this._throws = playerDetails.get_throws();
        this.debut = playerDetails.getDebut();
        this.finalGame = playerDetails.getFinalGame();
        this.retroID = playerDetails.getRetroID();
        this.bbrefID = playerDetails.getBbrefID();
    }

    // endregion

    // region Getters and Setters

    public String getPlayerID() {
        return playerID;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBirthAddress() {
        return birthAddress;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public String getDeathAddress() {
        return deathAddress;
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
