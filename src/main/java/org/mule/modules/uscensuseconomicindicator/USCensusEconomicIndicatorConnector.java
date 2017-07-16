package org.mule.modules.uscensuseconomicindicator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import org.mule.modules.uscensuseconomicindicator.config.ConnectorConfig;

@Connector(name="us-census-economic-indicator", friendlyName="USCensusEconomicIndicator")
public class USCensusEconomicIndicatorConnector {

    @Config
    ConnectorConfig config;
    
    String censusURL="https://api.census.gov/data/timeseries/eits/hv?get=cell_value,data_type_code,time_slot_id,category_code,seasonally_adj&time=";
    String censusTimeSeriesURL="https://api.census.gov/data/timeseries/eits/resconst?get=cell_value,data_type_code,time_slot_id,error_data,category_code,seasonally_adj&time=";
 
	
    
   

    @Processor
    public String before(String beforeyear) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
    	return processConnection(censusTimeSeriesURL+"to+"+beforeyear);
        
    }
    
    @Processor
    public String after(String fromyear) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
        return processConnection(censusTimeSeriesURL+"from+"+fromyear);
    }
    
    @Processor
    public String between(String from,String to) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
        return processConnection(censusTimeSeriesURL+"from+"+from+"to+"+to);
    }
    
    @Processor
    public String get(String year) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
    	
    	return processConnection(censusURL+year);
    			
    }
    
    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }
    
    
private String processConnection(String urlString){
    	
	URL url;
	HttpURLConnection con ;
	StringBuffer response = new StringBuffer();
    	
    	try {
    		System.out.println("urlString : " + urlString);
    		url= new URL(urlString);
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");

			// add request header
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		}  catch (Exception e) {
			response=new StringBuffer("Error getting Yoda Speak");
			e.printStackTrace();
		}

		// print result
		return response.toString();
    }


}