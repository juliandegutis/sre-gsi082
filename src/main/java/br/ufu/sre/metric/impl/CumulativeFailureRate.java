package br.ufu.sre.metric.impl;

import java.util.Scanner;

import br.ufu.sre.distribution.DistributionType;
import br.ufu.sre.metric.Metric;

public class CumulativeFailureRate extends DistributionType implements Metric {

	public static final String CUMULATIVE_FAILURE_RATE = "CUMULATIVE_FAILURE_RATE";
	
	public CumulativeFailureRate() {
		super();
	}

	public void requestInfo(Scanner scanner) {
		
		Integer option = 0;
		do {
			System.out.println( "Selecione a distribuição:" );
			System.out.println( "1 - Exponencial" );
			System.out.println( "2 - Normal" );
			System.out.println( "3 - Lognormal" );
			System.out.println( "4 - Weibull" );
	
			try {
				option = scanner.nextInt();
			} catch( Exception ex ) {
				System.out.println( "Opção inválida" );
				scanner.next();
				continue;
			}	
		} while( option == 0 );

		Double result;
		if ( 1 == option ) {
			result = this.exponencial.cumulativeFailureRate(scanner);
			if( result == null ) return;
			System.out.println( "Resultado: " + result );
		} else if ( 2 == option ) {
			result = this.normal.cumulativeFailureRate( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + result );
		} else if ( 3 == option ) {
			result = this.lognormal.cumulativeFailureRate( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + result );
		} else if ( 4 == option ) {
			result = this.weibull.cumulativeFailureRate( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + result );
		} else {
			System.out.println( "Opção inválida" );
			return;
		}
		
	}
	
}
