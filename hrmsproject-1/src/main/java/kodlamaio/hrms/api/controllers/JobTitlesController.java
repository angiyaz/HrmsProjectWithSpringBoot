package kodlamaio.hrms.api.controllers;

import java.util.List;

import kodlamaio.hrms.business.abstracts.JobTitlesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/jobtitles")
public class JobTitlesController {
	private JobTitlesService jobTitlesservice;
	
	
	@Autowired
	public JobTitlesController(JobTitlesService jobTitlesservice) {
		super();
		this.jobTitlesservice = jobTitlesservice;
	}
    @GetMapping("/getall")
	public DataResult<List<JobTitles>> getAll(){
		return this.jobTitlesservice.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobTitles jobtitles) {
		return this.jobTitlesservice.add(jobtitles);
	}

}
