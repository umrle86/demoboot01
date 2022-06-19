package demo01boot.demo01.vo;

/**
 * @author name
 * @version 1.0
 */
public enum StatusCode {
    PARAMS_ERROR(-1,"请求参数有误"),
    NAME_EXIST(20001,"已经有相同的游戏名称"),
    SYSTEM_ERROR(-999,"系统出错！");

    private final int  code;
    private final String msg;

    StatusCode(int code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


}
