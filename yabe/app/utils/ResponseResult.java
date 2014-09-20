package utils;

public class ResponseResult {

  public String status;

  public String msg;

  public Object data;

  public ResponseResult() {

  }

  public ResponseResult(String msg, Object data, STATUS status) {
    this.msg = msg;
    this.data = data;
    this.status = status.toString();
  }

  public static ResponseResult success() {
    return new ResponseResult("", null, STATUS.SUCCESSFUL);
  }

  public static ResponseResult fail(String msg) {
    return new ResponseResult(msg, null, STATUS.FAILURE);
  }

  public enum STATUS {
    SUCCESSFUL, FAILURE;
  }

}
