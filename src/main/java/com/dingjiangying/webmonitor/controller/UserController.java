package com.dingjiangying.webmonitor.controller;

import com.dingjiangying.webmonitor.Vo.ContactVo;
import com.dingjiangying.webmonitor.dao.UserMapper;
import com.dingjiangying.webmonitor.dao.UserPoMapper;
import com.dingjiangying.webmonitor.form.UserInfo;
import com.dingjiangying.webmonitor.po.UserPo;
import com.dingjiangying.webmonitor.po.UserPoExample;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    public String getLogin(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            model.addAttribute("currentUser", currentUserName);
        } else {
            model.addAttribute("currentUser", "游客");
        }
        return "/login";
    }


    @PostMapping(value = "login")
    public String postLogin(Model model, String username, String password) throws Exception {
        UserPoExample example = new UserPoExample();
        example.createCriteria().andUserNameEqualTo(username);
        List<UserPo> users = userPoMapper.selectByExample(example);
        if (users == null || users.size() == 0) {
            //未找到用户名
            model.addAttribute("error", "未找到用户名");
            return "/login";
        }
//        默认同名用户只有一个
        UserPo user = users.get(0);
        if (user.getUserPassword() == null) {
            model.addAttribute("error", "用户数据异常");
            return "/login";
        }

        if (user.getUserPassword().equals(password)) {
            model.addAttribute("success", "登陆成功");
            return "/task/list";
        } else {
            model.addAttribute("error", "用户密码错误");
            return "/login";
        }

    }

//    @RequestMapping("/info")
//    public String getGreenPage(){
//        return "alert";
//    }
//
//    @RequestMapping("/register")
//    public String register(){
//        System.out.println("get!");
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String register(@ModelAttribute(value = "userinfo") UserInfo userInfo, Model model){
//        commonController.putUserName(model);
//        System.out.println("post!");
//        UserPo userPo = userInfo.covertToPo();
//        userMapper.insertUser(userPo);
//        return "task";
//    }
//
//    @RequestMapping("/contact")
//    public String showContact(@ModelAttribute(value = "newContact") ContactVo newContactVo, Model model){
//        if(newContactVo!=null){
//            model.addAttribute("update",0);
//            model.addAttribute("contact",newContactVo);
//            return "/contact";
//        }
//        commonController.putUserName(model);
////        userMapper.getUserByName((String) model.getAttribute("currentUser"));
//        ContactVo contactVo = new ContactVo();
//        contactVo.setMail("1104349906@qq.com");
//        contactVo.setPhone("13821028659");
//        model.addAttribute("contact",contactVo);
//        return "/contact";
//    }

}
