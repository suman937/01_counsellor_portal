package in.ashokit.service;

import java.util.List;

import org.springframework.data.domain.Example;

import in.ashokit.dto.ViewEnqsFilterRequest;
import in.ashokit.entities.Counsellor;
import in.ashokit.entities.Enquiry;
import in.ashokit.repos.CounsellorRepo;
import in.ashokit.repos.EnquiryRepo;
import io.micrometer.common.util.StringUtils;
import lombok.Data;

@Data
public class EnquiryServiceImpl implements EnquiryService {

	private EnquiryRepo enqRepo;
	private CounsellorRepo counsellorRepo;

	public EnquiryServiceImpl(EnquiryRepo enqRepo, CounsellorRepo counsellorRepo) {
		this.enqRepo = enqRepo;
		this.counsellorRepo = counsellorRepo;

	}

	@Override
	public boolean addEnquiry(Enquiry enq, Integer counsellorId) throws Exception {
		// Counsellor counsellor = counsellorRepo.findById(counsellorId).orElse(null);
//		if(counsellor==null) {
//			throw new Exception("No counsellor found");
//		}
//		enq.setCounsellor(counsellor);
//		Enquiry enquiry = enqRepo.save(enq);
//		if(enquiry.getEnqId()!= null) {
//			return true;
//		}
		Counsellor counsellor = counsellorRepo.findById(counsellorId).orElse(null);
		if (counsellor == null) {
			throw new Exception("No counsellor found");
		}
		enq.setCounsellor(counsellor);
		Enquiry enquiry = enqRepo.save(enq);
		if (enquiry.getEnqId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Enquiry> getAllEnquiries(Integer counsellorId) {
		List<Enquiry> totEnq = enqRepo.getEnquiryByCounsellorId(counsellorId);

		return totEnq;
	}

	@Override
	public Enquiry getEnquiryById(Integer enqId) {
		Enquiry enquiry = enqRepo.findById(enqId).orElse(null);
		return enquiry;
	}

	@Override
	public List<Enquiry> getEnquiriesWithFilter(ViewEnqsFilterRequest filterReq, Integer counsellorId) {
		// QBE (Query By Example) implementation

		Enquiry enq = new Enquiry();
		if (StringUtils.isNotEmpty(filterReq.getClassMode())) {
			enq.setClassMode(filterReq.getClassMode());
		}
		if(StringUtils.isNotEmpty(filterReq.getCourseName())) {
			enq.setCourseName(filterReq.getCourseName());
		}
		if(StringUtils.isNotEmpty(filterReq.getEnqStatus())) {
			enq.setCourseName(filterReq.getEnqStatus());
		}
		
		Counsellor c = counsellorRepo.findById(counsellorId).orElse(null);
		enq.setCounsellor(c);
		
		Example<Enquiry> of = Example.of(enq);

		List<Enquiry> enqList = enqRepo.findAll(of);

		return enqList;
	}

}
