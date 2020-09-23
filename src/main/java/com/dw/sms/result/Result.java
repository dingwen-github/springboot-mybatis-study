package com.dw.sms.result;

import java.io.Serializable;
import java.sql.Timestamp;

import com.alibaba.fastjson.JSON;

/**
 * @program:
 * @description: 接口返回规范
 * @author: dingwen
 * @create: 2020/9/23 11:16
 **/

public class Result implements Serializable {
    private static final long serialVersionUID = -8874271997969483344L;
    private int code;
    private String message;
    private Object data;
    private String path;
    private Timestamp currentTime = new Timestamp(System.currentTimeMillis());

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return this.data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public Timestamp getCurrentTime() {
        return this.currentTime;
    }

    public Result setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    public Result() {
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result other = (Result) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                label61:
                {
                    Object this$message = this.getMessage();
                    Object other$message = other.getMessage();
                    if (this$message == null) {
                        if (other$message == null) {
                            break label61;
                        }
                    } else if (this$message.equals(other$message)) {
                        break label61;
                    }

                    return false;
                }

                label54:
                {
                    Object this$data = this.getData();
                    Object other$data = other.getData();
                    if (this$data == null) {
                        if (other$data == null) {
                            break label54;
                        }
                    } else if (this$data.equals(other$data)) {
                        break label54;
                    }

                    return false;
                }

                Object this$path = this.getPath();
                Object other$path = other.getPath();
                if (this$path == null) {
                    if (other$path != null) {
                        return false;
                    }
                } else if (!this$path.equals(other$path)) {
                    return false;
                }

                Object this$currentTime = this.getCurrentTime();
                Object other$currentTime = other.getCurrentTime();
                if (this$currentTime == null) {
                    if (other$currentTime != null) {
                        return false;
                    }
                } else if (!this$currentTime.equals(other$currentTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Result;
    }

    public int hashCode() {
        /*
          int PRIME = true;
          int result = 1;
          int result = result * 59 + this.getCode();
         */
        int result = 1;
        result = result * 59 + this.getCode();
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        Object $path = this.getPath();
        result = result * 59 + ($path == null ? 43 : $path.hashCode());
        Object $currentTime = this.getCurrentTime();
        result = result * 59 + ($currentTime == null ? 43 : $currentTime.hashCode());
        return result;
    }
}
