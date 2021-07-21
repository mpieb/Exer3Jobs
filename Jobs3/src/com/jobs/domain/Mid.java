package com.jobs.domain;

import exceptions.SueldoMidException;

public class Mid extends Employee{
	
	protected IPaymentRate paymentRate;	
	
	public Mid(String name, String address, String phone, double grossSalaryPerMonth, IPaymentRate paymentRate) throws Exception {
		
		super(name, address, phone, grossSalaryPerMonth, paymentRate);
		
		irpf = 0.15;
		
		calculateNetSalaryPerMonth();
		calculateNetSalaryPerYear();
		applyBonus();
		
		if(grossSalaryPerMonth<1800 || grossSalaryPerMonth>2500) throw new SueldoMidException();
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
		return "Mid [id=" + id + ", name=" + name + ", address=" +
                        address + ", phone=" + phone + ", netSalaryPerMonth=" +
                        netSalaryPerMonth + ", netSalaryPerYear=" +
                        netSalaryPerYear + ", bonus=" + bonus + "]";
	}


	@Override
	public void applyBonus() {
		bonus += (netSalaryPerYear*0.1); 
        }
	
}

   




