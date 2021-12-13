package com.ironhack.EnterpriseJavaDevelopment78.services.impl;

import com.ironhack.EnterpriseJavaDevelopment78.model.Football;
import com.ironhack.EnterpriseJavaDevelopment78.repository.FootballRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class FootballService {

    @Autowired
    private FootballRepository footballRepository;


    public void addFootball(Football football){
        footballRepository.save(football);
    }


    public List<Football> getAllFootball(){
        return footballRepository.findAll();
    }


    public ResponseEntity<Football> getTeamlById(String id) {
        Optional<Football> tutorialData = footballRepository.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    public ResponseEntity<Football> updateTeam( String id, Football team) {
        Optional<Football> footballData = footballRepository.findById(id);

        if (footballData.isPresent()) {
            Football football = footballData.get();
            football.setTeam(team.getTeam());
            football.setPosition(team.getPosition());
            football.setFoundationYear(team.getFoundationYear());
            return new ResponseEntity<>(footballRepository.save(football), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteTeam(String id) {
        try {
            footballRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
