package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.dto.ViewEnqsFilterRequest;
import in.ashokit.entities.Enquiry;

@Service
public interface EnquiryService {
	
	public boolean addEnquiry(Enquiry enq);
	
	public List<Enquiry> getAllEnquiries(Enquiry enq);
	
	public List<Enquiry> getEnquiriesWithFilter(ViewEnqsFilterRequest filtrReq, Integer counsellorId);
	
	public Enquiry getEnquiryById(Integer enqId);

}
