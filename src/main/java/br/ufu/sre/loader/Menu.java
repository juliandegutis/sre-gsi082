package br.ufu.sre.loader;

import java.util.HashMap;
import java.util.Map;

import br.ufu.sre.metric.Metric;
import br.ufu.sre.metric.impl.CumulativeFailureRate;
import br.ufu.sre.metric.impl.FailureRate;
import br.ufu.sre.metric.impl.MeanTimeFailure;
import br.ufu.sre.metric.impl.Reliability;
import br.ufu.sre.metric.impl.Unreliability;

public class Menu {
	
	private Map< Integer, Metric > options;
	
	public Menu() {
		this.options = new HashMap< Integer, Metric >();
		this.options.put( 1, new Reliability() );
		this.options.put( 2, new Unreliability() );
		this.options.put( 3, new MeanTimeFailure() );
		this.options.put( 4, new FailureRate() );
		this.options.put( 5, new CumulativeFailureRate() );
	}

	public Map<Integer, Metric> getOptions() {
		return options;
	}

	public void setOptions(Map<Integer, Metric> options) {
		this.options = options;
	}
	
	
}
