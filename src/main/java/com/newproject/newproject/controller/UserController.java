package com.newproject.newproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.newproject.newproject.entity.UserEntity;
import com.newproject.newproject.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
   
	@PostMapping("/newuser")
	public ResponseEntity<String> registerUser(@RequestBody UserEntity userEntity)
	{
		Boolean flag = userService.saveUser(userEntity);
		if(flag) 
		{
		return new ResponseEntity<String>("User registered successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("User isn't registered successfully",HttpStatus.CONFLICT);
    }
	
	@GetMapping("/loginuser")
	public ResponseEntity<String> loginUser(@RequestParam("username") String username, @RequestParam("password")String password)
	{
		UserEntity userEntity = userService.loginUser(username);
		if(userEntity.getUserPassword().equals(password)){   
		return new ResponseEntity<String>("logged in successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Please check your credentials",HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "Registration";
	}
	
	@PostMapping("/test")
	public String test0(UserEntity userentity, ModelMap model)
	{
		boolean flag = userService.saveUser(userentity);
		if(flag)
		{
			model.addAttribute("message","User is registered successfully..");
			return "Registration";
		}
		model.addAttribute("message","user not registered, please try again..");
		return "Registration";
	}
	
	@GetMapping("/login")
	public String userLogin()
	{
		return "Login";
	}
	
	@PostMapping("/login")
	public String userLogin0(ModelMap model,@RequestParam("userEmail") String username, @RequestParam("userPassword")String password)
	{
		UserEntity userEntity = userService.loginUser(username);
		if(userEntity.getUserPassword().equals(password))
		{
			model.addAttribute("message","User is Logged in successfully..");
			return "redirect:/getallusers";
		}
		model.addAttribute("message","Please check your credentials!");
		return "Login";
	}
	
	@GetMapping("/getallusers")
	public String getUsers(HttpServletRequest request)
	{
		List<UserEntity> allusers = userService.getAllUsers();
		request.setAttribute("allusers", allusers);
		request.setAttribute("message", "Now you can have all the private info of our users!");
		return "UserList";
	}
	
	@GetMapping("/delete/{id}")
		public String deleteuser(@PathVariable("id") int id, HttpServletRequest request) {
			System.out.println(id);
			boolean flag = userService.deleteUser(id);
			if (flag) {
				request.setAttribute("message0", "user is deleted succesfully");
             return "redirect:/getallusers";
			}else {
				request.setAttribute("message0", "user is not deleted try agian");
				return "UserList";
            }
	}
	
	@GetMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int id,HttpServletRequest request)
	{
		List<UserEntity> userEntity = userService.updateUser(id);
		if(userEntity!=null)
		{
			request.setAttribute("userEntity", userEntity);
			request.setAttribute("updatemessage", "This user is updated successfully!");
			return "Registration";
		}
		request.setAttribute("updatemessage", "This user can't be updated!");
		return "Registration";
	}
	
	@PostMapping("/update/{id}")
	public void updateUser0(@ModelAttribute UserEntity userEntity)
	{
		userService.saveUser(userEntity);
	}
}
