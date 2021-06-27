package kodlamaio.hrms.business.concrets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidatesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccesDataResult;
import kodlamaio.hrms.core.utilities.results.SuccesResult;
import kodlamaio.hrms.entities.concretes.Candidates;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;

@Service
public class CandidatesManager implements CandidatesService{
	private CandidateDao candidatesDao;
	
	
	
	
    @Autowired
	public CandidatesManager(CandidateDao candidatesDao) {
		super();
		this.candidatesDao = candidatesDao;
	}

	@Override
	public DataResult<List<Candidates>> getAll() {
		return new SuccesDataResult<List<Candidates>>(this.candidatesDao.findAll(),"iş arayanlar listelendi");
	}

	@Override
	public Result add(Candidates candidates) {
		if(	candidates.getFirstName()==null
			|| candidates.getLastName()==null
			|| candidates.getMail()==null
			|| candidates.getPassword()==null
			|| candidates.getIdentityNumber()==null
			|| candidates.getBirthYear() == 0) {
			return new ErrorResult("Tum alanlari doldurunuz.!");
		}
		else if(!checkEmail(candidates.getMail())) {
			return new ErrorResult("Email kullanilmaktadir.");
		}
		else if(!checkIdentityNumber(candidates.getIdentityNumber())) {
			return new ErrorResult("Tc kimlik no kullanilmaktadir.");
		}
      else {
	    	this.candidatesDao.save(candidates);
	    	return new SuccesResult("kayit basarili");
	    }
	
	
	}

	private boolean checkEmail(String mail) {
		if (this.candidatesDao.findByEmail(mail)==null) {
			return true;
		}
		return false;
	}
	private boolean checkIdentityNumber(String identitiyNumber) {
		if(this.candidatesDao.findByIdentityNumber(identitiyNumber)==null) {
			return true;
		}return false;
	}

}
