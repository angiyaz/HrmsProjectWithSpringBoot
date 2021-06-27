package kodlamaio.hrms.business.concrets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitlesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccesDataResult;
import kodlamaio.hrms.core.utilities.results.SuccesResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitlesDao;
import kodlamaio.hrms.entities.concretes.JobTitles;

@Service
public class JobTitleManager implements JobTitlesService{
	private JobTitlesDao jobTitlesdao;
	
	
    @Autowired
	public JobTitleManager(JobTitlesDao jobTitlesdao) {
		super();
		this.jobTitlesdao = jobTitlesdao;
	}



	@Override
	public DataResult<List<JobTitles>> getAll() {
		
		return new SuccesDataResult<List<JobTitles>>(this.jobTitlesdao.findAll(),"meslekler listelendi.");
				
				
	}

    @Override
	public Result add(JobTitles jobtitles) {
    	if(!checkTitle(jobtitles.getJobName())) {
    		return new ErrorResult("meslek onceden eklendi");
    	}
    	else {
		this.jobTitlesdao.save(jobtitles);
		return new SuccesResult("meslek eklendi");
    	}
		
	}
    
    public boolean checkTitle(String jobTitle) {
    	if(this.jobTitlesdao.findByJobTitle(jobTitle)==null) {
    		return true;
    	}return false;
    }
	

}
