package api.medicine.art.regimen.repository.impl;

import api.medicine.art.regimen.repository.RegimenRepository;
import metadata.RegimenNameMetaData;
import model.Regimen;

import java.util.ArrayList;
import java.util.List;

public class RegimenRepositoryImpl implements RegimenRepository {
    private final List<String> regimens = new ArrayList<>();
    public RegimenRepositoryImpl(){
        regimens.add(RegimenNameMetaData.REGIMEN_0P);
        regimens.add(RegimenNameMetaData.REGIMEN_0A);
        regimens.add(RegimenNameMetaData.REGIMEN_2P);
        regimens.add(RegimenNameMetaData.REGIMEN_2A);
        regimens.add(RegimenNameMetaData.REGIMEN_4P);
        regimens.add(RegimenNameMetaData.REGIMEN_4A);
        regimens.add(RegimenNameMetaData.REGIMEN_5A);
        regimens.add(RegimenNameMetaData.REGIMEN_6A);
        regimens.add(RegimenNameMetaData.REGIMEN_7A);
        regimens.add(RegimenNameMetaData.REGIMEN_8A);
        regimens.add(RegimenNameMetaData.REGIMEN_9P);
        regimens.add(RegimenNameMetaData.REGIMEN_9A);
        regimens.add(RegimenNameMetaData.REGIMEN_10A);
        regimens.add(RegimenNameMetaData.REGIMEN_11P);
        regimens.add(RegimenNameMetaData.REGIMEN_11A);
        regimens.add(RegimenNameMetaData.REGIMEN_12A);
        regimens.add(RegimenNameMetaData.REGIMEN_13A);
        regimens.add(RegimenNameMetaData.REGIMEN_14A);
        regimens.add(RegimenNameMetaData.REGIMEN_15A);
    }

    public List<String> getAllRegimens(){
        return regimens;
    }
}
