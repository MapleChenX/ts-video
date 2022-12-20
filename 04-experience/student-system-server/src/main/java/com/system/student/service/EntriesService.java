package com.system.student.service;

import com.system.student.entity.Student;
import com.system.student.entity.Teacher;
import com.system.student.mapper.EntriesMapper;
import com.system.student.utils.Time;
import com.system.student.utils.Result;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EntriesService {

  private final EntriesMapper mapper;

  public EntriesService(EntriesMapper mapper) {
    this.mapper = mapper;
  }

  private Result checkAccount(Map<String, Object> map) {
    Result result = new Result();
    Object password = map.get("password");
    Object account = map.get("account");
    if (password != null && account != null) {
      boolean isPhone = account.toString().matches("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$");
      boolean isEmail = account.toString().matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
      boolean isNo = account.toString().matches("^[4|321]\\d{7}");
      result.setCode(200);
      if (isPhone) map.put("phone", account);
      else if (isEmail) map.put("email", account);
      else if (isNo) map.put("no", account);
      result.setData(map);
      if (!isEmail && !isPhone && !isNo) {
        result.setData("账号格式有错");
        result.setCode(500);
      }
    } else {
      result.setData("没有输入账号");
      result.setCode(500);
    }
    return result;
  }

  public Result stuLogin(Map<String, Object> map) {
    Result result = checkAccount(map);
    if (result.getCode() == 200) {
      Student student = mapper.stuLogin((Map<String, Object>) result.getData());
      result.setData(student);
      HashMap<String, Object> update = new HashMap<>();
      update.put("loginDate", Time.format(Time.Pattern.PATT_1));
      update.put("no", student.getSno());
      mapper.updateStuLoginDate(update);
    }
    return result;
  }

  public Result tchLogin(Map<String, Object> map) {
    Result result = checkAccount(map);
    if (result.getCode() == 200) {
      Teacher teacher = mapper.tchLogin((Map<String, Object>) result.getData());
      result.setData(teacher);
      HashMap<String, Object> update = new HashMap<>();
      update.put("loginDate", Time.format(Time.Pattern.PATT_1));
      update.put("no", teacher.getTno());
      mapper.updateTechLoginDate(update);
    }
    return result;
  }

}
