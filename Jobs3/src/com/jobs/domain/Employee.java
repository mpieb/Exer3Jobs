package com.jobs.domain;

public abstract class Employee extends AbsStaffMember {

	protected double grossSalaryPerMonth;
	protected double netSalaryPerMonth;
	protected double grossSalaryPerYear;
	protected double netSalaryPerYear;
	protected double irpf;
        protected double bonus;
	protected IPaymentRate paymentRate;	

	public Employee(String name, String address, String phone, double grossSalaryPerMonth,IPaymentRate paymentRate) throws Exception {
		
		super(name, address, phone);	
		
		if(grossSalaryPerMonth<0) {
			System.err.println("Salary per month cannot be less than 0");
			throw new Exception();
		}
		if(paymentRate==null) {
			System.err.println("Payment Rate must exist. It cannot be null");
			throw new Exception();
		}
		this.paymentRate=paymentRate;
		this.grossSalaryPerMonth=grossSalaryPerMonth;
	}

	
	
	public double getGrossSalaryPerMonth() {
		return grossSalaryPerMonth;
	}

	
	public void setGrossSalaryPerMonth(double grossSalaryPerMonth) {
		this.grossSalaryPerMonth = grossSalaryPerMonth;
	}


	public double getGrossSalaryPerYear() {
		return grossSalaryPerMonth*12;
	}
	
	public double getNetSalaryPerYear() {
		return netSalaryPerMonth*12;
	}


	public double getIrpf() {
		return irpf;
	}


	public IPaymentRate getPaymentRate() {
		return paymentRate;
	}


	public abstract void calculateNetSalaryPerMonth();
	
	public abstract void calculateNetSalaryPerYear();
	

	public void setPaymentRate(IPaymentRate paymentRate) {
		this.paymentRate = paymentRate;
	}

	public abstract void applyBonus();

	@Override
	public abstract void pay();



	@Override
	public String toString() {
		return "Employee [id="
				+ id + ", name=" + name + ", address=" +
                        address + ", phone=" + phone + ", totalPaid=" +
                        totalPaid + ", netSalaryPerMonth=" + netSalaryPerMonth +
                        ", netSalaryPerYear=" + netSalaryPerYear + 
                        ", bonus=" + bonus + "]";
	}

}

