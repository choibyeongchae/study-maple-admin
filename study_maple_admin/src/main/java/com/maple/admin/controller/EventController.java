package com.maple.admin.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maple.admin.dto.EventDto;
import com.maple.admin.entity.EventMaster;
import com.maple.admin.service.EventService;
import com.maple.admin.util.SuccessResponse;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/event/core")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@ApiOperation("이벤트 등록")
	@PostMapping("/save")
	@Transactional(readOnly = false)
	@ResponseBody
	public SuccessResponse saveEvent(EventDto.EventSaveDto save,HttpServletResponse response) throws Exception {
		
		EventMaster saveEvent = eventService.saveEvent(save);
		
		return new SuccessResponse(response.SC_OK, "정상적으로 등록되었습니다.", saveEvent);
	}
	
	@ApiOperation("이벤트 상세")
	@GetMapping("/getInfo")
	@Transactional(readOnly = true)
	@ResponseBody
	public SuccessResponse getEventInfo(@RequestParam("eventno") Integer eventno, HttpServletResponse response) throws Exception {
		
		EventMaster eventInfo = eventService.getEventInfo(eventno);
		
		return new SuccessResponse(response.SC_OK, "정상적으로 조회되었습니다.", eventInfo);
	}
	
	@ApiOperation("이벤트 수정")
	@PostMapping("/update")
	@Transactional(readOnly = false)
	@ResponseBody
	public SuccessResponse updateEventInfo(EventDto.EventSaveDto save, HttpServletResponse response) throws Exception {
		
		eventService.updateEventInfo(save);
		
		return new SuccessResponse(response.SC_OK, "정상적으로 수정되었습니다.", null);
	}
	
}
