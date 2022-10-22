package com.jfwf.core.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@UtilityClass
public class HttpServletUtils {

    public String getRequestPath(HttpServletRequest request) {
        return Optional.ofNullable(request)
                .map(HttpServletRequest::getServletPath)
                .map(StringUtils::defaultString)
                .orElse(StringUtils.EMPTY);
    }

    public boolean requestPathMatches(HttpServletRequest request, String regex) {
        return Optional.ofNullable(regex)
                .map(regex_ -> getRequestPath(request).matches(regex_))
                .orElse(false);
    }

    public void putToInputStreamToResponse(HttpServletResponse response, String mediaType, int status, InputStream inputStream) throws IOException {
        response.setContentType(mediaType);
        response.setStatus(status);
        IOUtils.copy(inputStream, response.getOutputStream());
    }

    public void putInputStreamToSuccessfulResponse(HttpServletResponse response, String mediaType, InputStream inputStream) throws IOException {
        putToInputStreamToResponse(response, mediaType, HttpServletResponse.SC_OK, inputStream);
    }

    public void putExceptionToResponse(HttpServletResponse response, Throwable throwable) throws IOException {
        putToInputStreamToResponse(response, MediaType.TEXT_PLAIN_VALUE, HttpServletResponse.SC_BAD_REQUEST, IOUtils.toInputStream(ExceptionUtils.getStackTrace(throwable)));
    }

}
