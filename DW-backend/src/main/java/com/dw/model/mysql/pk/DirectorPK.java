package com.dw.model.mysql.pk;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class DirectorPK implements Serializable {

    private String p_id;
    private String director;
}
