package api.medicine.art.regimen.impl;

import api.medicine.art.regimen.RegimenFactoryService;
import api.medicine.art.regimen.RegimenService;
import metadata.RegimenNameMetaData;

public class RegimenFactoryImplementation implements RegimenFactoryService {
    @Override
    public RegimenService getRegimen(String regimenName) {
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_0A)){
            return new Regimen0A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_0P)){
            return new Regimen0P();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_2A)){
            return new Regimen2A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_2P)){
            return new Regimen2P();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_4A)){
            return new Regimen4A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_4P)){
            return new Regimen4P();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_5A)){
            return new Regimen5A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_6A)){
            return new Regimen6A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_7A)){
            return new Regimen7A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_8A)){
            return new Regimen8A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_9P)){
            return new Regimen9P();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_9A)){
            return new Regimen9A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_10A)){
            return new Regimen10A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_11A)){
            return new Regimen11A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_11P)){
            return new Regimen11P();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_12A)){
            return new Regimen12A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_13A)){
            return new Regimen13A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_14A)){
            return new Regimen14A();
        }
        if(regimenName.equals(RegimenNameMetaData.REGIMEN_15A)){
            return new Regimen15A();
        }
        return null;
    }
}
