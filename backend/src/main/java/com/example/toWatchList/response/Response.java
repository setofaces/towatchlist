package com.example.toWatchList.response;

//Response object for rest controller
public class Response {
    private int status=200;
    private Object data;
    private String message="success";

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response(int status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Response(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Response() {
    }

    public Response(Object data, String message) {
        this.data = data;
        this.message = message;
    }

    public Response(String message) {
        this.message = message;
    }

    public Response(Object data) {
        this.data = data;
    }
}
