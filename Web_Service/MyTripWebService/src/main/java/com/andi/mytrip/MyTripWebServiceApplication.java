package com.andi.mytrip;

import com.andi.mytrip.domain.Business;
import com.andi.mytrip.domain.Tag;
import com.andi.mytrip.domain.Trip;
import com.andi.mytrip.repository.BusinessRepository;
import com.andi.mytrip.repository.TripRepository;
import com.andi.mytrip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.andi.mytrip.domain.Tag.HOTEL;

@SpringBootApplication
public class MyTripWebServiceApplication implements CommandLineRunner{

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyTripWebServiceApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

	    businessRepository.deleteAll();
        businessRepository.save(new Business("1", "restaurant1", "Atlanta", "peach tree street", 100, 100, Tag.HOTEL, 1, "123456789"));

        
    }
}
