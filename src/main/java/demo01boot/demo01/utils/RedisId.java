package demo01boot.demo01.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author name
 * @version 1.0
 * 使用redis自增长生成全局唯一id=符号+时间戳+序列化号
 */
@Component
public class RedisId {

    //生成起始时间戳
    private  static final long BEGIN_TIME=1640995200;

    //序列号的位数
    private static  final int  COUNT_BITS=32;

    StringRedisTemplate stringRedisTemplate;

    public RedisId(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate=stringRedisTemplate;
    }

    public  long getId(String key){
        //1.生成时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowTime = now.toEpochSecond(ZoneOffset.UTC);
        long time=nowTime-BEGIN_TIME;
        //2.生成序列号
        //获取当天信息
        String format = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        //根据redis自增长
        Long count = stringRedisTemplate.opsForValue().increment("id:" + key + ":" + format);
        //3.拼接并返回
        return time<<COUNT_BITS|count;
    }



    public static void main(String[] args) {
//        LocalDateTime time = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
//        long second = time.toEpochSecond(ZoneOffset.UTC);
//        System.out.println(second);

    }
}
