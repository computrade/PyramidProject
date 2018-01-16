package com.example.pyramid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.pyramid.algorithm.HumanEdgeWeightStrategy;
import com.example.pyramid.services.exception.PyramidWrongIndexException;
import com.example.pyramid.services.exception.PyramidWrongLevelException;

@Component
public class PyramidWeightImpl {
		
	private final double humanWeight;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final HumanEdgeWeightStrategy humanEdgeWeightStrategy;
	
	public PyramidWeightImpl(HumanEdgeWeightStrategy humanEdgeWeightStrategy,String humanWeight ){
		this.humanEdgeWeightStrategy = humanEdgeWeightStrategy;
		this.humanWeight = Double.parseDouble(humanWeight);
		logger.info("The PyramidWeightImpl was initialized with startegy: " +humanEdgeWeightStrategy );
		logger.info("The PyramidWeightImpl was initialized with humanWeight: " +humanWeight );
	}

	public double getHumanWeight(int level, int index) {
		logger.debug("Calling getHumanWeight with level:" + level + " and index:"+ index );
		validateInput(level,index);
		validateLevel(level);
		validateIndex(index);
		return humanEdgeWeightStrategy.getHumanWeight(level, index, humanWeight);
	}
	


	public double getHumanEdgeWeight(int level) {
		logger.debug("Calling getHumanEdgeWeight with level:"+ level );
		return humanEdgeWeightStrategy.getHumanEdgeWeight(level,humanWeight);
	}
	
	private void validateInput(int level, int index) throws PyramidWrongIndexException{
		
		if(index>level){
			String msg = "The index should be less or equal to the level (input is level:" +level + " index:" + index +")";
			logger.error(msg);
			throw new PyramidWrongIndexException(msg);
		}
	}
	
	private void validateIndex(int index) {
		if(index<0){
			String msg = "The index should be non negative integer. got:" + index +")";
			logger.error(msg);
			throw new PyramidWrongIndexException(msg);
		}
	}

	private void validateLevel(int level) {
		if(level <0){
			String msg = "The level should be non negative integer. got:" + level +")";
			logger.error(msg);
			throw new PyramidWrongLevelException(msg);
		}
		
	}
	
}