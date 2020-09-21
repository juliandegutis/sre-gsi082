package br.ufu.sre.metric.impl;

import java.text.DecimalFormat;
import java.util.Scanner;

import br.ufu.sre.distribution.DistributionType;
import br.ufu.sre.metric.Metric;

public class Reliability extends DistributionType implements Metric {

	public static final String RELIABILITY = "RELIABILITY";
	
	private DecimalFormat df = new DecimalFormat( "0.000000" );

	public Reliability() {
		super();
	}

	@Override
	public void requestInfo( Scanner scanner ) {

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
			result = this.binomial.unreliability(scanner);
			if( result == null ) return;
			System.out.println( "Resultado: " + ( 1 - result ) * 100 + "%" );
		} else if ( 2 == option ) {
			result = this.poisson.reliability( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + df.format( result * 100 ) + "%" );
		} else if( 3 == option ) {
			result = this.exponencial.reliability( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + df.format( result * 100 ) + "%" );
		} else if( 4 == option ) {
			result = this.normal.reliability( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + df.format( result * 100 ) + "%" );
		} else if( 5 == option ) {
			result = this.lognormal.reliability( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + df.format( result * 100 ) + "%" );
		} else if( 6 == option ) {
			result = this.weibull.reliability( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + df.format( result * 100 ) + "%" );
		} else if( 7 == option ) {
			result = this.gamma.reliability( scanner );
			if( result == null ) return;
			System.out.println( "Resultado: " + df.format( result * 100 ) + "%" );
		} else {
			System.out.println( "Opção inválida" );
			return;
		}

	}

}
