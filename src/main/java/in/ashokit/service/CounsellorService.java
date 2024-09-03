package in.ashokit.service;

import org.springframework.stereotype.Service;

import in.ashokit.dto.DashboardResponse;
import in.ashokit.entities.Counsellor;

@Service
public interface CounsellorService {
	
	public boolean register(Counsellor counsellor);
	
	public Counsellor login(String email, String pwd);
	
	public DashboardResponse getDashboardInfo(Integer counsellorId);

}
