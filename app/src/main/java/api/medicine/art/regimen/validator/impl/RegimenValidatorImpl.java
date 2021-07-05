package api.medicine.art.regimen.validator.impl;

import api.medicine.MedicineService;
import api.medicine.art.regimen.validator.RegimenValidator;
import api.medicine.weight.WeightRangeMapper;
import metadata.RegimenNameMetaData;

import java.util.ArrayList;

public class RegimenValidatorImpl implements RegimenValidator {

    @Override
    public boolean isRegimenNameValid(String regimen) {
        if(regimen.equals(RegimenNameMetaData.REGIMEN_0A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_0P)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_2A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_2P)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_4A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_4P)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_5A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_6A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_7A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_8A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_9A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_9P)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_10A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_11A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_11P)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_12A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_13A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_14A)){
            return true;
        }
        if(regimen.equals(RegimenNameMetaData.REGIMEN_15A)){
            return true;
        }
        return false;
    }

    @Override
    public String isWeightValid(double weight, ArrayList<MedicineService> drugCombination) {
        String getWeightRangeOfPatient = WeightRangeMapper.getWeightRange(weight);
        if(getWeightRangeOfPatient == null){
            return null;
        }
        return getWeightRangeOfPatient;
    }
}
