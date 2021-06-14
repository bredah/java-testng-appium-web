package bredah.exceptions;

public class TargetNotValidException extends IllegalStateException {

  public TargetNotValidException(String target) {
    super(String.format("Target %s is not supported or has not been defined", target));
  }

}
