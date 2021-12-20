package com.example.hotelapi.exceptions;

import com.example.hotelapi.exceptions.annotation.AdviserHandled;
import com.example.hotelapi.exceptions.annotation.BadRequestHandler;
import com.example.hotelapi.exceptions.models.ErrorDTO;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ControllerAdvice
@BadRequestHandler(IllegalArgumentException.class) // priorité: @AdviserHandled, @BadRequestHandler, config
public class ControllerAdviser extends ResponseEntityExceptionHandler {

    private final Set<BasicControllerExceptionHandler> handlings = new HashSet<>();


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }




    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorDTO> handle(Throwable ex){ // TODO : Quid de la requete?

        ResponseEntity<ErrorDTO> responseEntity;
        if(
                (responseEntity = handleAdviserHandler(ex)) != null
                || (responseEntity = handleBadRequestHandler(ex)) != null
                || (responseEntity = handleHandlings(ex)) != null
        ) {
            return responseEntity;
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) // 500
                .body(new ErrorDTO("une erreur inconnue s'est produite"));
    }

    public void addHandling(BasicControllerExceptionHandler handling){
        handlings.add(handling);
    }

    private ResponseEntity<ErrorDTO> handleAdviserHandler(Throwable ex){

        AdviserHandled adviserHandled = AnnotationUtils.findAnnotation(ex.getClass(), AdviserHandled.class);
        if( adviserHandled != null )
            return ResponseEntity
                    .status(adviserHandled.value())
                    .body(ErrorDTO.of(ex));

        return null;

    }
    private ResponseEntity<ErrorDTO> handleBadRequestHandler(Throwable ex){

        BadRequestHandler badRequestHandler = AnnotationUtils.findAnnotation(this.getClass(), BadRequestHandler.class);
        if( badRequestHandler != null ){
            return Arrays.stream(badRequestHandler.value())
                    .filter((exClazz) -> exClazz.isAssignableFrom(ex.getClass()))
                    .findFirst()
                    .map( (exClazz) ->
                            ResponseEntity
                                    .status(HttpStatus.BAD_REQUEST)
                                    .body(ErrorDTO.of(ex) ))
                    .orElse(null);
        }

        return null;
    }
    private ResponseEntity<ErrorDTO> handleHandlings(Throwable ex){

        return handlings.stream()
                .filter(handling -> handling.getExceptionClazz().isAssignableFrom(ex.getClass()) )
                .findFirst()
                .map((h) ->
                        ResponseEntity
                                .status( h.getStatus() )
                                .body( ErrorDTO.of(ex) ))
                .orElse(null);

    }
}
