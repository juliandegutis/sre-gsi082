package br.ufu.sre.distribution.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import br.ufu.sre.distribution.Distribution;
import br.ufu.sre.loader.NormalDistributionTable;

public class Normal implements Distribution {
	
	@Override
	public Double mttf(Scanner scanner) {
		try {
			System.out.println( "Informe a média 'mi': " );
			double m = scanner.nextDouble();
			return m;
		} catch( Exception ex ) {
			System.out.println( "Input errado." );
			scanner.next();
			return mttf( scanner );
		}
	}

	@Override
	public Double reliability(Scanner scanner) {
		
		try {
		
			System.out.println( "Informe a média 'mi': " );
			double mi = scanner.nextDouble();
			
			double sig;
			
			do {
				System.out.println( "Informe o desvio padrão 'sigma': " );
				sig = scanner.nextDouble();
				if( sig <= 0 ) {
					System.out.println( "Valor do desvio padrão deve ser positivo e maior que zero" );
				}
			} while( sig <= 0 );
			
			
			double t;
			do {
				System.out.println( "Informe o tempo de missão t: " );
				t = scanner.nextDouble();
				if( t < 0 ) {
					System.out.println( "O valor do tempo deve ser poisitivo." );
				}
			} while( t < 0 );
			
			double z = (t - mi) / sig;
					
			BigDecimal i = new BigDecimal( z ).setScale( 1, RoundingMode.FLOOR );
			double minusTmp = i.doubleValue();
			
			i = i.multiply( new BigDecimal( 10 ) );
			
			minusTmp = z - minusTmp;
			BigDecimal j = new BigDecimal( minusTmp ).setScale( 2, RoundingMode.FLOOR );
			
			j = j.multiply( new BigDecimal( 100 ) );
			
					
			double normalTable = NormalDistributionTable.value( i.intValue(), j.intValue() );
	
			return normalTable;
		
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
		// TODO Auto-generated method stub
		return 0d;
	}

	@Override
	public Double cumulativeFailureRate(Scanner scanner) {
		// TODO Auto-generated method stub
		return 0d;
	}

}
