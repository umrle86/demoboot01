package demo01boot.demo01.db.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author name
 * @version 1.0
 */
@TableName("game_type")
@Data
public class GameTypePojo {
    private Integer   id;
    private String  gameTag;
}
