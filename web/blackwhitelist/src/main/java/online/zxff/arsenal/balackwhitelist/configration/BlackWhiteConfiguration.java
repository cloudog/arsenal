package online.zxff.arsenal.balackwhitelist.configration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cloudgo on 2019/7/30 1:32.
 */
@Configuration
@ConfigurationProperties("online.zxff.arsenal.balackwhitelist")
@Data
public class BlackWhiteConfiguration {

    Integer triggerTime=10;

    Integer durationWindow=60;

    Integer expireTime=600;

    Boolean enabled;
}
