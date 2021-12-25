package com.dw.vo;

import lombok.Data;

@Data
public class MergeVo {

    private String p_id;

    private String merge_pids;

    public MergeVo(String p_id, String merge_pids) {
        this.p_id = p_id;
        this.merge_pids = merge_pids;
    }
}
