package demo01boot.demo01.service;

import demo01boot.demo01.vo.Result;
import demo01boot.demo01.vo.params.GamePojoParams;
import demo01boot.demo01.vo.params.PageParams;

/**
 * @author name
 * @version 1.0
 */
public interface GameParamsService {

    Result saveGameParamsData(GamePojoParams pojoParams);

    Result  getListGame(PageParams params);

    Result updateGameData(GamePojoParams pojoParams);

    Result deleteByGameId(Long id);
}
