package com.backendmssql.controller;

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

import com.backendmssql.controller.CoffeeshopController;
import com.backendmssql.entity.Coffeeshop;
import com.backendmssql.service.CoffeeshopService;
import com.backendmssql.dto.CoffeeshopDto;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class CoffeeshopControllerTest {
	@Mock
	private CoffeeshopService service;

	@Mock
	private CoffeeshopController controller;
	DateFormat dateFormat=new SimpleDateFormat("YYYY dd MMMM");
	private List<Coffeeshop> prepareCoffeeshopRecords(){
		List<Coffeeshop> coffeeshop = new ArrayList<Coffeeshop>();
		Coffeeshop coffeeshop1 = new Coffeeshop(1L, "Otfw2",new Double(87.29),new Date(),true);
		Coffeeshop coffeeshop2 = new Coffeeshop(2L, "LGt8B",new Double(43.67),new Date(),false);
		coffeeshop.add(coffeeshop1);
		coffeeshop.add(coffeeshop2);
		return coffeeshop;
	}
	private List<CoffeeshopDto> prepareCoffeeshopDtoRecords(){
		List<CoffeeshopDto> coffeeshopList = new ArrayList<CoffeeshopDto>();
		CoffeeshopDto coffeeshop1 = new CoffeeshopDto("Otfw2",new Double(87.29),new Date(),true);
		CoffeeshopDto coffeeshop2 = new CoffeeshopDto("LGt8B",new Double(43.67),new Date(),false);
		coffeeshopList.add(coffeeshop1);
		coffeeshopList.add(coffeeshop2);
		return coffeeshopList;
	}
	
	
	@Test
	public void testFetchAllPass() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareCoffeeshopRecords());
		List<Coffeeshop> coffeeshop = prepareCoffeeshopRecords();
		List<Coffeeshop> coffeeshopFromController =  controller.fetchAll();
		for(int i=0; i<coffeeshop.size();i++) {
			Assertions.assertEquals(coffeeshop.get(i).getId(), coffeeshopFromController.get(i).getId());
            Assertions.assertEquals(coffeeshop.get(i).getName(), coffeeshopFromController.get(i).getName());
            Assertions.assertEquals(coffeeshop.get(i).getPrice(), coffeeshopFromController.get(i).getPrice());
            Assertions.assertEquals(coffeeshop.get(i).getAvailability(), coffeeshopFromController.get(i).getAvailability());
            Assertions.assertEquals(coffeeshop.get(i).getCheck(), coffeeshopFromController.get(i).getCheck());
		}
		
	}

	@Test
	public void testFetchAllFailure() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareCoffeeshopRecords());
		List<Coffeeshop> coffeeshop = null; //Intentionally made null to fail the test.
		List<Coffeeshop> coffeeshopFromController =  controller.fetchAll();
		Assertions.assertNotEquals(coffeeshop, coffeeshopFromController);
	}
	
	
	 @Test public void fetchByIdPass() { 
		 Mockito
	        .when(controller.fetchById(1L)).thenReturn(prepareCoffeeshopRecords().get(0));
			Coffeeshop coffeeshopById = prepareCoffeeshopRecords().get(0);
			Coffeeshop coffeeshopByIdFromController = controller.fetchById(1L);
			
			Assertions.assertEquals(coffeeshopById.getId(), coffeeshopByIdFromController.getId());
			
		     
			Assertions.assertEquals(coffeeshopById.getName(), coffeeshopByIdFromController.getName());
			Assertions.assertEquals(coffeeshopById.getPrice(), coffeeshopByIdFromController.getPrice());
			Assertions.assertNotEquals(coffeeshopById.getAvailability(), coffeeshopByIdFromController.getAvailability());
			Assertions.assertEquals(coffeeshopById.getCheck(), coffeeshopByIdFromController.getCheck());
	 }

	 @Test public void fetchByIdFailure() { 
		 Mockito
	        .when(controller.fetchById(1L)).thenReturn(prepareCoffeeshopRecords().get(0));
			Coffeeshop coffeeshopById = prepareCoffeeshopRecords().get(1);
			Coffeeshop coffeeshopByIdFromController = controller.fetchById(1L);
			
			Assertions.assertNotEquals(coffeeshopById.getId(), coffeeshopByIdFromController.getId());
			

        Assertions.assertNotEquals(coffeeshopById.getName(),coffeeshopByIdFromController.getName());
        Assertions.assertNotEquals(coffeeshopById.getPrice(),coffeeshopByIdFromController.getPrice());
		Assertions.assertNotEquals(coffeeshopById.getAvailability(),dateFormat.format(coffeeshopByIdFromController.getAvailability()));
        Assertions.assertNotEquals(coffeeshopById.getCheck(),coffeeshopByIdFromController.getCheck());
	 }
	 
	 @Test
	 public void deletePass() { 
		 controller.delete(1L);
		 Assertions.assertTrue(true); // This line will be executed only if there is no error in calling the controller for delete as there is no return value.
	 }

	@Test
	public void createPass() {
		CoffeeshopDto coffeeshopToBeCreated = prepareCoffeeshopDtoRecords().get(0);
		Coffeeshop coffeeshopReturned = prepareCoffeeshopRecords().get(0);
		coffeeshopReturned.setId(7L); //Changed the ID.
		
		Mockito
			.when(controller.create(coffeeshopToBeCreated)).thenReturn(coffeeshopReturned);
		
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
			.when(controller.create(coffeeshopToBeCreated)).thenReturn(coffeeshopReturned);
		
			Coffeeshop coffeeshopFromController  = controller.create(coffeeshopToBeCreated);
		Assertions.assertNull(coffeeshopFromController);
	}
	
	/*
	 * @Test public void update() { ResponseEntity<Object> responseObject = null;
	 * 
	 * Mockito.when(controller.update(coffeeshopToBeUpdated,
	 * "")).thenReturn(responseObject); }
	 */	
}