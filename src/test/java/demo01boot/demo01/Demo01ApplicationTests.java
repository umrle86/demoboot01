package demo01boot.demo01;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import demo01boot.demo01.db.mapper.GameParamsMapper;
import demo01boot.demo01.db.mapper.GameTypeMapper;
import demo01boot.demo01.db.pojo.GameParamsPojo;
import demo01boot.demo01.db.pojo.GameTypePojo;
import demo01boot.demo01.db.pojo.GameTypeTagsPojo;
import demo01boot.demo01.service.GameParamsService;
import demo01boot.demo01.utils.RedisId;
import demo01boot.demo01.vo.Result;
import demo01boot.demo01.vo.params.GamePojoParams;
import demo01boot.demo01.vo.params.PageParams;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Demo01ApplicationTests {
    @Autowired
    GameParamsService gameParamsService;

    @Autowired
    GameTypeMapper gameTypeMapper;

    @Autowired
    GameParamsMapper gameParamsMapper;
    @Resource
    RedisId redisId;

    @Test
    void contextLoads() {
        PageParams pageParams = new PageParams();
        pageParams.setPage(1);
        pageParams.setPageSize(3);
        Result listGame = gameParamsService.getListGame(pageParams);
        System.out.println(listGame);
    }
    @Test
    void RedisId(){
        String str="GameID";
        long id = redisId.getId(str);
        System.out.println(id);
    }
    @Test
    void insertTest01(){
//        GameTypeTagsPojo tagsPojo = new GameTypeTagsPojo();
//        tagsPojo.setGameId(7896l);
//        tagsPojo.setGameTypeTags(6l);
//        gameTypeMapper.insertGameTypes(tagsPojo);
        GameTypePojo pojo1 = new GameTypePojo();
        GameTypePojo pojo2 = new GameTypePojo();
        GameTypePojo pojo3 = new GameTypePojo();
//        pojo1.setId(4L);
//        pojo2.setId(5L);
//        pojo3.setId(6L);
        List<GameTypePojo> list=new ArrayList<>();
        list.add(pojo1);
        list.add(pojo2);
        list.add(pojo3);
//        GamePojoParams gamePojoParams = new GamePojoParams();
//        gamePojoParams.setGameName("tutu");
//        gamePojoParams.setGameVersion("0.01");
//        gamePojoParams.setGameTypes(list);
//        Result result = gameParamsService.saveGameParamsData(gamePojoParams);
//        System.out.println(result);
         //gameTypeMapper.getParamById(62585803875811332L,4L);
        GamePojoParams gamePojoParams = new GamePojoParams();
        gamePojoParams.setGameId(62558273135443970L);
        gamePojoParams.setGameName("cccc");
        gamePojoParams.setGameVersion("0.01");
       // gamePojoParams.setGameTypes(list);
        //gameParamsService.updateGameData(gamePojoParams);
        //gameTypeMapper.getParamById(62558273135443970L,1L);
       //gameParamsService.deleteByGameId(62558273135443970L);
        //gameParamsMapper.selectByGameName("yui");
        List<Integer>  arr2= new ArrayList<>();
        List<Integer>  arr= Lists.newArrayList(1,3,5);
        GameTypeTagsPojo pojo4 = new GameTypeTagsPojo();
        pojo4.setGameId(66666L);
        String s = JSON.toJSONString(arr2);
//        pojo4.setGameTypeId(s);
//        gameTypeMapper.insertGameTypes(pojo4);
        System.out.println(s);
//        List<Integer> types = JSONObject.parseObject(s, new TypeReference<List<Integer>>() {});
//        for(int pojo:types)
//        System.out.println(pojo);

    }

}
