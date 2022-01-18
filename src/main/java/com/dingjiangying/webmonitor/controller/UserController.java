package com.dingjiangying.webmonitor.controller;

import com.alibaba.fastjson.JSON;
import com.dingjiangying.webmonitor.vo.ContactVo;
import com.dingjiangying.webmonitor.dao.UserPoMapper;
import com.dingjiangying.webmonitor.form.UserInfo;
import com.dingjiangying.webmonitor.po.UserPo;
import com.dingjiangying.webmonitor.po.UserPoExample;
import com.dingjiangying.webmonitor.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    UserPoMapper userMapper;
//
//    @Autowired
//    CommonController commonController;
//
//    @RequestMapping("login")
//    public String getLogin(Model model){
//        commonController.putUserName(model);
//        return "/login";
//    }
//
//    @RequestMapping("login?{param}")
//    public String getLogin(@PathVariable("param") String param, Model model){
//        commonController.putUserName(model);
//        model.addAttribute("param", param);
//        return "/login";
//    }
//

    @Autowired
    CommonController commonController;

    @Resource
    UserPoMapper userPoMapper;


    @GetMapping(value = "login")
    public String login(Model model, HttpSession session) {
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
        return "/login";
    }

    @RequestMapping(value = "logout_form")
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("currentUser");
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
        return "/index";
    }

    @PostMapping(value = "login_form")
    public String postLogin(Model model, String username, String password, HttpSession session) {
        UserPoExample example = new UserPoExample();
        example.createCriteria().andUserNameEqualTo(username);
        List<UserPo> users = userPoMapper.selectByExample(example);
        if (users == null || users.size() == 0) {
            //未找到用户名
            model.addAttribute("error", "未找到用户名");
            model.addAttribute("currentUser", Util.getCurrentUserName(session));
            return "/login";
        }
//        默认同名用户只有一个
        UserPo user = users.get(0);
        if (user.getUserPassword() == null) {
            model.addAttribute("error", "用户数据异常");
            model.addAttribute("currentUser", Util.getCurrentUserName(session));
            return "/login";
        }

        if (user.getUserPassword().equals(password)) {
            model.addAttribute("success", "登陆成功");
            session.setAttribute("currentUser", user.getUserName());
            session.setAttribute("currentUserId", user.getUserId());
            model.addAttribute("currentUser", Util.getCurrentUserName(session));
            return "redirect:/task/list";
        } else {
            model.addAttribute("error", "用户密码错误");
            model.addAttribute("currentUser", Util.getCurrentUserName(session));
            return "/login";
        }

    }

    @RequestMapping("/info")
    public String getGreenPage() {
        return "alert";
    }

    @RequestMapping("/register")
    public String register(Model model, HttpSession session) {
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
        return "/register";
    }

    @RequestMapping("/register_form")
    public String register(@ModelAttribute(value = "userinfo") UserInfo userInfo, Model model, HttpSession session) {
        model.addAttribute("currentUser", Util.getCurrentUserName(session));

        UserPoExample example = new UserPoExample();
        example.createCriteria().andUserNameEqualTo(userInfo.getUsername());
        List<UserPo> users = userPoMapper.selectByExample(example);

        if (users != null && users.size() > 0) {
            model.addAttribute("error", "用户名已被使用");
            return "/register";
        } else {
            //todo check password valid
            UserPo userPo = userInfo.covertToPo();
            userPoMapper.insert(userPo);
            model.addAttribute("success", "注册成功");

//            session.setAttribute("currentUser", userPo.getUserName());
//            model.addAttribute("currentUser", Util.getCurrentUserName(session));
            return "/login";
        }
    }

    @RequestMapping("/contact")
    public String showContact(@ModelAttribute(value = "newContact") ContactVo newContactVo, Model model, HttpSession session) {
        model.addAttribute("currentUser", Util.getCurrentUserName(session));
        Integer currentUserId = Util.getCurrentUserId(session);
        UserPo currentUser = userPoMapper.selectByPrimaryKey(currentUserId);

//        if (contact == null) {
////            newContactVo
//        }
        if (newContactVo.getPhone() != null || newContactVo.getMail() != null) {
            //todo update contact info
            model.addAttribute("update", 0);
            model.addAttribute("contact", newContactVo);
            String concateVoString = JSON.toJSONString(newContactVo);
            currentUser.setContact(concateVoString);
            userPoMapper.updateByPrimaryKeySelective(currentUser);
            model.addAttribute("success","修改成功");
            return "/contact";
        }

        String contact = currentUser.getContact();
        ContactVo contactVo = new ContactVo();
        if (contact != null) {
            contactVo = JSON.parseObject(contact, ContactVo.class);
        }

//        contactVo.setMail("1104349906@qq.com");
//        contactVo.setPhone("13821028659");
        model.addAttribute("contact", contactVo);
        return "/contact";
    }

}
