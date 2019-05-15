package com.mbronshteyn.mobileappws.ui.controller;

import com.mbronshteyn.mobileappws.com.mbronshteyn.mobileappws.model.request.UserDetailRequestModel;
import com.mbronshteyn.mobileappws.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping( "users" )
public class UsersController {

    @GetMapping( path = "/{userId}",
            produces = { MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<UserRest> getUser( @PathVariable String userId ){
        UserRest userRest = new UserRest();
        userRest.setFirstName( "Mike" );
        userRest.setLastName( "Bronshteyn" );
        userRest.setUserId( userId );

        return new ResponseEntity<>( userRest, HttpStatus.OK );
    }

    @GetMapping( produces = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE } )
    public ResponseEntity<UserRest> getUsers(@RequestParam( value="page", defaultValue = "1") int page,
                                   @RequestParam( value = "limit", defaultValue = "10") int limit,
                                   @RequestParam( value="sort", required = false) String sort ){
        UserRest userRest = new UserRest();
        userRest.setFirstName( "Mike" );
        userRest.setLastName( "Bronshteyn" );
        return  new ResponseEntity<>( userRest, HttpStatus.OK );
    }

    @PostMapping( consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE } ,
            produces =  { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<UserRest> addUser( @Valid @RequestBody UserDetailRequestModel userDetailRequestModel ) {
        UserRest userRest = new UserRest();
        userRest.setFirstName( userDetailRequestModel.getFirstName() );
        userRest.setLastName( userDetailRequestModel.getLastName() );
        userRest.setEmail( userDetailRequestModel.getEmail() );
        return  new ResponseEntity<>( userRest, HttpStatus.OK );
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}
