package demo01boot.demo01.db.mapper;

import demo01boot.demo01.db.pojo.GameTypePojo;
import demo01boot.demo01.db.pojo.GameTypeTagsPojo;

/**
 * @author name
 * @version 1.0
 */
public interface GameTypeMapper {
    //根据Game_id查询标签json数据
    String getGameIdByGameAllTags(Long gameId);

    //根据标签id查询单个type全部信息
    GameTypePojo selectTypeIdByPojo(Integer typeId);

    //插入数据
    boolean  insertGameTypes(GameTypeTagsPojo pojo);

    //更新数据
    boolean updateGameTypes(Long game_id,String tagsId);


}
