package br.ufu.sre.metric.impl;

import java.util.Scanner;

import br.ufu.sre.distribution.DistributionType;
import br.ufu.sre.metric.Metric;

public class MeanTimeFailure extends DistributionType implements Metric {

	public static final String MTTF = "MTTF";

	public MeanTimeFailure() {
		super();
	}
	
	public void requestInfo(Scanner scanner) {

		Integer option = 0;
		do {
			System.out.println( "Selecione a distribuição:" );
			System.out.println( "1 - Binomial" );
			System.out.println( "2 - Poisson" );
			System.out.println( "3 - Exponencial" );
			System.out.println( "4 - Normal" );
			System.out.println( "5 - Lognormal" );
			System.out.println( "6 - Weibull" );
	
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
			result = this.binomial.mttf( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + result );
		} else if( 2 == option ) {
			result = this.poisson.mttf( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + result );
		} else if( 3 == option ) {
			result = this.exponencial.mttf( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + result );
		} else if( 4 == option ) {
			result = this.normal.mttf( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + result );
		} else if( 5 == option ) {
			result = this.lognormal.mttf( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + result );
		} else if( 6 == option ) {
			result = this.weibull.mttf( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + result );
		} else {
			System.out.println( "Opção inválida" );
			return;
		}
	}
	
}
