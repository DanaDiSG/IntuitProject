package com.intuit.domain.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class PlayerResponseRecordTest {

    @Test
    public void constructor_nullBirthYear_NullBirthDate() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", null, 1, 1, "USA", "CA", "Orange", 3000, 1, 1, "USA", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertNull(record.getBirthDate());
    }

    @Test
    public void constructor_nullBirthMonth_nullBirthDate() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, null, 1, "USA", "CA", "Orange", 3000, 1, 1, "USA", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertNull(record.getBirthDate());
    }

    @Test
    public void constructor_nullBirthDay_nullBirthDate() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, null, "USA", "CA", "Orange", 3000, 1, 1, "USA", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertNull(record.getBirthDate());
    }

    @Test
    public void constructor_nullDeathYear_nullDeathDate() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", "CA", "Orange", null, 1, 1, "USA", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertNull(record.getDeathDate());
    }

    @Test
    public void constructor_nullDeathMonth_nullDeathDate() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", "CA", "Orange", 3000, null, 1, "USA", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertNull(record.getDeathDate());
    }

    @Test
    public void constructor_nullDeathDay_nullDeathDate() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", "CA", "Orange", 3000, 1, null, "USA", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertNull(record.getDeathDate());
    }

    @Test
    public void constructor_emptyBirthCountry_emptyBirthAddress() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "", "CA", "Orange", 3000, 1, 1, "USA", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertEquals("", record.getBirthAddress());
    }

    @Test
    public void constructor_emptyBirthState_emptyBirthAddress() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", "", "Orange", 3000, 1, 1, "USA", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertEquals("", record.getBirthAddress());
    }


    @Test
    public void constructor_emptyBirthCity_emptyBirthAddress() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", "CA", "", 3000, 1, 1, "USA", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertEquals("", record.getBirthAddress());
    }


    @Test
    public void constructor_emptyDeathCountry_emptyDeathAddress() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", "CA", "Orange", 3000, 1, 1, "", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertEquals("", record.getDeathAddress());
    }

    @Test
    public void constructor_emptyDeathState_emptyDeathAddress() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", "CA", "Orange", 3000, 1, 1, "USA", "", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertEquals("", record.getDeathAddress());
    }

    @Test
    public void constructor_emptyDeathCity_emptyDeathAddress() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", "CA", "Orange", 3000, 1, 1, "USA", "CA", "",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertEquals("", record.getDeathAddress());
    }
}
