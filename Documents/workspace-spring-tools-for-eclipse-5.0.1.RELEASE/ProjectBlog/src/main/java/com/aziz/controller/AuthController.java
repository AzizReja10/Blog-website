package com.aziz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aziz.model.User;
import com.aziz.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="*")
public class AuthController {
  @Autowired
  UserRepository userRepo;
  @Autowired
  BCryptPasswordEncoder encoder;
  @PostMapping("/register")
  public String register(@RequestBody User user)
  {
	  if(userRepo.findByUsername(user.getUsername())!=null)
		  return "Username Already Exists";
	  user.setPassword(encoder.encode(user.getPassword()));
	  userRepo.save(user);
	  return ("User registered sucessfully");
  }
  @PostMapping("/login")
  public String login(@RequestBody User user)
  {
	  User found=userRepo.findByUsername(user.getUsername());
	  if(found==null)
		  return "User not found";
	  if(encoder.matches(user.getPassword(),found.getPassword()))
	  return "Login successfull";
	  return "Invalid password";
  }
}
