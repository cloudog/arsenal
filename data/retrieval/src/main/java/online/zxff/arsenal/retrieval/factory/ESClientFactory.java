package online.zxff.arsenal.retrieval.factory;

import online.zxff.arsenal.retrieval.entity.ESAddress;
import online.zxff.arsenal.retrieval.exception.RetrievalConfigParseException;
import online.zxff.arsenal.retrieval.util.ESConfigParser;
import org.apache.commons.collections4.CollectionUtils;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by cloudgo on 2019/8/17 15:25.
 */
@Component
public class ESClientFactory {
    @Value("zxff.es.config.address")
    String esAddresses;

    public Client generateESClient(){
         TransportClient client = null;
        List<ESAddress> esAddressList= ESConfigParser.convert2Adresses(esAddresses);
        Settings esSetttings=getESSettings();

        if(CollectionUtils.isEmpty(esAddressList)){
            throw new RetrievalConfigParseException("ES 连接地址至少有一个");
        }
        final TransportClient tmpClient = new PreBuiltTransportClient(esSetttings);
        esAddressList.forEach(esAddress -> {
            try {
                tmpClient.addTransportAddress(new TransportAddress(InetAddress.getByName( esAddress.getHost()),esAddress.getPort()));
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        });
        client=tmpClient;
        return client;

// on shutdown

//        client.close();
    }

    Settings getESSettings(){
        Settings settings=Settings.builder().put("",true).build();
        return settings;
    }

}
