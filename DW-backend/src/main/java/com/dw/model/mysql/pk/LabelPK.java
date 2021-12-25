package com.dw.model.mysql.pk;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class LabelPK implements Serializable {
    private String p_id;
    private String label;
}
