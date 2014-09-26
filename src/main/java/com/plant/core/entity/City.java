package com.plant.core.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class City implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6012194380924330671L;
    private Long              id;
    private List<Long>        ids;
    private String            name;
    private String            countryCode;
    private String            district;
    private String            population;
    private String            order;
    private String            by;
    private String            start;
    private String            limit;

}
