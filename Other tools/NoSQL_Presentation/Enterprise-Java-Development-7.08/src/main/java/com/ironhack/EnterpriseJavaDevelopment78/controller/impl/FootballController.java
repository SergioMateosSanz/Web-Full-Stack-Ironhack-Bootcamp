package com.ironhack.EnterpriseJavaDevelopment78.controller.impl;

import com.ironhack.EnterpriseJavaDevelopment78.model.Football;
import com.ironhack.EnterpriseJavaDevelopment78.repository.FootballRepository;
import com.ironhack.EnterpriseJavaDevelopment78.services.impl.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FootballController {

    @Autowired
    FootballService footballService;


    @PostMapping("/team")
    public ResponseEntity addFootball(@RequestBody Football football) {
        footballService.addFootball(football);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Football>> getAllFootball() {
        return ResponseEntity.ok(footballService.getAllFootball());
    }

    @GetMapping("/prueba")
    public String getPrueba(){
        return "Esto es una prueba";
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<Football> getTeamlById(@PathVariable("id") String id) {
        return footballService.getTeamlById(id);

    }

    @PutMapping("/teams/{id}")
    public ResponseEntity<Football> updateTeam(@PathVariable("id") String id, @RequestBody Football team) {
       return footballService.updateTeam(id, team);
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<HttpStatus> deleteTeam(@PathVariable("id") String id) {
        return footballService.deleteTeam(id);
    }

}

