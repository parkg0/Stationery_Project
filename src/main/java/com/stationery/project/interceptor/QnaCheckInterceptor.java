package com.stationery.project.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.stationery.project.board.BoardDTO;
import com.stationery.project.board.faq.FaqDTO;
import com.stationery.project.board.qnas.QnasDTO;
import com.stationery.project.users.UsersDTO;

public class QnaCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("WriterCheck Interceptor PostHandle");
		
		String method = request.getMethod();
		System.out.println("Method : "+method);
		
		if(method.equals("POST")) {
			return;
		}
		
		//login 정보
		UsersDTO usersDTO = (UsersDTO) request.getSession().getAttribute("auth");
		
		//writer 정보
		Map<String, Object> map = modelAndView.getModel();
	
		QnasDTO qnasDTO = (QnasDTO)map.get("dto");
		if(!usersDTO.getId().equals(qnasDTO.getId())) {
			//spring 문법
			//1. foward
			modelAndView.addObject("message", "수정 권한이 없습니다.");
			modelAndView.addObject("path", "./list");
			modelAndView.setViewName("common/result"); //덮어씌우기
			//2. redirect
		}
	}
}
