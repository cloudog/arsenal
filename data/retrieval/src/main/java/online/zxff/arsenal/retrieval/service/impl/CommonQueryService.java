package online.zxff.arsenal.retrieval.service.impl;

import online.zxff.arsenal.retrieval.factory.ESClientFactory;
import online.zxff.arsenal.retrieval.service.CommonQuery;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cloudgo on 2019/8/17 16:25.
 */
@Service
public class CommonQueryService implements CommonQuery {
    @Autowired
    ESClientFactory esClientFactory;

    public void test(){
        Client client=esClientFactory.generateESClient();

    }
}
