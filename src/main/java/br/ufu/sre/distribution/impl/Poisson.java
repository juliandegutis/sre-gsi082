package br.ufu.sre.distribution.impl;

import java.util.Scanner;

import br.ufu.sre.distribution.Distribution;

public class Poisson implements Distribution {

	public static final double NEPER = 2.7182818284590452353602874;
	
	@Override
	public Double mttf(Scanner scanner) {
		
		try {
			System.out.println( "Informe o valor de lambda:" );
			double l = scanner.nextDouble();
			
			return l;
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
				System.out.println( "Informe o valor do tempo de missão em horas 't': " );
				t = scanner.nextDouble();
				if( t < 0 ) {
					System.out.println( "O valor do tempo deve ser positivo" );
				}
			} while( t < 0 );
	
			double result = Math.pow( NEPER, ( (-l) * t ) );
			
			return result;
		} catch( Exception ex ) {
			System.out.println( "Input errado." );
			scanner.next();
			return mttf( scanner );
		}
	}

	@Override
	public Double unreliability(Scanner scaner) {
		return 0d;
	}

	@Override
	public Double failureRate(Scanner scanner) {
		return 0d;
	}

	@Override
	public Double cumulativeFailureRate(Scanner scanner) {
		return 0d;
	}

}
