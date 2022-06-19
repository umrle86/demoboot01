package demo01boot.demo01.db.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author name
 * @version 1.0
 */
@TableName("game_params")
@Data
public class GameParamsPojo {
    private  Long id;
    private  Long gameId;
    private  String gameName;
    private  String  gameVersion;
    private  Integer deleted;
    private Data create_time;
    private Data update_time;
}
