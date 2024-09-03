package in.ashokit.dto;

import lombok.Data;

@Data
public class DashboardResponse {
	
	private Long totalEnqs;
	private Long openEnqs;
	private Long lostEnqs;

}
