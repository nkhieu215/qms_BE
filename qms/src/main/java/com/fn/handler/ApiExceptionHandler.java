package com.fn.handler;

import com.fn.qms.utils.AppLog;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorMessage handleAllExceptionAccessDenied(AccessDeniedException ex, WebRequest request) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        AppLog.error(ex);
        return new ErrorMessage("403", ex.getLocalizedMessage());
    }

    /**
     * Tất cả các Exception không được khai báo sẽ được xử lý tại đây
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage handleAllException(Exception ex, WebRequest request) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        AppLog.error(ex);
        if(ex instanceof AccessDeniedException){
            return new ErrorMessage("403", ex.getLocalizedMessage());
        }
        return new ErrorMessage("GW999", ex.getLocalizedMessage());
    }

//    /**
//     * IndexOutOfBoundsException sẽ được xử lý riêng tại đây
//     */
//    @ExceptionHandler(ErrorResponse.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public ErrorMessage TodoException(ErrorResponse ex, WebRequest request) {
//        return new ErrorMessage(ex.getMessages().getCode(), ex.getMessages().getMessage());
//    }
}
