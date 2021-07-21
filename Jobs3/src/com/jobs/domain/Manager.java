package com.jobs.domain;

import exceptions.SueldoManagerException;

public class Manager extends Employee{
	
	protected IPaymentRate paymentRate;	
	
	public Manager(String name, String address, String phone, double grossSalaryPerMonth, IPaymentRate paymentRate) throws Exception {
		
		super(name, address, phone, grossSalaryPerMonth, paymentRate);
		
		irpf = 0.26;

		calculateNetSalaryPerMonth();
		calculateNetSalaryPerYear();
		applyBonus();
		
		if(grossSalaryPerMonth<3000 || grossSalaryPerMonth>5000) throw new SueldoManagerException();
		if(paymentRate==null) throw new Exception();
		
		this.paymentRate=paymentRate;
	}


	public IPaymentRate getPaymentRate() {
		return paymentRate;
	}



	public void setPaymentRate(IPaymentRate paymentRate) {
		this.paymentRate = paymentRate;
	}



	@Override
	public void pay() {
		totalPaid=paymentRate.pay(grossSalaryPerMonth*irpf);
	}



	@Override
	public void calculateNetSalaryPerMonth() {
		netSalaryPerMonth = grossSalaryPerMonth*(1-irpf);
		
	}


	@Override
	public void calculateNetSalaryPerYear() {
		netSalaryPerYear = grossSalaryPerMonth*(1-irpf)*12;
		
	}
	
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", address=" +
                        address + ", phone=" + phone + ", netSalaryPerMonth=" +
                        netSalaryPerMonth + ", netSalaryPerYear=" +
                        netSalaryPerYear + ", bonus=" + bonus + "]";
	}


	@Override
	public void applyBonus() {
		bonus += (netSalaryPerYear*0.1); 
        }

}

   


