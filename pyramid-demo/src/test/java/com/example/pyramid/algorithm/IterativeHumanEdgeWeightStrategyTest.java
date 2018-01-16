package com.example.pyramid.algorithm;

import com.example.pyramid.algorithm.IterativeHumanEdgeWeightStrategy;

public class IterativeHumanEdgeWeightStrategyTest extends HumanWeightStrategyTest<IterativeHumanEdgeWeightStrategy> {

	@Override
	protected IterativeHumanEdgeWeightStrategy newInstance() {
		return new IterativeHumanEdgeWeightStrategy();
	}

}
