package online.zxff.arsenal.retrieval.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cloudgo on 2019/8/17 15:37.
 */
@Configuration
@ConfigurationProperties( "zxff.es.config")
public class ESClusterConfiguration {
    //ip:port,ip:port
    String address;



}
