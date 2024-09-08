package in.ashokit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.dto.DashboardResponse;
import in.ashokit.entities.Counsellor;
import in.ashokit.entities.Enquiry;
import in.ashokit.repos.CounsellorRepo;
import in.ashokit.repos.EnquiryRepo;
@Service
public class CounsellorServiceImpl implements CounsellorService {

	@Autowired
	private CounsellorRepo counsellorRepo;
	@Autowired
	private EnquiryRepo enqRepo;
	
	// this is constructor injection instead of above field injection we can go with below.
//	private CounsellorRepo counsellorRepo;
//	private EnquiryRepo enqRepo;
//	public counsellorServiceImpl(CounsellorRepo counsellorRepo, EnquiryRepo enqRepo) {
//		this.counsellorRepo = counsellorRepo;
//		this.enqRepo = enqRepo;
//	}
	
	@Override
	public Counsellor findByEmail(String email) {
		return counsellorRepo.findByEmail(email);
		
		
	}

	@Override
	public boolean register(Counsellor counsellor) {
		Counsellor savedCounsellor = counsellorRepo.save(counsellor);
		if (savedCounsellor.getCounsellorId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public Counsellor login(String email, String pwd) {
		Counsellor counsellor = counsellorRepo.findByEmailAndPassword(email, pwd);
		return counsellor;
	}

	@Override
	public DashboardResponse getDashboardInfo(Integer counsellorId) {
		DashboardResponse response = new DashboardResponse();
		List<Enquiry> enqList = enqRepo.getEnquiryByCounsellorId(counsellorId);
		int totalEnq = enqList.size();
		
		int enrolledEnqs = enqList.stream().filter(e -> e.getEnqStatus().equals("Enrolled"))
									.collect(Collectors.toList())
									.size();
		
		int lostEnqs = enqList.stream().filter(e -> e.getEnqStatus().equals("Lost"))
				.collect(Collectors.toList())
				.size();
		
		int openEnqs = enqList.stream().filter(e -> e.getEnqStatus().equals("Open"))
									.collect(Collectors.toList())
									.size();
		response.setTotalEnqs(counsellorId);
		response.setEnrolledEnqs(counsellorId);
		response.setLostEnqs(counsellorId);
		response.setOpenEnqs(counsellorId);
		
		
		
		return response;
	}

}
