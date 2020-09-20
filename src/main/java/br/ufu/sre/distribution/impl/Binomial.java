package br.ufu.sre.distribution.impl;

import java.util.Scanner;

import br.ufu.sre.distribution.Distribution;

public class Binomial implements Distribution {

	@Override
	public double mttf( Scanner scanner ) {
	
		System.out.println( "Informe o valor de n: " );
		double n = scanner.nextDouble();
		System.out.println( "Informe o valor de p: " );
		double p = scanner.nextDouble();
		
		return n * p;
		
	}
	
	@Override
	public double unreliability( Scanner scanner ) {
		
		System.out.println( "Informe o valor de n: " );
		double n = scanner.nextDouble();
		System.out.println( "Informe o valor de p: " );
		double p = scanner.nextDouble();
		System.out.println( "Informe o valor de x: " );
		double x = scanner.nextDouble();
		
		/**
		 *      n!
		 *    ------
		 *    x!(n - x)!
		 */
		double nFactorial = 1;
		double nTemp = n;
		for( int i = 0 ; i <= nTemp ; i++) {
			nFactorial = nFactorial * nTemp;
			nTemp = nTemp - 1;
		}
		double xFactorial = 1;
		double xTemp = x;
		for( int i = 0 ; i <= xTemp ; i++ ) {
			xFactorial = xFactorial * xTemp;
			xTemp = xTemp - 1;
		}
		double nxFactorial = 1;
		double nx = n - x;
		for( int i = 0 ; i <= nx ; i++ ) {
			nxFactorial = nxFactorial * nx;
			nx = nx - 1;
		}
		
		double n_x = nFactorial / ( xFactorial * nxFactorial );		

		/**
		 * (n x) p^x (1 - p)^(n - x)
		 */
		double result = n_x * Math.pow(p, x) * Math.pow( (1 - p), (n - x) );
		
		return result;
		
	}

	@Override
	public double reliability(Scanner scanner) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double failureRate(Scanner scanner) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double cumulativeFailureRate(Scanner scanner) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
