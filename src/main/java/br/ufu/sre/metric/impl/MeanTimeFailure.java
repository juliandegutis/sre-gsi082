package br.ufu.sre.metric.impl;

import java.util.Scanner;

import br.ufu.sre.distribution.impl.Binomial;
import br.ufu.sre.distribution.impl.Poisson;
import br.ufu.sre.metric.Metric;

public class MeanTimeFailure implements Metric {

	public static final String MTTF = "MTTF";

	private Binomial binomial;
	
	private Poisson poisson;

	public MeanTimeFailure() {
		this.binomial = new Binomial();
		this.poisson = new Poisson();
	}
	
	public void requestInfo(Scanner scanner) {
		System.out.println( "Selecione a distribuição:" );
		System.out.println( "1 - Binomial" );
		System.out.println( "2 - Poisson" );

		Integer option = scanner.nextInt();

		if ( 1 == option ) {
			double result = this.binomial.mttf(scanner);
			System.out.println( "Resultado: " + result );
		} else if( 2 == option ) {
			
		}
	}
	
}
