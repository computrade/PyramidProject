package com.example.pyramid.algorithm;

/**
 * 
 * This interface is for Pyramid project and it support 2 calculation:
 * 
 * 	1. getHumanEdgeWeight by level  - this will return how much weight the person 
 *     in the edge is carrying on his shoulders.
 *  2. getHumanWeight - by level and index - this will return how much weight the person 
 *     in the specific index is carrying on his shoulders.
 *
 * @author  Yuval Ishay
 */

public interface HumanEdgeWeightStrategy {
	
	public double getHumanEdgeWeight(int level, double weight);
	public double getHumanWeight(int level, int index, double weight);
	
	
}
