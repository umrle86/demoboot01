package demo01boot.demo01.Handler;

import demo01boot.demo01.vo.Result;
import demo01boot.demo01.vo.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author name
 * @version 1.0
 * 全局异常处理
 */
@ControllerAdvice
public class AllExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException(Exception ex){
        ex.printStackTrace();
        return Result.fail(StatusCode.SYSTEM_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
    }

}
