package com.intuit.project.web;

import com.intuit.domain.domain.PlayerResponseRecord;
import com.intuit.project.service.ReadPlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("PlayerController")
@RequestMapping("/api/players")
public class PlayerController {

    private final ReadPlayerService readPlayerService;

    public PlayerController(final ReadPlayerService readPlayerService) {
        this.readPlayerService = readPlayerService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponseRecord>> getPlayers() {
        try {
            List<PlayerResponseRecord> players = readPlayerService.getPlayers();

            if (players.isEmpty()) {
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(players, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{playerID}")
    public ResponseEntity<PlayerResponseRecord> getPlayerById(@PathVariable final String playerID) {
        try {
            PlayerResponseRecord player = readPlayerService.getPlayerById(playerID);

            if (player == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(player, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
