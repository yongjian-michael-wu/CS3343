package System;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
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
			if(r.getStartTime().isAfter(startOfNextMonth)) {
				return false;
			}
		}
		return true;
	}
	public String getTypeName() {
		return this.type.getName();
	}

	public void addReserveRecord(ReserveRecord reserveRecord) {
		this.reserveRecordList.add(reserveRecord);
	}
	public void removeReserveRecord(ReserveRecord reserveRecord) {
		this.reserveRecordList.remove(reserveRecord);
	}
	
	public boolean checkReserveConflict(LocalDateTime startTime,LocalDateTime endTime) {
		for(ReserveRecord r:reserveRecordList) {
			if(r.checkOverlap(startTime,endTime)) {
				return false;
			}
		}
		return true;
	}
}
