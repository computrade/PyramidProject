package com.example.pyramid.algorithm;

/**
 * Better version of the {@link IterativeHumanEdgeWeightStrategy} algorithm. 
 * Keeps in memory just the levels useful to the computation.
 * 
 */
public class BetterIterativeHumanEdgeWeightStrategy implements HumanEdgeWeightStrategy {

	@Override
	public double getHumanWeight(int level, int index, double weight) {
		
		double[] previousLevel = new double[1];
		
		for (int l = 1; l <= level; l++) {
			double[] currentLevel = new double[l + 1];
			for (int i = 0; i < previousLevel.length; i++) {
				currentLevel[i] += (previousLevel[i] + weight) / 2;
				currentLevel[i + 1] += (previousLevel[i] + weight) / 2;
			}
			previousLevel = currentLevel;
		}
		
		return previousLevel[index];
	}

	@Override
	public double getHumanEdgeWeight(int level, double weight) {
		
		double[] previousLevel = new double[1];
		
		for (int l = 1; l <= level; l++) {
			double[] currentLevel = new double[l + 1];
			for (int i = 0; i < previousLevel.length; i++) {
				currentLevel[i] += (previousLevel[i] + weight) / 2;
				currentLevel[i + 1] += (previousLevel[i] + weight) / 2;
			}
			previousLevel = currentLevel;
		}
		
		return previousLevel[0];
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BetterIterativeHumanEdgeWeightStrategy []");
		return builder.toString();
	}


}
