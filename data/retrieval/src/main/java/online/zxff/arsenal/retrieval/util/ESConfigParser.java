package online.zxff.arsenal.retrieval.util;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import online.zxff.arsenal.retrieval.entity.ESAddress;
import online.zxff.arsenal.retrieval.exception.RetrievalConfigParseException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cloudgo on 2019/8/17 15:43.
 */
public class ESConfigParser {

    public static List<ESAddress> convert2Adresses(String address){
        List<String> addresses=Splitter.on(",").splitToList(address);
        List<ESAddress> esAddressList=addresses.stream().map(addressStr->{
            List hostPortList=Splitter.on(":").splitToList(addressStr);
            if(null==hostPortList || hostPortList.size()!=2){
                throw new RetrievalConfigParseException("ES address config error!");
            }
            return new ESAddress(hostPortList);
        }).collect(Collectors.toList());
        return esAddressList;
    }
}
