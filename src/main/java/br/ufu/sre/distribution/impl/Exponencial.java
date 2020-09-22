package br.ufu.sre.distribution.impl;

import java.util.Scanner;

import br.ufu.sre.distribution.Distribution;

public class Exponencial implements Distribution {

	public static final double NEPER = 2.7182818284590452353602874;
	
	@Override
	public Double mttf(Scanner scanner) {
		try {
			System.out.println( "Informe o valor de lambda: " );
			double l = scanner.nextDouble();
			return 1 / l;	
		} catch( Exception ex ) {
			System.out.println( "Input errado." );
			scanner.next();
			return mttf( scanner );
		}
	}

	@Override
	public Double reliability(Scanner scanner) {
		try {
			
			System.out.println( "Informe o valor de lambda: " );
			double l = scanner.nextDouble();
			
			double t;
			do {
				System.out.println( "Informe o valor de t: " );
				t = scanner.nextDouble();
				if( t <= 0 ) {
					System.out.println( "O valor do tempo deve ser > 0. " );
				}
			} while( t <= 0 );
	
			double result = Math.pow( NEPER, ( (-l) * t ) );
			
			return result;
		} catch( Exception ex ) {
			System.out.println( "Input errado." );
			scanner.next();
			return reliability( scanner );
		}
	}

	@Override
	public Double unreliability(Scanner scaner) {
		// TODO Auto-generated method stub
		return 0d;
	}

	@Override
	public Double failureRate(Scanner scanner) {
		try {
			System.out.println( "Informe o valor de lambda: " );
			double l = scanner.nextDouble();
			return l;
		} catch( Exception ex ) {
			System.out.println( "Input errado." );
			scanner.next();
			return failureRate( scanner );
		}
	}

	@Override
	public Double cumulativeFailureRate(Scanner scanner) {
		
		try {	
			System.out.println( "Informe o valor de lambda: " );
			double l = scanner.nextDouble();
			
			double t;
			do {
				System.out.println( "Informe o tempo de missão t: " );
				t = scanner.nextDouble();
				if( t < 0 ) {
					System.out.println( "O valor do tempo deve ser poisitivo." );
				}
			} while( t < 0 );
			
			return l * t;
			
		} catch( Exception ex ) {
			System.out.println( "Input errado." );
			scanner.next();
			return cumulativeFailureRate( scanner );
		}
	}

}
