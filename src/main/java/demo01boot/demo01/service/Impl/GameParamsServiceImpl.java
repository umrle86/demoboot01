package demo01boot.demo01.service.Impl;

import com.alibaba.fastjson.JSON;
import demo01boot.demo01.db.mapper.GameParamsMapper;
import demo01boot.demo01.db.mapper.GameTypeMapper;
import demo01boot.demo01.db.pojo.GameParamsPojo;
import demo01boot.demo01.db.pojo.GameTypePojo;
import demo01boot.demo01.db.pojo.GameTypeTagsPojo;
import demo01boot.demo01.service.GameParamsService;
import demo01boot.demo01.service.GameTypeService;
import demo01boot.demo01.utils.RedisId;
import demo01boot.demo01.vo.GameParamsVo;
import demo01boot.demo01.vo.Result;
import demo01boot.demo01.vo.StatusCode;
import demo01boot.demo01.vo.params.GamePojoParams;
import demo01boot.demo01.vo.params.PageParams;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.joda.time.DateTime;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author name
 * @version 1.0
 * 参数业务处理层
 */
@Log4j
@Service
public class GameParamsServiceImpl implements GameParamsService {
    @Resource
    GameParamsMapper gameParamsMapper;

    @Resource
    GameTypeService gameTypeService;

    @Resource
    GameTypeMapper gameTypeMapper;

    @Resource
    RedisId redisId;


    /**
     * 查询游戏参数信息
     * @param params  分页参数
     * @return    游戏参数全部信息
     */
    @Override
    public Result getListGame(PageParams params) {
        try {
            List<GameParamsPojo> listGames =
                    gameParamsMapper.getListGames((params.getPage()-1)*params.getPageSize(), params.getPageSize());
            List<GameParamsVo> gameParamsVos = CopeList(listGames, true);
            return Result.success(gameParamsVos);
        }catch (Exception e){
             log.error(e.getMessage());
        }
       return  Result.fail(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());

    }



    /**
     *
     * @param record  原始数据
     * @param GameTag  游戏类型参数
     * @return   规范后返回给前端的数据参数
     */
    public  List<GameParamsVo> CopeList(List<GameParamsPojo> record,boolean GameTag){

        List<GameParamsVo> gameParamsVoList = new ArrayList<>();
        for(GameParamsPojo pojo:record){
            gameParamsVoList.add(pivot(pojo,GameTag));
        }
       return gameParamsVoList;
    }

    /**
     * 将原始数据转化返回给前端数据
     * @param pojo  原pojo类
     * @param GameTag  游戏类型
     * @return       vo类
     */
    public GameParamsVo pivot(GameParamsPojo pojo,Boolean GameTag){
        GameParamsVo gameParamsVo = new GameParamsVo();
        BeanUtils.copyProperties(pojo,gameParamsVo);
        gameParamsVo.setCreate_time(new DateTime(pojo.getCreate_time()).toString("yyyy-MM-dd HH:mm"));
        gameParamsVo.setUpdate_time(new DateTime(pojo.getUpdate_time()).toString("yyyy-MM-dd HH:mm"));
        if(GameTag){
            Long gameId = pojo.getGameId();
            gameParamsVo.setListTag(gameTypeService.getGameIdByGameType(gameId));
        }
        return gameParamsVo;
    }

    /**
     *增加数据
     * @param pojoParams 前端表单传入的参数
     * @return   成功状态码200
     */
    @Override
    public Result saveGameParamsData(GamePojoParams pojoParams) {
        Long aLong = gameParamsMapper.selectByGameName(pojoParams.getGameName());
        if(aLong!=null) {
            return Result.fail(StatusCode.NAME_EXIST.getCode(),StatusCode.NAME_EXIST.getMsg());
        }

        //添加基本信息
        GameParamsPojo pojo = new GameParamsPojo();
        //通过redis自增长生成随机id
        pojo.setGameId(redisId.getId("GameId"));

        pojo.setGameName(pojoParams.getGameName());
        pojo.setGameVersion(pojoParams.getGameVersion());

        //增加tag信息
        GameTypeTagsPojo tagsPojo = new GameTypeTagsPojo();
        tagsPojo.setGameId(pojo.getGameId());
        tagsPojo.setGameTypeId(JSON.toJSONString(pojoParams.getGameTypes()));

        gameTypeMapper.insertGameTypes(tagsPojo);

        boolean insert = gameParamsMapper.insert(pojo);
        if(insert){
            return Result.success("插入数据成功");
        }
        return Result.fail(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
    }

    /**
     * 修改数据
     * @param pojoParams json表单数据
     * @return  状态码
     */
    @Override
    public Result updateGameData(GamePojoParams pojoParams) {
        Long aLong = gameParamsMapper.selectNotByGameName(pojoParams.getGameName(),pojoParams.getGameId());

        //判断是否有相同的gameName
        if(aLong!=null){
            return Result.fail(StatusCode.NAME_EXIST.getCode(), "游戏名称相同！！");
        }
        boolean update = gameParamsMapper.updateByPojo(pojoParams);

        //更新types类型信息
        boolean b = gameTypeService.updateTypes(pojoParams);

        if(update&&b){
            return Result.success("修改数据成功");
        }
        return Result.fail(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
    }

    @Override
    public Result deleteByGameId(Long id) {
        gameParamsMapper.deleteByGameId(id);
        return Result.success("删除成功");
    }

}
