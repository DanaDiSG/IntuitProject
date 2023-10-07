package com.intuit.project.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.intuit.domain.domain.PlayerDetails;
import com.intuit.domain.domain.PlayerResponseRecord;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ReadPlayerServiceImpl implements ReadPlayerService {

    private final static String FILE_NAME = "service/src/main/resources/player.csv";
    private final static Integer FIRST_PLACE = 0;
    private final HashMap<String, PlayerDetails> playerIdToDetails;

    public ReadPlayerServiceImpl() {
        this.playerIdToDetails = new HashMap<>();
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        ObjectReader oReader = csvMapper.readerFor(PlayerDetails.class).with(schema);
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            MappingIterator<PlayerDetails> mi = oReader.readValues(br);
            while (mi.hasNext()) {
                PlayerDetails currentPlayer = mi.next();
                playerIdToDetails.putIfAbsent(currentPlayer.getPlayerID(), currentPlayer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PlayerResponseRecord> getPlayers() {
        List<PlayerResponseRecord> playerList = new ArrayList<>();
        for (PlayerDetails currentPlayer : playerIdToDetails.values()) {
            playerList.add(new PlayerResponseRecord(currentPlayer));
        }
        return playerList;
    }

    @Override
    public PlayerResponseRecord getPlayerById(String playerId) {
        return new PlayerResponseRecord(playerIdToDetails.get(playerId));
    }

    private Integer parseNum(CSVRecord record, String columnName) {
        return record.get(columnName).isEmpty() ? null : Integer.valueOf(record.get(columnName));
    }

    private Character parseChar(CSVRecord record, String columnName) {
        return record.get(columnName).isEmpty() ? null : record.get(columnName).charAt(FIRST_PLACE);
    }
}
