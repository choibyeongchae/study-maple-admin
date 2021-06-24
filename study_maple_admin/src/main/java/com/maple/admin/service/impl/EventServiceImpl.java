package com.maple.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.maple.admin.dto.EventDto.EventSaveDto;
import com.maple.admin.entity.EventMaster;
import com.maple.admin.entity.QEventMaster;
import com.maple.admin.repositroy.EventRepository;
import com.maple.admin.service.EventService;
import com.maple.admin.util.ConstantUtil;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private JPAQueryFactory queryFactory;
	
	@Override
	public List<EventMaster> getEventList() throws Exception {
		QEventMaster event = QEventMaster.eventMaster;
		List<EventMaster> eventList = queryFactory
				.selectFrom(event)
				.orderBy(event.createDate.desc())
				.fetch();
		
		return eventList;
	}

	@Override
	public EventMaster saveEvent(EventSaveDto save) throws Exception {
		
		EventMaster saveEvent = EventMaster.builder()
				.even_code(save.getEven_code())
				.even_contents(save.getEven_contents())
				.even_stardate(save.getEven_stardate())
				.even_enddate(save.getEven_enddate())
				.even_name(save.getEven_name())
				.even_viewcnt(0)
			.build();
		
		EventMaster master = eventRepository.save(saveEvent);
		
		return master;
	}

	@Override
	public EventMaster getEventInfo(Integer eventno) throws Exception {
		QEventMaster event = QEventMaster.eventMaster;
		
		EventMaster eventInfo = queryFactory
				.selectFrom(event)
				.where(event.even_op.eq(eventno))
				.fetchOne();
		
		return eventInfo;
	}

	@Override
	public void updateEventInfo(EventSaveDto save) throws Exception {
		QEventMaster event = QEventMaster.eventMaster;
		
		queryFactory.update(event)
			.set(event.even_code, save.getEven_code())
			.set(event.even_name, save.getEven_name())
			.set(event.even_stardate, save.getEven_stardate())
			.set(event.even_enddate, save.getEven_enddate())
			.set(event.even_contents, save.getEven_contents())
			.execute();
	}

}
