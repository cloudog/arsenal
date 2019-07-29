package online.zxff.arsenal.balackwhitelist.service;

import com.google.common.collect.Maps;
import online.zxff.arsenal.balackwhitelist.configration.BlackWhiteConfiguration;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by cloudgo on 2019/7/30 1:30.
 */
public class BlackListService {
    Integer triggerTime=10;

    Integer durationWindow=60;

    Integer expireTime=600;

    ConcurrentMap<String,VisitInfoChain> visitInfoMap= Maps.newConcurrentMap();

    public BlackListService(BlackWhiteConfiguration blackWhiteConfiguration){
        this.durationWindow=blackWhiteConfiguration.getDurationWindow();
        this.expireTime=blackWhiteConfiguration.getExpireTime();
        this.triggerTime=blackWhiteConfiguration.getTriggerTime();
    }

    public Boolean process(String id){
        VisitInfoChain visitInfoChain=visitInfoMap.getOrDefault(id,new VisitInfoChain());
        return visitInfoChain.addVisitInfo(new VisitInfo()).isAvailable();
    }

    public class VisitInfoChain extends ArrayList<VisitInfo> {
        long availableStamp=0L;
        boolean isAvailable(){
            return this.size()<100&&(availableStamp<System.currentTimeMillis());
        }

        public VisitInfoChain addVisitInfo(VisitInfo visitInfo){
            final Long baseLine=System.currentTimeMillis()-durationWindow*1000L;
            this.forEach(visitInfo1 -> {if(visitInfo1.visitTime<baseLine){this.remove(visitInfo1);}});
            return this;
        }
    }

    public class VisitInfo{
        long visitTime;
    }
}
