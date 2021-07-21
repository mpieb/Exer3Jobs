package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double grossSalaryPerMonth) {
				return grossSalaryPerMonth*1.5;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateManager() {
		return new IPaymentRate() {
			@Override
			public double pay(double grossSalaryPerMonth) {
				return grossSalaryPerMonth*1.10;
			}
			
		};
	}
	
	public static IPaymentRate createPaymentRateJunior() {
		return new IPaymentRate() {
			@Override
			public double pay(double grossSalaryPerMonth) {
				return grossSalaryPerMonth*0.85;
			}
			
		};
	}
	
	public static IPaymentRate createPaymentRateMid() {
		return new IPaymentRate() {
			@Override
			public double pay(double grossSalaryPerMonth) {
				return grossSalaryPerMonth*0.9;
			}
			
		};
	}
	
	public static IPaymentRate createPaymentRateSenior() {
		return new IPaymentRate() {
			@Override
			public double pay(double grossSalaryPerMonth) {
				return grossSalaryPerMonth*0.95;
			}
			
		};
	}
}

    


