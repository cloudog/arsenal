package online.zxff.arsenal.retrieval.api;

import online.zxff.arsenal.retrieval.factory.ESClientFactory;
import online.zxff.arsenal.retrieval.service.CommonQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by cloudgo on 2019/8/17 16:24.
 */
@Component
public class QueryApi {
    @Autowired
    CommonQuery commonQuery;
}
