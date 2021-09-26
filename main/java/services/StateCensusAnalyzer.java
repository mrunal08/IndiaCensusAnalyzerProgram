package services;

import model.StatesCensusCSVModel;

import java.util.List;

public class StateCensusAnalyser {

    public static void main(String[] args) {
        CSVStateCensus csvStateCensus = new CSVStateCensus();
        List<StatesCensusCSVModel> statesCensus;
        statesCensus = csvStateCensus.readStatesCensusCsv("C:\\Users\\SAMIR\\Desktop\\F_JAVA\\IndiaCensusProgram\\src\\main\\resources\\StateCensusData.csv");
        statesCensus.forEach(System.out::println);
    }
}
