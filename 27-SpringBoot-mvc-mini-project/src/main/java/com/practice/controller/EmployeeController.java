package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.practice.dto.EmployeeDTO;
import com.practice.dto.LoginDTO;
import com.practice.exceptionHandling.UserNotFoundException;
import com.practice.service.EmployeeService;
import com.practice.utility.RestConstant;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping(value=RestConstant.GET_REGISTER)
	public String getRegisteredEmployee(Model model, HttpServletRequest req) {
		
		HttpSession session2 = req.getSession();
		System.out.println(session2);
		
		model.addAttribute("employee", new EmployeeDTO());
		return "employeereg";
	}
	
	@PostMapping(value=RestConstant.REGISTER)
	public String saveEmployee(@Valid @ModelAttribute("employee")EmployeeDTO employee, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("employee", employee);
			return "employeereg";
		}else {
			employeeService.registerEmployee(employee);
			return "redirect:/login";
		}
	}
	
	@GetMapping(value=RestConstant.LISTEMPLOYEE)
	public String getListOfEmployee(Model model, HttpSession session, HttpServletRequest req, RedirectAttributes redirectAttribute) {
		String user = (String) session.getAttribute("empsession");
		
		HttpSession session2 = req.getSession();
		System.out.println(session2);
		
		if(user != null) {
			List<EmployeeDTO> fetchAllEmployee = employeeService.fetchAllEmployee();
			model.addAttribute("listemployee", fetchAllEmployee);
			return "listemployee";
		}else {
		redirectAttribute.addFlashAttribute("msg", "username and password is Invalid please try to login again");
		return "redirect:/login";
		}
	}
	
	@GetMapping(value=RestConstant.EDIT_EMPLOYEE_BY_ID)
	public String getEmployeeById(@PathVariable("id")Long id, Model model, HttpSession session, HttpServletRequest req, RedirectAttributes redirectAttribute) {
		String user = (String) session.getAttribute("empsession"); 
		
		HttpSession session2 = req.getSession();
		System.out.println(session2);
		
		if(user != null) {
		    EmployeeDTO employeeById = employeeService.fetchEmployeeById(id);
		    model.addAttribute("employee", employeeById);
		    return "editemployee";
		}else {
	        redirectAttribute.addFlashAttribute("msg", "Invalid session please try to login again");
	        return "redirect:/login";
	    }
}
	
	@PostMapping(value=RestConstant.EMPLOYEEUPDATE)
	public String updateEmployee(@ModelAttribute("employee")EmployeeDTO employee, HttpSession session, RedirectAttributes redirectAttribute) {
		String user = (String) session.getAttribute("empsession");
		if(user != null) {
			employeeService.updateEmployee(employee);
			redirectAttribute.addFlashAttribute("msg", "employee information updated succuessfully....");
			return "redirect:/listemployee";
		}else {
		    return "redirect:/login";
		}
	}
	
	@GetMapping(value=RestConstant.DELETE_EMPLOYEE_BY_ID)
	public String deleteEmployee(@PathVariable("id")Long id, HttpSession session, RedirectAttributes redirectAttribute) {
		String user = (String) session.getAttribute("empsession");
		if(user != null) {
			employeeService.deleteEmployee(id);
			redirectAttribute.addFlashAttribute("msg", "employee deleted...");
			return "redirect:/listemployee";
		}else {
		redirectAttribute.addFlashAttribute("msg", "Invalid session please try to login again");
		return "redirect:/login";
		}

	}
	
	//login ---------------------------------------------------------------------------------------
	
	@GetMapping(value=RestConstant.Get_LOGIN)
	public String getLoginEmployee(Model model) {
		model.addAttribute("login", new LoginDTO());
		return "login";
	}
	
	
	@PostMapping(value = RestConstant.LOGIN)
	public String saveLoginEmployee(@ModelAttribute("login") LoginDTO login,
	                                HttpSession session,
	                                HttpServletRequest req,
	                                HttpServletResponse res,
	                                RedirectAttributes redirectAttribute) {
	    try {
	        // Call service and get result
	        String status = employeeService.loginEmployee(login.getEmail(), login.getPassword());

	        if ("success".equals(status)) {
	        	
//	        	HttpSession session2 = req.getSession();
// 			    System.out.println(session2);
	            session.setAttribute("empsession", login.getEmail());
	            // session.setMaxInactiveInterval(25);
	            redirectAttribute.addFlashAttribute("msg", "Employee logged in successfully");
	            return "redirect:/listemployee";
	        } else {
	            // If service returned something else
	            redirectAttribute.addFlashAttribute("msg", "Invalid login credentials");
	            return "redirect:/login";
	        }

	    } catch (UserNotFoundException e) {
	        redirectAttribute.addFlashAttribute("msg", e.getMessage());
	        return "redirect:/login";
	    } catch (Exception e) {
	        redirectAttribute.addFlashAttribute("msg", e.getMessage());
	        return "redirect:/error";
	    }
	}

	
	
//	@PostMapping(value = RestConstant.LOGIN)
//	public String saveLoginEmployee(@Valid @ModelAttribute("login") LoginDTO login,
//	                                BindingResult result,
//	                                HttpSession session,
//	                                HttpServletRequest req,
//	                                HttpServletResponse res,
//	                                RedirectAttributes redirectAttribute) {
//	    try {
//	        if (result.hasErrors()) {
//	            return "login";  // go back to login page if validation fails
//	        } else {
//	            // If validation passes
//	            session.setAttribute("empsession", login.getEmail());
//	            redirectAttribute.addFlashAttribute("msg", "employee logged in successfully");
//	            return "redirect:/listemployee";
//	        }
//	    } catch (UserNotFoundException e) {
//	        redirectAttribute.addFlashAttribute("msg", e.getMessage());
//	        return "redirect:/login";
//	    } catch (Exception e) {
//	        redirectAttribute.addFlashAttribute("msg", e.getMessage());
//	        return "redirect:/error";
//	    }
//	}

	
	
	
	
//	@PostMapping(value=RestConstant.LOGIN)
//	public String saveLoginEmployee(@ModelAttribute("login") LoginDTO login,
//	                                HttpSession session, HttpServletRequest req, HttpServletResponse res,
//	                                RedirectAttributes redirectAttribute) {
//		try {
//	    employeeService.loginEmployee(login.getEmail(), login.getPassword());
//	 	    
//	 	    if ("success".equals(status)) {
//	 	    	
////	 	    	HttpSession session2 = req.getSession();
////	 			System.out.println(session2);
//	 	        session.setAttribute("empsession", login.getEmail());  
////	 	        session.setMaxInactiveInterval(25);
//	 	        redirectAttribute.addFlashAttribute("msg", "employee logged in successfully");
//	 	       return "redirect:/listemployee";
//	         }catch(UserNotFoundException e) {
//	            redirectAttribute.addFlashAttribute("msg", e.getMessage());
//	            return "redirect:/login";
//	         }catch(Exception e) {
//	            redirectAttribute.addFlashAttribute("msg", e.getMessage());
//	            return "redirect:/error";
//	          }
//	     }
//	}

	
//	@PostMapping(value="/login")
//	public String saveLoginEmployee(@Validated @ModelAttribute("login")LoginDTO login, BindingResult result, HttpSession session, RedirectAttributes redirectAttribute) {
//		if(result.hasErrors()) {
//			redirectAttribute.addFlashAttribute("msg", "Invalid username and password");
//			return "redirect:/login";
//		}else {
////			session.setAttribute("empsession", login.getEmail());
//		    employeeService.loginEmployee(login.getEmail(), login.getPassword());
////		    redirectAttribute.addFlashAttribute("msg", "Employee registered successfully");
//		    return "redirect:/listemployee";
//		}
//	}
	
	
	//logout------------------------------------------------------------------------------------------------
	@GetMapping(value=RestConstant.LOGOUT)
	public String getLogoutEmployee(HttpSession session, RedirectAttributes redirectAttribute) {
		String user = (String) session.getAttribute("empsession");
		if(user != null) {
			session.removeAttribute(user);   //remove particular attributes from session manager
			session.invalidate();            //invalidate the session
			
		    redirectAttribute.addFlashAttribute("msg", "You have been logged out successfully");
			return "redirect:/login";
		}else {
			return "redirect:/login";
		}

	}
	
	
}




