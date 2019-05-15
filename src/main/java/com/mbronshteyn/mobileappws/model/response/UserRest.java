package com.mbronshteyn.mobileappws.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRest {
    private String firstName;
    private String lastName;
    private String email;
    private String userId;
}
