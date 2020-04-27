package org.sid.stagiaire.securite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	
	@GetMapping("/403")
	public String error(){
		return "403";
	}

}
