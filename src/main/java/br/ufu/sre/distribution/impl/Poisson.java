package br.ufu.sre.distribution.impl;

import java.util.Scanner;

import br.ufu.sre.distribution.Distribution;

public class Poisson implements Distribution {

	public static final double NEPER = 2.7182818284590452353602874;
	
	@Override
	public double mttf(Scanner scanner) {
		
		System.out.println( "Informe o valor de lambda:" );
		double l = scanner.nextDouble();
		
		return l;
	}

	@Override
	public double reliability(Scanner scanner) {
		
		System.out.println( "Informe o valor de lambda: " );
		double l = scanner.nextDouble();
		System.out.println( "Informe o valor de t: " );
		double t = scanner.nextDouble();

		double result = Math.pow( NEPER, ( (-l) * t ) );
		
		return result;
	}

	@Override
	public double unreliability(Scanner scaner) {
		return 0;
	}

	@Override
	public double failureRate(Scanner scanner) {
		return 0;
	}

	@Override
	public double cumulativeFailureRate(Scanner scanner) {
		return 0;
	}

}
