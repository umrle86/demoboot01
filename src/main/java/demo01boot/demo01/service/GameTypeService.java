package demo01boot.demo01.service;

import demo01boot.demo01.db.pojo.GameTypePojo;
import demo01boot.demo01.vo.params.GamePojoParams;

import java.util.List;

/**
 * @author name
 * @version 1.0
 */
public interface GameTypeService {
    List<GameTypePojo> getGameIdByGameType(Long gameId);

    boolean updateTypes(GamePojoParams pojoParams);
}
