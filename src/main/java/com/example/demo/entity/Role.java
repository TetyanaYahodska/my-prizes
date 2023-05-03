package com.example.demo.entity;
public enum Role {
    ADMIN(1), USER(2);
    private final int code;
    Role(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}



