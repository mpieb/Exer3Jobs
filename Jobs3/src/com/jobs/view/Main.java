package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		
		controller.createBossEmployee("Jumbo Boss", "Caracas 2", "658253669", 13000.0);
		controller.createBossEmployee("Paca Boss", "Cuzco 8", "658234799", 12000.0);
		controller.createManagerEmployee("Tato Manager", "Molins 4", "778529238", 3500.0);
		controller.createManagerEmployee("Xusco Manager", "Pericas 2", "286547329", 3000.0);
		controller.createJuniorEmployee("Titus Junior", "Moños 14", "582186482", 1000.0);
		controller.createJuniorEmployee("Sofre Junior", "Voltes 3", "884598231", 1100.0);
		controller.createMidEmployee("Mingo Mid", "Cavall Fort 4", "610941529", 2000.0);
		controller.createMidEmployee("Tabola Mid", "Ulldemolins 56", "625266666", 2100.0);
		controller.createSeniorEmployee("Siset Senior", "Francesc Miró 8" , "636636636", 2900.0);
		controller.createSeniorEmployee("Xufo Senior", "Esperit 1" , "365233232", 3100.0);
		controller.createVolunteer("Quca Volunteer", "Tristor 4", "666666456", "No rep ajuda", 0.0);
		controller.createVolunteer("Ximo Volunteer", "Pelegrí Ballesta 4", "614266666", "Rep ajuda", 200);
		
		
		controller.payAllEmployeers();
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: " + allEmployees + " \n");
		
	}

}

    

