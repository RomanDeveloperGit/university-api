package ru.university.demo.globalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ValidationErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
    BindingResult bindingResult = e.getBindingResult();
    ValidationErrorResponse errorResponse = createValidationErrorResponse(bindingResult);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }

  @ExceptionHandler(BindException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ValidationErrorResponse> handleBindException(BindException e) {
    BindingResult bindingResult = e.getBindingResult();
    ValidationErrorResponse errorResponse = createValidationErrorResponse(bindingResult);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }

  private ValidationErrorResponse createValidationErrorResponse(BindingResult bindingResult) {
    ValidationErrorResponse errorResponse = new ValidationErrorResponse();

    List<ValidationErrorResponse.ErrorDetail> errorDetails = bindingResult.getFieldErrors().stream()
      .map(fieldError -> new ValidationErrorResponse.ErrorDetail(
        fieldError.getField(),
        fieldError.getDefaultMessage()
      ))
      .collect(Collectors.toList());

    errorResponse.setErrors(errorDetails);
    return errorResponse;
  }
}
