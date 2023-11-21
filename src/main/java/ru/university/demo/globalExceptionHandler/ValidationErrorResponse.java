package ru.university.demo.globalExceptionHandler;

import java.util.List;

public class ValidationErrorResponse {

  private List<ErrorDetail> errors;

  public List<ErrorDetail> getErrors() {
    return errors;
  }

  public void setErrors(List<ErrorDetail> errors) {
    this.errors = errors;
  }

  public static class ErrorDetail {

    private String field;
    private String message;

    public ErrorDetail(String field, String message) {
      this.field = field;
      this.message = message;
    }

    public String getField() {
      return field;
    }

    public String getMessage() {
      return message;
    }
  }
}
