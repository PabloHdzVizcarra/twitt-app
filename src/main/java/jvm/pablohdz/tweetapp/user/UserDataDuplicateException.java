package jvm.pablohdz.tweetapp.user;

import jvm.pablohdz.tweetapp.exception.DataDuplicateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class UserDataDuplicateException {
    @ResponseBody
    @ExceptionHandler(DataDuplicateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userDataDuplicateHandler(DataDuplicateException exception) {
        return exception.getMessage();
    }
}
