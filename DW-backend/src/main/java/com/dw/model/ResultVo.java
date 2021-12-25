package com.dw.model.mysql;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

/**
 * 查询结果返回类
 *
 * @author
 */
@Data
public class ResultVo {
    private long Time;
    private List<HashMap<String, String>> data;

    public ResultVo(List<HashMap<String, String>> list,long time) {
        this.Time = time;
        this.data = list;
    }
}

