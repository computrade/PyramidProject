package com.example.pyramid.services;

public class WeightResponse {
	
	 private long id;
	 private double weight;
	 
	 	public WeightResponse() {
	      
	    }

	    public WeightResponse(long id, double weight) {
	        this.id = id;
	        this.weight = weight;
	    }

	    public long getId() {
	        return id;
	    }

	    public double getWeight() {
	        return weight;
	    }

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("WeightResponse [id=").append(id).append(", weight=").append(weight).append("]");
			return builder.toString();
		}

		
	    

}
