package com.intuit.project.service;

import com.intuit.domain.domain.PlayerResponseRecord;

import java.util.List;

public interface ReadPlayerService {
    List<PlayerResponseRecord> getPlayers();

    PlayerResponseRecord getPlayerById(String playerId);
}
