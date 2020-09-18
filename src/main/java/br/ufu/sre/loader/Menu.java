package br.ufu.sre.loader;

import java.util.HashMap;
import java.util.Map;

import br.ufu.sre.metric.Metric;
import br.ufu.sre.metric.impl.MajorFailureRate;
import br.ufu.sre.metric.impl.MeanTimeFailure;
import br.ufu.sre.metric.impl.MinorFailureRate;
import br.ufu.sre.metric.impl.Reliability;
import br.ufu.sre.metric.impl.Unreliability;

public class Menu {
	
	private Map< String, Metric > options;
	
	public Menu() {
		this.options = new HashMap< String, Metric >();
		this.options.put( "1", new Reliability() );
		this.options.put( "2", new Unreliability() );
		this.options.put( "3", new MeanTimeFailure() );
		this.options.put( "4", new MinorFailureRate() );
		this.options.put( "5", new MajorFailureRate() );
	}

	public Map<String, Metric> getOptions() {
		return options;
	}

	public void setOptions(Map<String, Metric> options) {
		this.options = options;
	}
	
	
}
