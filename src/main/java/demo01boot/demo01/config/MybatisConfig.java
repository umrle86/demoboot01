package demo01boot.demo01.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author name
 * @version 1.0
 */
@Configuration //标注为配置类
//@MapperScan("com.xiang.blog.mapper") //只需要全局配置一次
public class MybatisConfig {
    // mybatis分页插件
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //分页拦截器
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.H2);
        paginationInnerInterceptor.setOverflow(false);//当请求页数大于最大页时，true则跳回到首页
        paginationInnerInterceptor.setMaxLimit(500L);//每页限制500条记录
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        return interceptor;
    }
}
