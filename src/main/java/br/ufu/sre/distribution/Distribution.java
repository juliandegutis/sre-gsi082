package br.ufu.sre.distribution;

import java.util.Scanner;

public interface Distribution {
	
	public static final double NEPER = 2.7182818284590452353602874;
	
	Double mttf( Scanner scanner );
	
	Double reliability( Scanner scanner );
	
	Double unreliability( Scanner scaner );
	
	Double failureRate( Scanner scanner );
	
	Double cumulativeFailureRate( Scanner scanner );
	
}
