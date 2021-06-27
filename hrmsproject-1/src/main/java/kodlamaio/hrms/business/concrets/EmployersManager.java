package kodlamaio.hrms.business.concrets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerControl;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccesDataResult;
import kodlamaio.hrms.core.utilities.results.SuccesResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employers;

@Service
public class EmployersManager implements EmployerControl{
	private EmployerDao employerDao;
	
	
    @Autowired
	public EmployersManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employers>> getAll() {
		// TODO Auto-generated method stub
		return new SuccesDataResult<List<Employers>>(this.employerDao.findAll(),"iş verenler listelendi");
	}

	@Override
	public Result add(Employers employer) {
		if(employer.getMail()==null 
				|| employer.getPassword()==null 
				|| employer.getCompanyName()==null
				|| employer.getPhoneNumber()==null
				|| employer.getWebAddress()==null) {
			return new ErrorResult("Tum alanlari doldurunuz.");
			
		}else if(!checkEmail(employer.getMail())) {
			return new ErrorResult("Email kullanilmaktadir.");
		}
		
		
		else {
			this.employerDao.save(employer);
			return new SuccesResult("kayit basarili");
		}
	}
	
	private boolean checkEmail(String mail) {
		if (this.employerDao.findByEmail(mail)==null) {
			return true;
		}
		return false;

}
}