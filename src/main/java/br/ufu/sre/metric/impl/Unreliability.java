package br.ufu.sre.metric.impl;

import java.util.Scanner;

import br.ufu.sre.distribution.impl.Binomial;
import br.ufu.sre.metric.Metric;

public class Unreliability implements Metric {

	public static final String UNRELIABILITY = "UNRELIABILITY";

	private Binomial binomial;

	public Unreliability() {
		this.binomial = new Binomial();
	}

	@Override
	public void requestInfo(Scanner scanner) {
		
		System.out.println( "Selecione a distribuição:" );
		System.out.println( "1 - Binomial" );

		Integer option = scanner.nextInt();

		if ( 1 == option ) {
			double result = this.binomial.unreliability(scanner);
			System.out.println( "Resultado: " + result );
		}	
	}
	
	
}
