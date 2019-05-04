package com.cyt.graduation_project.business.controller;

import com.cyt.graduation_project.business.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MenuInfoController {
    @Autowired
    MenuInfoService menuInfoService;





}
