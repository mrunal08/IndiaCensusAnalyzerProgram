package services;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import model.StatesCensusCSVModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class CSVStateCensus {

    public List<StatesCensusCSVModel> readStatesCensusCsv(String filePath){
        Path path = Paths.get(filePath);
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            HeaderColumnNameMappingStrategy<StatesCensusCSVModel> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(StatesCensusCSVModel.class);

            CsvToBean<StatesCensusCSVModel> csvToBean = new CsvToBeanBuilder<StatesCensusCSVModel>(br)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<StatesCensusCSVModel> statesCensus = csvToBean.parse();
            return statesCensus;
        } catch (IOException e) {
            throw new ClassCastException(e.getMessage());
        }

    }

}
