package com.dw.model.mysql.pk;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ActorPK implements Serializable {
    private String p_id;
    private String actor;
}
