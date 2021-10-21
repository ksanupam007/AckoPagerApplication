package com.acko.test.repository;

import com.acko.test.model.Developer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DevelopersRepository extends MongoRepository<Developer, String> {
    List<Developer> findByTeamId(String teamId);
}
