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
			double absZ = Math.abs( z );
					
			BigDecimal i = new BigDecimal( absZ ).setScale( 1, RoundingMode.FLOOR );
			double minusTmp = i.doubleValue();
			
			i = i.multiply( new BigDecimal( 10 ) );
			
			minusTmp = absZ - minusTmp;
			BigDecimal j = new BigDecimal( minusTmp ).setScale( 2, RoundingMode.FLOOR );
			
			j = j.multiply( new BigDecimal( 100 ) );
			
					
			double normalTable = NormalDistributionTable.value( i.intValue(), j.intValue() );
	
			return ( z < 0 ? 1 - normalTable : normalTable );
		
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
			
			/** f(t) **/
			double first = 1 / ( sig * Math.sqrt( 2 * 3.1415 ) );
			double auxExp = ((-1)*(1/2)) * Math.pow((t - mi)/sig, 2);
			
			Double ft = first * Math.pow( NEPER, auxExp );
			
			/** R(t) **/
			double z = (t - mi) / sig;
			double absZ = Math.abs( z );
					
			BigDecimal i = new BigDecimal( absZ ).setScale( 1, RoundingMode.FLOOR );
			double minusTmp = i.doubleValue();
			
			i = i.multiply( new BigDecimal( 10 ) );
			
			minusTmp = absZ - minusTmp;
			BigDecimal j = new BigDecimal( minusTmp ).setScale( 2, RoundingMode.FLOOR );
			
			j = j.multiply( new BigDecimal( 100 ) );
			
					
			double rt = NormalDistributionTable.value( i.intValue(), j.intValue() );
	
			if( z < 0 ) {
				rt = 1 - rt;
			}
			
			return ft / rt;
			
			
		} catch( Exception ex ) {
			System.out.println( "Input errado." );
			scanner.next();
			return failureRate( scanner );
		}

	}

	@Override
	public Double cumulativeFailureRate(Scanner scanner) {
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
			
			double it = 0.0001;
			double sum = 0;
			while( it <= t ) {
				/** f(t) **/
				double first = 1 / ( sig * Math.sqrt( 2 * 3.1415 ) );
				double auxExp = ((-1)*(1/2)) * Math.pow((it - mi)/sig, 2);
				
				Double ft = first * Math.pow( NEPER, auxExp );
				
				/** R(t) **/
				double z = (it - mi) / sig;

				double absZ = Math.abs( z );
						
				BigDecimal i = new BigDecimal( absZ ).setScale( 1, RoundingMode.FLOOR );
				double minusTmp = i.doubleValue();
				
				i = i.multiply( new BigDecimal( 10 ) );
				
				minusTmp = absZ - minusTmp;
				BigDecimal j = new BigDecimal( minusTmp ).setScale( 2, RoundingMode.FLOOR );
				
				j = j.multiply( new BigDecimal( 100 ) );
				
				double rt;
				if( i.intValue() > 29 ) {
					rt = 0.999;
				} else {
					rt = NormalDistributionTable.value( i.intValue(), j.intValue() );
				}
						
				if( z < 0 ) {
					rt = 1 - rt;
				}

				double result = ft / rt;
				
				sum = sum + result;
				
				it = it + 0.0001;
				
			}
			
			return sum;
			
		} catch( Exception ex ) {
			System.out.println( "Input errado." );
			scanner.next();
			return failureRate( scanner );
		}
	}

}
