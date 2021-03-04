package com.au.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
@Path("ConversionService")
public class MetersInchCoversionService {

	 @GET
	     @Path("/InchToMeter/{i}")
	      @Produces(MediaType.TEXT_XML)
	      public String convertInchToMeter(@PathParam("i") int i) {
	 
	        int inch=i;
	        double meter = 0;
	        meter =(double) inch*0.0254;
	      
	        return "<InchToMeterService>"
	        + "<Inch>" + inch + "</Inch>"
	          + "<Meter>" + meter + "</Meter>"
	         + "</InchToMeterService>";
	      }
	 
	      @Path("/MeterToInch/{m}")
	      @GET
	      @Produces(MediaType.TEXT_XML)
	      public String convertMeterToInch(@PathParam("m") int m) {
	    	  double inch=0;
	          int meter = m;
	          inch = (double) 39.3701*meter;
	   
	          return "<MeterToInchService>"
	            + "<Meter>" + meter + "</Meter>"
	            + "<Inch>" + inch + "</Inch>"
	            + "</MeterToInchService>";
	      }
}
