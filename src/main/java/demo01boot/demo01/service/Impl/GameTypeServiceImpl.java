package demo01boot.demo01.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import demo01boot.demo01.db.mapper.GameTypeMapper;
import demo01boot.demo01.db.pojo.GameTypePojo;
import demo01boot.demo01.service.GameTypeService;
import demo01boot.demo01.vo.params.GamePojoParams;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author name
 * @version 1.0
 * tag信息业务处理层
 */
@Service
public class GameTypeServiceImpl implements GameTypeService {

    @Resource
    GameTypeMapper gameTypeMapper;

    /**
     * 查询types类型信息
     */
    @Override
    public List<GameTypePojo> getGameIdByGameType(Long gameId) {
        String tags = gameTypeMapper.getGameIdByGameAllTags(gameId);
        if(tags==null){
            return  null;
        }
        List<GameTypePojo> list=new ArrayList<>();
        List<Integer> integers = JSONObject.parseObject(tags, new TypeReference<List<Integer>>() {
        });
        for(int typeId:integers){
            list.add(gameTypeMapper.selectTypeIdByPojo(typeId));
        }
        return list;
    }

    /**
     * 修改type类型信息
     * @param pojoParams
     * @return 成功返回true;
     */
    @Override
    public boolean updateTypes(GamePojoParams pojoParams) {

        return gameTypeMapper.updateGameTypes(pojoParams.getGameId(),JSON.toJSONString(pojoParams.getGameTypes()));
    }
}
