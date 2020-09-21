package br.ufu.sre.distribution;

import br.ufu.sre.distribution.impl.Binomial;
import br.ufu.sre.distribution.impl.Exponencial;
import br.ufu.sre.distribution.impl.Gamma;
import br.ufu.sre.distribution.impl.Lognormal;
import br.ufu.sre.distribution.impl.Normal;
import br.ufu.sre.distribution.impl.Poisson;
import br.ufu.sre.distribution.impl.Weibull;

public class DistributionType {

	protected Binomial binomial;
	protected Exponencial exponencial;
	protected Gamma gamma;
	protected Lognormal lognormal;
	protected Normal normal;
	protected Poisson poisson;
	protected Weibull weibull;
	
	protected DistributionType() {
		this.binomial = new Binomial();
		this.exponencial = new Exponencial();
		this.gamma = new Gamma();
		this.lognormal = new Lognormal();
		this.normal = new Normal();
		this.poisson = new Poisson();
		this.weibull = new Weibull();
	}
	
}
