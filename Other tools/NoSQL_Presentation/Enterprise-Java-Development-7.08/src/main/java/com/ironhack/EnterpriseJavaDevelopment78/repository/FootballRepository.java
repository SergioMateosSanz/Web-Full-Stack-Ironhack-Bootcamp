package com.ironhack.EnterpriseJavaDevelopment78.repository;

import com.ironhack.EnterpriseJavaDevelopment78.model.Football;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FootballRepository extends MongoRepository<Football, String> {

}
