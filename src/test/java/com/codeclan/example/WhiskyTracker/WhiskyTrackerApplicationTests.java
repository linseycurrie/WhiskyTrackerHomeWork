package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskeyByYear2018(){
		List<Whisky> foundWhiskey = whiskyRepository.findByYear(2018);
		assertEquals(6, foundWhiskey.size());
	}

	@Test
	public void getDistilleriesFromRegionLowland(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Lowland");
		assertEquals(2, foundDistilleries.size());
	}

	@Test
	public void findWhiskeyByDistilleryMacallanAndYear1995(){
		Distillery dist = distilleryRepository.getOne(11L);
		List<Whisky> foundWhiskey = whiskyRepository.findWhiskysByDistilleryNameAndAge("Macallan", 25);
		assertEquals(1, foundWhiskey.size());
	}

	@Test
	public void findWhiskiesByDistilleryRegionIsland(){
		List<Whisky> foundWhiskey = whiskyRepository.findByDistilleryRegion("Islay");
		assertEquals(2, foundWhiskey.size());
	}

	@Test
	public void findDistilleriesWithWhiskiesOf12YearsOfAge(){
		List<Distillery> foundDist = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(6, foundDist.size());
	}

}
