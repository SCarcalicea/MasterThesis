package com.logicbig.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Routes {

    public String id;
    public String name;
    public Double lat;
    public Double lon;
}
