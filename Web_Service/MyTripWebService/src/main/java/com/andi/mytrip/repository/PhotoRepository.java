package com.andi.mytrip.repository;

import com.andi.mytrip.domain.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PhotoRepository extends MongoRepository<Photo, String>{
    List<Photo> findByBusinessId(String BusinessId);
}
