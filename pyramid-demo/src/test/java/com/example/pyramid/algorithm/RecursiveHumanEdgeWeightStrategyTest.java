package com.example.pyramid.algorithm;

import com.example.pyramid.algorithm.RecursiveHumanEdgeWeightStrategy;

public class RecursiveHumanEdgeWeightStrategyTest extends HumanWeightStrategyTest<RecursiveHumanEdgeWeightStrategy> {

	@Override
	protected RecursiveHumanEdgeWeightStrategy newInstance() {
		return new RecursiveHumanEdgeWeightStrategy();
	}

}
