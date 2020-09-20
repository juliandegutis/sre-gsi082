package br.ufu.sre.distribution;

import java.util.Scanner;

public interface Distribution {
		
	double mttf( Scanner scanner );
	
	double reliability( Scanner scanner );
	
	double unreliability( Scanner scaner );
	
	double failureRate( Scanner scanner );
	
	double cumulativeFailureRate( Scanner scanner );
	
}
