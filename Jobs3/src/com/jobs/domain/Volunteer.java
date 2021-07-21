package com.jobs.domain;

import exceptions.VolunteerEconomicHelpException;

public class Volunteer extends AbsStaffMember {

	protected String description;
	protected double economicHelp;

	public Volunteer(String name, String address, String phone, String description, double economicHelp) throws Exception {
		
		super(name, address, phone);
		this.description = description;
		this.economicHelp = economicHelp;
		totalPaid+=economicHelp;
		
		if(description.equals("")) {
			System.err.println("Description cannot be an empty field");
			throw new Exception();
		}
		if(economicHelp<0) {
			System.err.println("Economic help field cannot be less than 0");
		}
		if(economicHelp>300) {
			throw new VolunteerEconomicHelpException();
		}
		
	}

	
	
	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public void pay() {
		this.totalPaid = this.economicHelp;
		
	}
	@Override
	public String toString() {
		return "Volunteer [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", description= " + description
				+ ", totalPaid=" + totalPaid + "]";
	}

}

   

