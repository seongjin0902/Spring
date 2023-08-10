package com.test.app.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class RestController_03Download {

	@GetMapping(value="/download")
	public void Download(String path)
	{
		log.info("RestController_03Download's Download 콜~" + path);
	}
	
}
