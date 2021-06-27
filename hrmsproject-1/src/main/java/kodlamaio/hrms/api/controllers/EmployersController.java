package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlamaio.hrms.business.abstracts.EmployerControl;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;

@RestController
@RequestMapping("api/employers")

public class EmployersController {
	private EmployerControl employerControl;
	
	
    @Autowired
	public EmployersController(EmployerControl employerControl) {
		super();
		this.employerControl = employerControl;
	}
	
	
    @GetMapping("/getall")
	public DataResult<List<Employers>> getAll(){
		return this.employerControl.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Employers employers) {
		return this.employerControl.add(employers);
	}
    
    
    
    
    
    
    
    

}
