package com.example.pyramid.algorithm;

/**
 * Naive recursive implementation of the algorithm.
 * It will calculate the weight over a specific person in the human pyramid.
 * It will calculate the weight over a edge person in the human pyramid.
 */
public class RecursiveHumanEdgeWeightStrategy implements HumanEdgeWeightStrategy {

	@Override
	public double getHumanWeight(int level, int index, double weight) {
		if (level == 0) {
			return 0.0;
		} else if (index == 0) {
			return (getHumanWeight(level - 1, index, weight) + weight) / 2;
		} else if (index == level) {
			return (getHumanWeight(level - 1, index - 1, weight) + weight) / 2;
		} else {
			return weight + (getHumanWeight(level - 1, index - 1, weight) / 2) + (getHumanWeight(level - 1, index, weight) / 2);
		}
	}

	@Override
	public double getHumanEdgeWeight(int level, double weight) {
		
		if (level == 0) {
			return 0.0;
		} else {
			return (getHumanEdgeWeight(level - 1, weight) + weight) / 2;
		} 
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecursiveHumanEdgeWeightStrategy []");
		return builder.toString();
	}


}
