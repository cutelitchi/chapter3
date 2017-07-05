package com.smart.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by landy on 2017/6/30.
 */
@ControllerAdvice
public class ExeptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("e", e);
        mv.addObject("url", req.getRequestURL());
        mv.setViewName(DEFAULT_ERROR_VIEW);

        System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa==========" + req.getRequestURL());

        return mv;
    }

}
