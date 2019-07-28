package online.zxff.arsenal.sso.entity;

import io.jsonwebtoken.Claims;
import lombok.Data;

/**
 * Created by cloudgo on 2019/7/28 21:25.
 */
@Data
public class CheckResult {
    Boolean success;
    Claims claims;
    Integer errCode;
}
