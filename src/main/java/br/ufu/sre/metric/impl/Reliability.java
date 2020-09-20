package br.ufu.sre.metric.impl;

import java.text.DecimalFormat;
import java.util.Scanner;

import br.ufu.sre.distribution.impl.Binomial;
import br.ufu.sre.distribution.impl.Poisson;
import br.ufu.sre.metric.Metric;

public class Reliability implements Metric {

	public static final String RELIABILITY = "RELIABILITY";
	
	private DecimalFormat df = new DecimalFormat( "0.000000" );

	private Binomial binomial;
	
	private Poisson poisson;

	public Reliability() {
		this.binomial = new Binomial();
		this.poisson = new Poisson();
	}

	@Override
	public void requestInfo(Scanner scanner) {

		System.out.println( "Selecione a distribuição:" );
		System.out.println( "1 - Binomial" );
		System.out.println( "2 - Poisson" );
		Integer option = scanner.nextInt();

		if ( 1 == option ) {
			double result = this.binomial.unreliability(scanner);
			System.out.println( "Resultado: " + ( 1 - result ) * 100 + "%" );
		} else if ( 2 == option ) {
			double result = this.poisson.reliability( scanner );
			System.out.println( "Resultado: " + df.format( result * 100 ) + "%" );
		}

	}

}
