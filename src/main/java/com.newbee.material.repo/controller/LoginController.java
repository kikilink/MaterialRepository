package com.newbee.material.repo.controller;

import com.newbee.material.repo.api.IUserService;
import com.newbee.material.repo.domain.User;
import com.newbee.material.repo.util.common.Constants;
import com.newbee.material.repo.util.common.EncryptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
public class LoginController {

	private Log LOGGER = LogFactory.getLog(LoginController.class);

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam("username") String loginName,
			@RequestParam("password") String password, HttpSession session,
			ModelAndView modelAndView) {
		LOGGER.info("start to login . user name :" + loginName);
		User user = userService.getUser(loginName);
		if (null != user) {
			if (validatePwd(password, user)) {
				session.setAttribute(Constants.USER_SESSION, user);
				modelAndView.setViewName("redirect:/main");
			} else {
				modelAndView.addObject("message", "登录名或密码错误！请重新输入");
				modelAndView.addObject("loginFailed", true);
				modelAndView.setViewName("forward:/login-page");
			}
		} else {
			modelAndView.addObject("message", "登录名或密码错误！请重新输入");
			modelAndView.addObject("loginFailed", true);
			modelAndView.setViewName("forward:/login-page");
		}

		LOGGER.info("login finished.");

		return modelAndView;
	}

	private boolean validatePwd(String password, User user) {
		String realPwd = user.getPassword();
		try {
			if (null == realPwd || "".equals(realPwd)) {
				return true;
			} else {
				String encryptedPwd = EncryptionUtil.encryptSha512(password);
				return realPwd.equals(encryptedPwd);
			}
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No such algorithm. Encryption failed.");
		} catch (IllegalArgumentException e) {
			LOGGER.error("Plain text argument error.");
		}
		return false;
	}
}
