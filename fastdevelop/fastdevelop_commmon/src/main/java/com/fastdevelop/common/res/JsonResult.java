package com.fastdevelop.common.res;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 通用响应结果类
 * @param <T>
 */
@Getter
@Setter
public class JsonResult<T> implements Serializable {
    private Boolean success;
    private Integer code;
    private String msg;
    private T data;

    public JsonResult(){}

    public JsonResult(JsonResultBuilder<T> builder) {
        this.code = builder.code;
        this.msg = builder.msg;
        this.success = builder.success;
        this.data = builder.data;
    }

    public static <T> JsonResultBuilder<T> builder() {
        return new JsonResultBuilder<T>();
    }


    public static final class JsonResultBuilder<T> {
        private Integer code;

        private String msg;

        private Boolean success;

        private T data;

        private JsonResultBuilder() {
        }


        public JsonResultBuilder<T> success() {
            this.code = CommonResponseCode.SUCCESS.getCode();
            this.success = CommonResponseCode.SUCCESS.getSuccess();
            this.msg = CommonResponseCode.SUCCESS.getMsg();
            return this;
        }

        public JsonResultBuilder<T> success(T data) {
            this.code = CommonResponseCode.SUCCESS.getCode();
            this.success = CommonResponseCode.SUCCESS.getSuccess();
            this.msg = CommonResponseCode.SUCCESS.getMsg();
            this.data = data;
            return this;
        }

        public JsonResultBuilder<T> success(ResponseCode responseCode) {
            this.code = CommonResponseCode.SUCCESS.getCode();
            this.success = CommonResponseCode.SUCCESS.getSuccess();
            this.msg = responseCode.getMsg();
            return this;
        }

        public JsonResultBuilder<T> failure() {
            this.code = CommonResponseCode.FAILURE.getCode();
            this.success = CommonResponseCode.FAILURE.getSuccess();
            this.msg = CommonResponseCode.FAILURE.getMsg();
            return this;
        }

        public JsonResultBuilder<T> failure(String msg) {
            return failure(CommonResponseCode.FAILURE.getCode(), msg);
        }

        public JsonResultBuilder<T> failure(Integer code, String msg) {
            this.code = code;
            this.success = CommonResponseCode.FAILURE.getSuccess();
            this.msg = msg;
            return this;
        }

        public JsonResultBuilder<T> failure(ResponseCode responseCode) {
            return failure(responseCode, null);
        }

        public JsonResultBuilder<T> failure(ResponseCode responseCode, T data) {
            this.code = responseCode.getCode();
            this.msg = responseCode.getMsg();
            this.success = responseCode.getSuccess();
            this.data = data;
            return this;
        }

        public JsonResult<T> build() {

            return new JsonResult<>(this);

        }

    }

}
