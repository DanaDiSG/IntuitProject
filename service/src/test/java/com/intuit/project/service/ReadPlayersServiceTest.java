//package com.intuit.project.service;
//
//import com.fasterxml.jackson.databind.MappingIterator;
//import com.fasterxml.jackson.databind.ObjectReader;
//import com.fasterxml.jackson.dataformat.csv.CsvMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvSchema;
//import com.intuit.domain.domain.PlayerDetails;
//import com.intuit.domain.domain.PlayerResponseRecord;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockedConstruction;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.mockConstruction;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class ReadPlayersServiceTest {
//
//    @Mock
//    private ObjectReader objectReader;
//
//    @Mock
//    private MappingIterator<PlayerDetails> mappingIterator;
//
//
//    @InjectMocks
//    private ReadPlayerServiceImpl readPlayerServiceImpl;
//
//    @Test
//    public void getPlayers_() throws IOException {
//        CsvMapper csvMapper= new CsvMapper();
//        ObjectReader oReader = csvMapper.readerFor(PlayerDetails.class);
//        MockedConstruction<CsvMapper> mockedCM = mockConstruction(CsvMapper.class,
//                (mock, context) -> {
//            when(mock.readerFor(PlayerDetails.class)).thenReturn(oReader);
//                });
//        MockedConstruction<FileReader> mocked = mockConstruction(FileReader.class);
////        MockedConstruction<BufferedReader> mockedBR = mockConstruction(BufferedReader.class,
////                (mock, context) -> {
////                });
//        when(objectReader.readValues(any(BufferedReader.class))).thenReturn(MappingIterator.emptyIterator());
//        when(mappingIterator.hasNext()).thenReturn(true);
//        when(mappingIterator.next()).thenReturn(new PlayerDetails());
//
//
//        List<PlayerResponseRecord> playerList = readPlayerServiceImpl.getPlayers();
//        assertEquals(1, playerList.size());
//    }
//
//    private PlayerDetails getPlayerDetails() {
//        return new PlayerDetails("a1", 1994, 7, 18, "USA", "CA",
//                "Orange", null, null, null, null, null, null, "Dana", "Digmal", "Dana Digmal",
//                70, 165, 'R', 'R', "2000-01-01", "2023-04-01", "dd", "a1");
//    }
//}
