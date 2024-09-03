package in.ashokit.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entities.Counsellor;

public interface CounsellorRepo extends JpaRepository<Counsellor, Integer>{
	
	// select * from counsellor_tbl where email=:email and pwd=:pwd
	public Counsellor findByEmailAndPassword(String email, String pwd);

}
