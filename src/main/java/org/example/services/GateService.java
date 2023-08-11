package org.example.services;

import org.example.exceptions.GateNotFoundException;
import org.example.models.Gate;
import org.example.repositories.GateRepository;

import java.util.Optional;

public class GateService {
    private GateRepository gateRepository;

    public GateService(GateRepository gateRepository){
        this.gateRepository=gateRepository;
    }

    public Gate getGateById(Long gateId) throws GateNotFoundException {
        Optional<Gate> gateWrapper=gateRepository.fetchGateById(gateId);
        if(gateWrapper.isPresent()){
            return gateWrapper.get();
        }
        else{
            throw new GateNotFoundException();
        }

    }
}
