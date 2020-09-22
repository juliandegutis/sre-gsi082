package br.ufu.sre.distribution.impl;

import java.util.Scanner;

import org.apache.commons.math3.special.Gamma;

import br.ufu.sre.distribution.Distribution;

public class Weibull implements Distribution {

	public static final double NEPER = 2.7182818284590452353602874;
	
	@Override
	public Double mttf(Scanner scanner) {

		try {
		
			System.out.println( "Digite o valor de alpha: " );
			double a = scanner.nextDouble();
			System.out.println( "Digite o valor de beta: " );
			double b = scanner.nextDouble();
			
			double aux = (1 / b) + 1;
			
			double result = a * Gamma.gamma( aux );
			
			return result;
		
		} catch( Exception ex ) {
			System.out.println( "Input errado." );
			scanner.next();
			return mttf( scanner );
		}
		
	}

	@Override
	public Double reliability(Scanner scanner) {
		
		try {
		
			Integer option = 0;
	
			System.out.println( "Selecione o tipo de distribuição:" );
			System.out.println( "1 - Bi-paramétrica" );
			System.out.println( "2 - Tri-paramétrica" );
	
			option = scanner.nextInt();
	
			System.out.println( "Digite o valor de alpha: " );
			double a = scanner.nextDouble();
			System.out.println( "Digite o valor de beta: " );
			double b = scanner.nextDouble();
			
			double t;
			do {
				System.out.println( "Digite o valor do tempo de missão em horas (t): " );
				t = scanner.nextDouble();
				if( t < 0 ) {
					System.out.println( "O tempo de missão deve ser > 0" );
				}
			} while( t <= 0 );
	
			
			double result = 0;
			if( 1 == option ) {	
				
				/* -(t/a) ^ b */
				double aux = (-1) * Math.pow( (t/a), b );
				
				result = Math.pow( NEPER, aux );
				
			} else if( 2 == option ) {
				
				double g;
				do {
					System.out.println( "Digite o valor de gamma: " );
					g = scanner.nextDouble();
					if( g < 0 ) {
						System.out.println( "O valor de gamma deve ser > 0" );
					}
				} while( g < 0 );
				
				/* -(t/a) ^ b */
				double aux = (-1) * Math.pow( ( ( t - g ) / a ), b );
				
				result = Math.pow( NEPER, aux );
				
			}
	
			return result;
		
		} catch( Exception ex ) {
			System.out.println( "Input errado." );
			scanner.next();
			return reliability( scanner );
		}
	}

	@Override
	public Double unreliability(Scanner scaner) {
		return 0d;
	}

	@Override
	public Double failureRate(Scanner scanner) {
		
		try {
			
			Integer option = 0;
			
			System.out.println( "Selecione o tipo de distribuição:" );
			System.out.println( "1 - Bi-paramétrica" );
			System.out.println( "2 - Tri-paramétrica" );
	
			option = scanner.nextInt();
			
			System.out.println( "Digite o valor de alpha: " );
			double a = scanner.nextDouble();
			System.out.println( "Digite o valor de beta: " );
			double b = scanner.nextDouble();
			
			double t;
			do {
				System.out.println( "Digite o valor do tempo de missão em horas (t): " );
				t = scanner.nextDouble();
				if( t < 0 ) {
					System.out.println( "O tempo de missão deve ser > 0" );
				}
			} while( t <= 0 );
			
			double result = 0;
			if( 1 == option ) {	
			
				result = ( b * Math.pow( t, ( b - 1 ) ) ) / Math.pow(a, b);
				
			} else if( 2 == option ) {
				double g;
				do {
					System.out.println( "Digite o valor de gamma: " );
					g = scanner.nextDouble();
					if( g < 0 ) {
						System.out.println( "O valor de gamma deve ser > 0" );
					}
				} while( g < 0 );
				
				result = ( b * Math.pow( (t - g), ( b - 1 ) ) ) / Math.pow(a, b);
				
			} else {
				return null;
			}
			
			return result;
			
		} catch( Exception ex ) {
			System.out.println( "Input errado." );
			scanner.next();
			return failureRate( scanner );
		}
		
	}

	@Override
	public Double cumulativeFailureRate(Scanner scanner) {
		
		try {
			
			Integer option = 0;
			
			System.out.println( "Selecione o tipo de distribuição:" );
			System.out.println( "1 - Bi-paramétrica" );
			System.out.println( "2 - Tri-paramétrica" );
	
			option = scanner.nextInt();
			
			System.out.println( "Digite o valor de alpha: " );
			double a = scanner.nextDouble();
			System.out.println( "Digite o valor de beta: " );
			double b = scanner.nextDouble();
			
			double t;
			do {
				System.out.println( "Digite o valor do tempo de missão em horas (t): " );
				t = scanner.nextDouble();
				if( t < 0 ) {
					System.out.println( "O tempo de missão deve ser > 0" );
				}
			} while( t <= 0 );
			
			double result = 0;
			if( 1 == option ) {	
			
				double i = 0.001;
				while( i <= t ) {
					result = result + ( b * Math.pow( i, ( b - 1 ) ) ) / Math.pow(a, b);
					i = i + 0.001;
				}
				
			} else if( 2 == option ) {
				double g;
				do {
					System.out.println( "Digite o valor de gamma: " );
					g = scanner.nextDouble();
					if( g < 0 ) {
						System.out.println( "O valor de gamma deve ser > 0" );
					}
				} while( g < 0 );
				
				double i = 0.000;
				while( i <= t ) {
					result = result + ( b * Math.pow( (i - g), ( b - 1 ) ) ) / Math.pow(a, b);		
					i = i + 0.001;
				}
					
			} else {
				return null;
			}
			
			return result;
			
		} catch( Exception ex ) {
			System.out.println( "Input errado." );
			scanner.next();
			return cumulativeFailureRate( scanner );
		}
		
	}

}
