package com.mbronshteyn.mobileappws.com.mbronshteyn.mobileappws.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDetailRequestModel {

    @NotNull( message = "First Name can not be null")
    private String firstName;

    @NotNull( message = "Last Name can not be null")
    private String lastName;

    @Email ( message = "Email must be formatted correctly")
    @NotNull( message = "Email can not be null")
    private String email;

    @NotNull( message = "Password can not be null")
    @Size( min=8, max=16, message = "Password must be between 8 and 16 characters")
    private String password;
}
