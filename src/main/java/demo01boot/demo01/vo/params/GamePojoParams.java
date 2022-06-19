package demo01boot.demo01.vo.params;

import demo01boot.demo01.db.pojo.GameTypePojo;
import lombok.Data;

import java.util.List;

/**
 * @author name
 * @version 1.0
 * 存储数据
 */
@Data
public class GamePojoParams {
   public Long  GameId;
   public String GameName;
   public String  GameVersion;
   public List<Integer> GameTypes;
}
