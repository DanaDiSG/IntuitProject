package com.intuit.project.web;

import com.intuit.domain.domain.PlayerDetails;
import com.intuit.domain.domain.PlayerResponseRecord;
import com.intuit.project.service.ReadPlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = PlayerController.class)
public class PlayerControllerTest {

    @MockBean
    private ReadPlayerService readPlayerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void players_whenNoInput_thenReturns200() throws Exception {
        when(readPlayerService.getPlayers()).thenReturn(createValidResponse());
        mockMvc.perform(get("/api/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].player_id", equalTo("a1")))
                .andExpect(jsonPath("$.[0].birth_date", equalTo(LocalDate.of(1994, 7, 18).toString())))
                .andExpect(jsonPath("$.[0].birth_address", equalTo("USA, CA, Orange")))
                .andExpect(jsonPath("$.[0].name_first", equalTo("Dana")))
                .andExpect(jsonPath("$.[0].name_last", equalTo("Digmal")))
                .andExpect(jsonPath("$.[0].name_given", equalTo("Dana Digmal")))
                .andExpect(jsonPath("$.[0].weight", equalTo(70)))
                .andExpect(jsonPath("$.[0].height", equalTo(165)))
                .andExpect(jsonPath("$.[0].bats", equalTo("R")))
                .andExpect(jsonPath("$.[0].throws", equalTo("L")))
                .andExpect(jsonPath("$.[0].debut", equalTo("2000-04-01")))
                .andExpect(jsonPath("$.[0].final_game", equalTo("2002-05-04")))
                .andExpect(jsonPath("$.[0].retro_id", equalTo("dd")))
                .andExpect(jsonPath("$.[0].bbref_id", equalTo("a1")))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void playerById_whenValidInput_thenReturns200() throws Exception {
        when(readPlayerService.getPlayerById(any(String.class))).thenReturn(createValidResponse().get(0));
        mockMvc.perform(get("/api/players/a1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.player_id", equalTo("a1")))
                .andExpect(jsonPath("$.birth_date", equalTo(LocalDate.of(1994, 7, 18).toString())))
                .andExpect(jsonPath("$.birth_address", equalTo("USA, CA, Orange")))
                .andExpect(jsonPath("$.name_first", equalTo("Dana")))
                .andExpect(jsonPath("$.name_last", equalTo("Digmal")))
                .andExpect(jsonPath("$.name_given", equalTo("Dana Digmal")))
                .andExpect(jsonPath("$.weight", equalTo(70)))
                .andExpect(jsonPath("$.height", equalTo(165)))
                .andExpect(jsonPath("$.bats", equalTo("R")))
                .andExpect(jsonPath("$.throws", equalTo("L")))
                .andExpect(jsonPath("$.debut", equalTo("2000-04-01")))
                .andExpect(jsonPath("$.final_game", equalTo("2002-05-04")))
                .andExpect(jsonPath("$.retro_id", equalTo("dd")))
                .andExpect(jsonPath("$.bbref_id", equalTo("a1")))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void players_whenPlayersCSVEmpty_thenReturns404() throws Exception {
        when(readPlayerService.getPlayers()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/api/players")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void playerById_whenPlayerNoFound_thenReturns404() throws Exception {
        when(readPlayerService.getPlayerById(any(String.class))).thenReturn(null);
        mockMvc.perform(get("/api/players/a2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void players_whenThrowsException_thenReturns500() throws Exception {
        when(readPlayerService.getPlayers()).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> readPlayerService.getPlayers());
        mockMvc.perform(get("/api/players")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void playerById_whenThrowsException_thenReturns500() throws Exception {
        when(readPlayerService.getPlayerById(any(String.class))).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> readPlayerService.getPlayerById("a1"));
        mockMvc.perform(get("/api/players/a1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    private List<PlayerResponseRecord> createValidResponse() {
        return List.of(
                new PlayerResponseRecord(
                        new PlayerDetails(
                        "a1", 1994, 7, 18, "USA", "CA",
                        "Orange", null, null, null, "",
                        "", "", "Dana", "Digmal", "Dana Digmal",
                        70, 165, 'R', 'L', "2000-04-01", "2002-05-04",
                        "dd", "a1")));
    }
}