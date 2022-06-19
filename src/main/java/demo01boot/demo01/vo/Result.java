package demo01boot.demo01.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author name
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
  private boolean  success;
  private  int   code;
  private  String  msg;
  private  Object   obj;
  //成功时返回的信息
  public static  Result success(Object obj){
    return new Result(true,200,"success",obj);
  }
  //失败时返回的信息
  public static  Result fail(int code,String msg){
    return  new Result(false,code,msg,null);
  }
}
