package System;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Space {
	private SpaceType type;
	private UUID id;
	private int index;
	private ArrayList<ReserveRecord> reserveRecordList;
	
	public Space(SpaceType type, int index) {
		this.id = UUID.randomUUID();
		this.type = type;
		this.index = index;
		this.reserveRecordList = new ArrayList<ReserveRecord>();
	}
	
	public boolean checkNextMonthAvailability() {
		LocalDateTime startOfNextMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()).atStartOfDay();
		for(ReserveRecord r:reserveRecordList) {
			if(r.getStartTime())
		}
	}
}
