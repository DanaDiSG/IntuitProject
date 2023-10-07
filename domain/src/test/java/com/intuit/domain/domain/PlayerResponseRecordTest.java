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
    public void constructor_nullBirthCountry_emptyBirthAddress() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, null, "CA", "Orange", 3000, 1, 1, "USA", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertEquals("", record.getBirthAddress());
    }

    @Test
    public void constructor_nullBirthState_emptyBirthAddress() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", null, "Orange", 3000, 1, 1, "USA", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertEquals("", record.getBirthAddress());
    }


    @Test
    public void constructor_nullBirthCity_emptyBirthAddress() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", "CA", null, 3000, 1, 1, "USA", "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertEquals("", record.getBirthAddress());
    }


    @Test
    public void constructor_nullDeathCountry_emptyDeathAddress() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", "CA", "Orange", 3000, 1, 1, null, "CA", "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertEquals("", record.getDeathAddress());
    }

    @Test
    public void constructor_nullDeathState_emptyDeathAddress() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", "CA", "Orange", 3000, 1, 1, "USA", null, "Orange",
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertEquals("", record.getDeathAddress());
    }

    @Test
    public void constructor_nullDeathCity_emptyDeathAddress() {
        PlayerDetails playerDetails =
                new PlayerDetails("a1", 1980, 1, 1, "USA", "CA", "Orange", 3000, 1, 1, "USA", "CA", null,
                        "Michael", "Scott", "#1 Boss", 80, 170, 'R', 'R', "2000-01-01", "2000-01-01", "a2", "a3");
        PlayerResponseRecord record = new PlayerResponseRecord(playerDetails);
        assertEquals("", record.getDeathAddress());
    }
}
