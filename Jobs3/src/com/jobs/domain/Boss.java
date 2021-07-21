package com.jobs.domain;

import exceptions.SueldoBossException;

public class Boss extends Employee{

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	
	
	public Boss(String name, String address, String phone, double grossSalaryPerMonth, IPaymentRate paymentRate) throws Exception {
		
		super(name, address, phone, grossSalaryPerMonth, paymentRate);	
		irpf = 0.32;
		
		calculateNetSalaryPerMonth();
		calculateNetSalaryPerYear();
		applyBonus();

		if(grossSalaryPerMonth<8000) throw new SueldoBossException();
		if(paymentRate==null) {
			System.err.println("Payment Rate must exist. It cannot be null");
			throw new Exception();
		}
		
		this.paymentRate=paymentRate;
		
	}

	
	
	public double getSalaryPerMonth() {
		return salaryPerMonth;
	}



	public void setSalaryPerMonth(double salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}



	public IPaymentRate getPaymentRate() {
		return paymentRate;
	}

	public void pay() {
		totalPaid=paymentRate.pay(grossSalaryPerMonth*irpf);
	}


	public void setPaymentRate(IPaymentRate paymentRate) {
		this.paymentRate = paymentRate;
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
		return "Boss [id=" + id + ", name=" + name + ", address=" +
                        address + ", phone=" + phone + ", netSalaryPerMonth=" +
                        netSalaryPerMonth + ", netSalaryPerYear=" +
                        netSalaryPerYear + ", bonus=" + bonus + "]";
	}



	@Override
	public void applyBonus() {
		bonus += (netSalaryPerYear*0.1); 
        }
	
}

    

