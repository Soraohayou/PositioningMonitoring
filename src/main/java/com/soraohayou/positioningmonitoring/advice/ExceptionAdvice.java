package com.soraohayou.positioningmonitoring.advice;

import com.soraohayou.positioningmonitoring.api.ApiResponse;
import com.soraohayou.positioningmonitoring.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 全局自定义业务异常处理方法
     *
     * @param e 异常
     * @return 返回对象
     */
    @ExceptionHandler(value = CustomException.class)
    public ApiResponse<Void> customExceptionHandler(CustomException e) {
        return ApiResponse.fail(801, e.getMessage());
    }

}
