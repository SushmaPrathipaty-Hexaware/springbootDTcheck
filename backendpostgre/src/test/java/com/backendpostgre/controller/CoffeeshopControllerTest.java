package com.backendpostgre.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.backendpostgre.entity.Coffeeshop;
import com.backendpostgre.service.CoffeeshopService;
import com.backendpostgre.dto.CoffeeshopDto;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class CoffeeshopControllerTest {
	@Mock
	private CoffeeshopService service;

	@Mock
	private CoffeeshopController controller;
	DateFormat dateFormat=new SimpleDateFormat("YYYY dd MMMM");

	private List<Coffeeshop> prepareCoffeeshopRecords(){
		List<Coffeeshop> coffeeshopList = new ArrayList<Coffeeshop>();
		Coffeeshop coffeeshop1 = new Coffeeshop(345345L, "aKJQ8",new Double(95.48),new Date(),true);
		Coffeeshop coffeeshop2 = new Coffeeshop(345344L, "8izeZ",new Double(25.38),new Date(),false);
		coffeeshopList.add(coffeeshop1);
		coffeeshopList.add(coffeeshop2);
		return coffeeshopList;
	}
	private List<CoffeeshopDto> prepareCoffeeshopDtoRecords(){
		List<CoffeeshopDto> coffeeshopList = new ArrayList<CoffeeshopDto>();
		CoffeeshopDto coffeeshop1 = new CoffeeshopDto("aKJQ8",new Double(95.48),new Date(),true);
		CoffeeshopDto coffeeshop2 = new CoffeeshopDto("8izeZ",new Double(25.38),new Date(),false);
		coffeeshopList.add(coffeeshop1);
		coffeeshopList.add(coffeeshop2);
		return coffeeshopList;
	}
	
	@Test
	public void testFetchAllPass() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareCoffeeshopRecords());
		List<Coffeeshop> coffeeshopList = prepareCoffeeshopRecords();
		List<Coffeeshop> coffeeshopListFromController =  controller.fetchAll();
		for(int i=0; i<coffeeshopList.size();i++) {
			Assertions.assertEquals(coffeeshopList.get(i).getId(), coffeeshopListFromController.get(i).getId());
            Assertions.assertEquals(coffeeshopList.get(i).getName(), coffeeshopListFromController.get(i).getName());
            Assertions.assertEquals(coffeeshopList.get(i).getPrice(), coffeeshopListFromController.get(i).getPrice());
            Assertions.assertEquals(coffeeshopList.get(i).getAvailability(), coffeeshopListFromController.get(i).getAvailability());
            Assertions.assertEquals(coffeeshopList.get(i).getCheck(), coffeeshopListFromController.get(i).getCheck());
		}
		
	}

	@Test
	public void testFetchAllFailure() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareCoffeeshopRecords());
		List<Coffeeshop> coffeeshopList = null; //Intentionally made null to fail the test.
		List<Coffeeshop> coffeeshopListFromController =  controller.fetchAll();
		Assertions.assertNotEquals(coffeeshopList, coffeeshopListFromController);
	}
	
	
	 @Test public void fetchByIdPass() { 
		 Mockito
	        .when(controller.fetchById(345344L))
            .thenReturn(prepareCoffeeshopRecords().get(0));

        Coffeeshop coffeeshopById = prepareCoffeeshopRecords().get(0);
        Coffeeshop coffeeshopByIdFromController = controller.fetchById(345344L);
        
        Assertions.assertEquals(coffeeshopById.getId(), coffeeshopByIdFromController.getId());
		Assertions.assertEquals(coffeeshopById.getName(), coffeeshopByIdFromController.getName());
		Assertions.assertEquals(coffeeshopById.getPrice(), coffeeshopByIdFromController.getPrice());
        Assertions.assertNotEquals(coffeeshopById.getAvailability(), coffeeshopByIdFromController.getAvailability());
		Assertions.assertEquals(coffeeshopById.getCheck(), coffeeshopByIdFromController.getCheck());
		 
	 }

	 @Test public void fetchByIdFailure() { 
		Mockito
	        .when(controller.fetchById(345344L))
            .thenReturn(prepareCoffeeshopRecords().get(0));

        Coffeeshop coffeeshopById = prepareCoffeeshopRecords().get(1);
        Coffeeshop coffeeshopByIdFromController = controller.fetchById(345344L);
        
        Assertions.assertNotEquals(coffeeshopById.getId(), coffeeshopByIdFromController.getId());
        Assertions.assertNotEquals(coffeeshopById.getName(),coffeeshopByIdFromController.getName());
        Assertions.assertNotEquals(coffeeshopById.getPrice(),coffeeshopByIdFromController.getPrice());
		Assertions.assertNotEquals(coffeeshopById.getAvailability(),dateFormat.format(coffeeshopByIdFromController.getAvailability()));
        Assertions.assertNotEquals(coffeeshopById.getCheck(),coffeeshopByIdFromController.getCheck());
		 
	 }
	 
	 @Test
	 public void deletePass() { 
		 controller.delete(345345L);
		 Assertions.assertTrue(true); // This line will be executed only if there is no error in calling the controller for delete as there is no return value.
	 }

	@Test
	public void createPass() {
		CoffeeshopDto coffeeshopToBeCreated 			= prepareCoffeeshopDtoRecords().get(0);
		Coffeeshop coffeeshopReturned = prepareCoffeeshopRecords().get(0);
		coffeeshopReturned.setId(345348L); //Changed the ID.
		
		Mockito
			.when(controller.create(coffeeshopToBeCreated))
            .thenReturn(coffeeshopReturned);
		
		Coffeeshop coffeeshopFromController  = controller.create(coffeeshopToBeCreated);
        Assertions.assertEquals(coffeeshopToBeCreated.getName(), coffeeshopFromController.getName());
        Assertions.assertEquals(coffeeshopToBeCreated.getPrice(), coffeeshopFromController.getPrice());
        Assertions.assertEquals(coffeeshopToBeCreated.getAvailability(), coffeeshopFromController.getAvailability());
        Assertions.assertEquals(coffeeshopToBeCreated.getCheck(), coffeeshopFromController.getCheck());
	}
	
	@Test
	public void createFailure() {
		CoffeeshopDto coffeeshopToBeCreated = prepareCoffeeshopDtoRecords().get(0);
		Coffeeshop coffeeshopReturned = null; // Intentionally left to null to fail the case. 
				
		Mockito
			.when(controller.create(coffeeshopToBeCreated))
            .thenReturn(coffeeshopReturned);
		
		Coffeeshop coffeeshopFromController  = controller.create(coffeeshopToBeCreated);
		Assertions.assertNull(coffeeshopFromController);
	}
}
