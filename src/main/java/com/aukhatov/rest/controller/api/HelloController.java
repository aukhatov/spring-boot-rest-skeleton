package com.aukhatov.rest.controller.api;

import com.aukhatov.rest.domain.ErrorMessage;
import com.aukhatov.rest.domain.Hello;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
@Api(value = "/api/v1/hello", description = "API version 1")
public class HelloController {

    @ApiOperation(
            value = "Hello",
            notes = "Say Hello!")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Hello", response = Hello.class),
            @ApiResponse(code = 400, message = "Bad hello request", response = ErrorMessage.class)
    })
    @GetMapping(value = "/say", produces = MediaType.APPLICATION_JSON_VALUE)
    private Hello hello() {
        return new Hello("Hello world!");
    }
}
