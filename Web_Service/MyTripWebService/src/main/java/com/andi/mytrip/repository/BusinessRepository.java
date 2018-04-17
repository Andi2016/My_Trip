package com.andi.mytrip.repository;

import com.andi.mytrip.domain.Business;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusinessRepository extends MongoRepository<Business, String>{
    Business findByBusinessId(String businessId);
    void deleteByBusinessId(String businessId);
}
