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
		// TODO Auto-generated method stub
		
	}
	
}
