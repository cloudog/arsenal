package online.zxff.arsenal.balackwhitelist.autoconfiguration;

import online.zxff.arsenal.balackwhitelist.configration.BlackWhiteConfiguration;
import online.zxff.arsenal.balackwhitelist.service.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cloudgo on 2019/7/30 1:31.
 */
@Configuration
//@ConditionalOnClass(StarterService.class)
//@ConditionalOnProperty(prefix = "cn.sp",value = "enable",matchIfMissing = true)
@EnableConfigurationProperties(BlackWhiteConfiguration.class)
public class BlackWhiteListAutoConfiguration {
    @Autowired
    private BlackWhiteConfiguration blackWhiteConfiguration;

    @Bean
    @ConditionalOnProperty(prefix = "online.zxff.arsenal.balackwhitelist.enable",value = "true",havingValue = "true")
    public BlackListService getBlackListService(){
        return new BlackListService(blackWhiteConfiguration);
    }
}
