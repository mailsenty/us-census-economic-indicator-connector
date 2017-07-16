package org.mule.modules.uscensuseconomicindicator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import org.junit.Test;

public class USCensusEconomicIndicatorConnectorTest {
	
	USCensusEconomicIndicatorConnector connector = new USCensusEconomicIndicatorConnector();

	@Test
	public void testBefore() {
		System.out.println(connector.before("2004"));
	}

	@Test
	public void testAfter() {
		System.out.println(connector.after("2004"));
	}

	@Test
	public void testBetween() {
		System.out.println(connector.between("2004", "2007"));
	}

	@Test
	public void testGet() {
			System.out.println(connector.get("2004"));
		
	}

}
