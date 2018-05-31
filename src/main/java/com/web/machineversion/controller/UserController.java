package com.web.machineversion.controller;

import com.web.machineversion.model.OV.Result;
import com.web.machineversion.service.UserService;
import com.web.machineversion.tools.JwtUtil;
<<<<<<< HEAD
=======
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
>>>>>>> master
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
<<<<<<< HEAD
@CrossOrigin("localhost")
=======
@CrossOrigin
>>>>>>> master
public class UserController {
    @Resource
    private UserService userService;

<<<<<<< HEAD
    @RequestMapping(value = "/userMessage", method = RequestMethod.POST)
    public UserMessageResult QueryUserMessage(@RequestHeader(value = "Authorization") String token,
                                              @RequestBody UserQueryJson userQueryJson) {
        if(userService.IsQueryJsonNotContainUserId(userQueryJson))
            return userService.getUserMessage(Integer.parseInt(JwtUtil.parseJwt(token)));
        return userService.getUserMessage(userQueryJson.getUid());
=======
    @RequestMapping(value = "/userMessage", method = RequestMethod.GET)
    public Result QueryUserMessage(HttpServletRequest httpServletRequest, Integer userId) {
        String token = httpServletRequest.getHeader("Authorization");
        if(userId == null)
            return userService.getUserMessage(Integer.parseInt(JwtUtil.parseJwt(token)));
        return userService.getUserMessage(userId);
>>>>>>> master
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Result getAllMember() { return userService.getAllMember(); }
}
