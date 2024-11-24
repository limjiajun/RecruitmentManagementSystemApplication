package com.Recruitment.Management.System.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Recruitment.Management.System.service.UserService;
import com.Recruitment.Management.System.web.dto.UserRegistrationDto;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}

	@PostMapping
	public void registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // 使用 PrintWriter 输出内容

		try {
			userService.save(registrationDto); // 保存用户
			out.println("<script type='text/javascript'>");
			out.println("alert('Registration successful! Redirecting to login page...');");
			out.println("window.location.href='/login';"); // 跳转到登录页面
			out.println("</script>");
		} catch (Exception e) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Registration failed: " + e.getMessage() + "');");
			out.println("window.location.href='/registration';"); // 返回注册页面
			out.println("</script>");
		}
	}

}
