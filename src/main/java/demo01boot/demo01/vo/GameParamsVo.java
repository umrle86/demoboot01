package demo01boot.demo01.vo;

import demo01boot.demo01.db.pojo.GameTypePojo;
import lombok.Data;

import java.util.List;

/**
 * @author name
 * @version 1.0
 */
@Data
public class GameParamsVo {
    private  Long id;
    private  Long gameId;
    private  String gameName;
    private  String gameVersion;
    private  Integer deleted;

    /**
     * 创建时间
     */
    private String create_time;
    /**
     * 最后修改时间
     */
    private String update_time;

    private List<GameTypePojo> listTag;
}
