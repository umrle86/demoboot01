package demo01boot.demo01.vo.params;

import lombok.Data;

/**
 * @author name
 * @version 1.0
 * 分页参数
 */
@Data
public class PageParams {
    public int  page;   //起始
    public int  PageSize;  //分页大小
}
