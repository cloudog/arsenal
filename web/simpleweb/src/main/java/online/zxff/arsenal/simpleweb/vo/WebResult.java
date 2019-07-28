package online.zxff.arsenal.simpleweb.vo;

import lombok.Builder;
import lombok.Data;

/**
 * Created by cloudgo on 2019/7/28 16:15.
 */
@Data
@Builder
public class WebResult {
    Integer code;
    String msg;
}
