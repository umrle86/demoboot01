package demo01boot.demo01.db.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author name
 * @version 1.0
 */
@TableName("game_type_tags")
@Data
public class GameTypeTagsPojo {
    private  Long id;
    private  Long gameId;
    private  String gameTypeId;
}
