/**
 * 
 */
package com.wangku.controller.validatecode;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wangku.util.ValidateCode;

/**
 * @author 谢虹英
 * 2015年8月17日上午9:36:45
 * 类描述：
 */
@Controller
public class ValidateCodeController {
	@RequestMapping("/code")
	 public void getCode(HttpServletRequest req, HttpServletResponse resp){
		try {
			ValidateCode.getCode(req, resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
