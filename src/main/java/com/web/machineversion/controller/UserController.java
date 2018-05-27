package com.web.machineversion.controller;

import com.web.machineversion.model.jsonrequestbody.UserQueryJson;
import com.web.machineversion.model.OV.UserMessageResult;
import com.web.machineversion.service.UserService;
import com.web.machineversion.tools.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("localhost")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/userMessage", method = RequestMethod.POST)
    public UserMessageResult QueryUserMessage(@RequestHeader(value = "Authorization") String token,
                                              @RequestBody UserQueryJson userQueryJson) {
        if(userService.IsQueryJsonNotContainUserId(userQueryJson))
            return userService.getUserMessage(Integer.parseInt(JwtUtil.parseJwt(token)));
        return userService.getUserMessage(userQueryJson.getUid());
    }
}
