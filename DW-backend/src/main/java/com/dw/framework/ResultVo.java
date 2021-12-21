package com.dw.framework;

import lombok.Data;

import java.util.List;

@Data
public class ResultVo {

    long time;

    Object data;

    public ResultVo(long time, Object data) {
        this.time = time;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "time=" + time +
                ", data=" + data +
                '}';
    }
}
