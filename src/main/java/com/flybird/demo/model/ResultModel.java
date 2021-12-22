package com.flybird.demo.model;

public class ResultModel {
    private String code;
    private String message;
    private Object data;

    public  static  ResultModel data(Object data) {
        ResultModel model = new ResultModel();
        model.data= data;
        model.code="0";
        return  model;
    }

    public  static  ResultModel error(String message) {
        ResultModel model = new ResultModel();
        model.message = message;
        model.code="-1";
        return  model;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
