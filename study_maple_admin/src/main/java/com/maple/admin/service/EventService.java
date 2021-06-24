package com.maple.admin.service;

import java.util.List;

import com.maple.admin.dto.EventDto;
import com.maple.admin.entity.EventMaster;

public interface EventService {

	public List<EventMaster> getEventList() throws Exception;
	
	public EventMaster saveEvent(EventDto.EventSaveDto save) throws Exception;
	
	public EventMaster getEventInfo(Integer eventno) throws Exception;
	
	public void updateEventInfo(EventDto.EventSaveDto save) throws Exception;
}
