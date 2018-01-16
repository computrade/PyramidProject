package com.example.pyramid.services;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pyramid.PyramidWeightImpl;

@RestController
public class WeightController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PyramidWeightImpl pyramidWeightImpl;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/pyramid/weight")
    public WeightResponse getHumanWeight(@RequestParam(value="level") int level, @RequestParam(value="index") int index) {
    	
    	logger.debug("This is a debug message from /pyramid/weight");
        return new WeightResponse(counter.incrementAndGet(),pyramidWeightImpl.getHumanWeight(level,index));
    }
    
    @RequestMapping("/pyramid/weight/edge")
    public WeightResponse getHumanWeight(@RequestParam(value="level") int level) {
    	
    	logger.debug("This is a debug message from /pyramid/weight/edge");
        return new WeightResponse(counter.incrementAndGet(),pyramidWeightImpl.getHumanEdgeWeight(level));
    }
    
}
