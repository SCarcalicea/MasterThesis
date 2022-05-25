package com.logicbig.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Routes {

    public String id;
    public String name;
    public String shortName;
    public String longName;
    public String type;
}
