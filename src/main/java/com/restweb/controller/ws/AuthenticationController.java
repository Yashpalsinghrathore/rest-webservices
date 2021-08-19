package com.restweb.controller.ws;

import com.restweb.jwt.config.JwtTokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.restweb.entity.*;
import com.restweb.dao.HomeDao;
import com.restweb.dao.HomeDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
@Api(value="/token",tags="Token Management")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private HomeDaoImpl homeDaoImpl;

	@ApiOperation(value ="generate token by username and password")
    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final Person person = homeDaoImpl.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(person);
        return new ApiResponse<>(200, "success",new AuthToken(token, person.getName()));
    }

}
