package com.jobs.domain;

import exceptions.SueldoJuniorException;

public class Junior extends Employee{

	protected IPaymentRate paymentRate;	
	
	public Junior(String name, String address, String phone, double grossSalaryPerMonth, IPaymentRate paymentRate) throws Exception {
		
		super(name, address, phone, grossSalaryPerMonth, paymentRate);
		
		irpf = 0.02;
		this.paymentRate=paymentRate;
		
		calculateNetSalaryPerMonth();
		calculateNetSalaryPerYear();
		applyBonus();
		
		
		if(grossSalaryPerMonth<900 || grossSalaryPerMonth>1600) throw new SueldoJuniorException();
		if(paymentRate==null) throw new Exception("Field payment rate cannot must exist");
		
	}

	
	public IPaymentRate getPaymentRate() {
		return paymentRate;
	}

	public void setPaymentRate(IPaymentRate paymentRate) {
		this.paymentRate = paymentRate;
	}

	@Override
	public void pay() {
		totalPaid=paymentRate.pay(grossSalaryPerMonth*(1-irpf));
	}


	@Override
	public void calculateNetSalaryPerMonth() {
		netSalaryPerMonth = grossSalaryPerMonth*(1-irpf);
		
	}


	@Override
	public void calculateNetSalaryPerYear() {
		netSalaryPerYear = netSalaryPerMonth*12;
		
	}


	@Override
	public void applyBonus() {
		bonus += (netSalaryPerYear*0.1); 
	}
	

	@Override
	public String toString() {
		return "Junior [id=" + id + ", name=" + name + ", address=" +
                        address + ", phone=" + phone + ", netSalaryPerMonth=" +
                        netSalaryPerMonth + ", netSalaryPerYear=" +
                        netSalaryPerYear + ", bonus=" + bonus + "]";
	}

}

    

