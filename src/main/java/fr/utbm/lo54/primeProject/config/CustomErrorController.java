package fr.utbm.lo54.primeProject.config;

import fr.utbm.lo54.primeProject.config.exception.ForbiddenException;
import fr.utbm.lo54.primeProject.config.exception.InternalErrorException;
import fr.utbm.lo54.primeProject.config.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Scorp on 13/06/2017.
 */
@Controller
public class CustomErrorController extends AbstractErrorController {
    private static final String ERROR_PATH=  "/error";

    @Autowired
    public CustomErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    /**
     * Just catching the {@linkplain NotFoundException} exceptions and render
     * the 404.jsp error page.
     */
    @ExceptionHandler(NotFoundException.class)
    public String notFound() {
        return "error/404.xhtml";
    }

    @ExceptionHandler(InternalErrorException.class)
    public String internalError() {
        return "error/500.xhtml";
    }

    @ExceptionHandler(ForbiddenException.class)
    public String forbidden() {
        return "error/403.xhtml";
    }

    /**
     * Responsible for handling all errors and throw especial exceptions
     * for some HTTP status codes. Otherwise, it will return a map that
     * ultimately will be converted to a json error.
     */
    @RequestMapping(ERROR_PATH)
    public ResponseEntity<?> handleErrors(HttpServletRequest request) {
        HttpStatus status = getStatus(request);

        if (status.equals(HttpStatus.NOT_FOUND)){
            throw new NotFoundException();
        } else if (status.equals(HttpStatus.INTERNAL_SERVER_ERROR)){
            throw new InternalErrorException();
        } else if (status.equals(HttpStatus.FORBIDDEN)){
            throw new ForbiddenException();
        }

        return ResponseEntity.status(status).body(getErrorAttributes(request, false));
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
