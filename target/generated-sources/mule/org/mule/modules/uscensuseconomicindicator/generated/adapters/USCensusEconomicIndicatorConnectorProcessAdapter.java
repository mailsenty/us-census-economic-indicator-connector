
package org.mule.modules.uscensuseconomicindicator.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.uscensuseconomicindicator.USCensusEconomicIndicatorConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>USCensusEconomicIndicatorConnectorProcessAdapter</code> is a wrapper around {@link USCensusEconomicIndicatorConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-07-16T04:26:45-04:00", comments = "Build UNNAMED.2793.f49b6c7")
public class USCensusEconomicIndicatorConnectorProcessAdapter
    extends USCensusEconomicIndicatorConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<USCensusEconomicIndicatorConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, USCensusEconomicIndicatorConnectorCapabilitiesAdapter> getProcessTemplate() {
        final USCensusEconomicIndicatorConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,USCensusEconomicIndicatorConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, USCensusEconomicIndicatorConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, USCensusEconomicIndicatorConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
