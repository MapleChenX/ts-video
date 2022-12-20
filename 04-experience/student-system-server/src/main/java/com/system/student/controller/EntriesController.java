package com.system.student.controller;

import com.system.student.entity.Student;
import com.system.student.entity.Teacher;
import com.system.student.service.EntriesService;
import com.system.student.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/entries")
public class EntriesController {

  private final EntriesService service;

  public EntriesController(EntriesService service) {
    this.service = service;
  }

  @PostMapping("/stu/login")
  public Result stuLogin(@RequestBody Map<String, Object> map) {
    return service.stuLogin(map);
  }

  @PostMapping("/tch/login")
  public Result tchLogin(@RequestBody Map<String, Object> map) {
    return service.tchLogin(map);
  }
}