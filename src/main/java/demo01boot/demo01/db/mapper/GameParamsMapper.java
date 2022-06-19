package demo01boot.demo01.db.mapper;


import demo01boot.demo01.db.pojo.GameParamsPojo;
import demo01boot.demo01.vo.params.GamePojoParams;

import java.util.List;

/**
 * @author name
 * @version 1.0
 */

public interface GameParamsMapper  {
    List<GameParamsPojo> getListGames(int size,int PageSize);

    boolean  insert(GameParamsPojo pojo);
    //根据gameName查找id
    Long  selectByGameName(String gameName);

    //查找除了当前gameName之外的id
    Long selectNotByGameName(String gameName,Long gameId);

    boolean  updateByPojo(GamePojoParams pojoParams);

    boolean deleteByGameId(Long gameId);
}
