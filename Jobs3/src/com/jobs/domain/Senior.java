package com.jobs.domain;

import exceptions.SueldoSeniorException;

public class Senior extends Employee{
	
	protected IPaymentRate paymentRate;	
	
	public Senior(String name, String address, String phone, double grossSalaryPerMonth, IPaymentRate paymentRate) throws Exception {
		
		super(name, address, phone, grossSalaryPerMonth, paymentRate);
		
		irpf = 0.24;
		
		calculateNetSalaryPerMonth();
		calculateNetSalaryPerYear();
		applyBonus();
		
		if(grossSalaryPerMonth<2700 || grossSalaryPerMonth>4000) throw new SueldoSeniorException();
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
		return "Senior [id=" + id + ", name=" + name + ", address=" +
                        address + ", phone=" + phone + ", netSalaryPerMonth=" +
                        netSalaryPerMonth + ", netSalaryPerYear=" +
                        netSalaryPerYear + ", bonus=" + bonus + "]";
	}



	@Override
	public void applyBonus() {
		bonus += (netSalaryPerYear*0.1); 
        }
	
}

    


