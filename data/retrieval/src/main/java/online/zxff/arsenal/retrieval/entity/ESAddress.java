package online.zxff.arsenal.retrieval.entity;

import lombok.Data;

import java.util.List;

/**
 * Created by cloudgo on 2019/8/17 15:45.
 */
@Data
public class ESAddress {
    String host;
    Integer port;

    public ESAddress(List<String> addressList){
        this.host=addressList.get(0);
        this.port=Integer.parseInt(addressList.get(1));
    }
}
