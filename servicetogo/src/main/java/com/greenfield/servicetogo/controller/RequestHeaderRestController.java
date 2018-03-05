package com.greenfield.servicetogo.controller;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greenfield.servicetogo.dto.RequestHeaderDTO;
import com.greenfield.servicetogo.entity.RequestHeaderEntity;
import com.greenfield.servicetogo.service.RequestHeaderService;

@RestController
public class RequestHeaderRestController {

	
		@Autowired
		private RequestHeaderService rhService;

		//@GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET).
		@GetMapping("/requestHeaders")
		public List<RequestHeaderDTO> getRequestHeaders() {
			return rhService.findAllRequest();
		}

		@GetMapping("/requestHeaders/{reqId}")
		public RequestHeaderDTO getRequest(@PathVariable("reqId") Integer reqId) {

			RequestHeaderDTO rhDTO = rhService.findRequestById(reqId);
			return rhDTO;
		}

		@PostMapping(value = "/requestHeaders")
		public RequestHeaderDTO createRequestHeader(@RequestBody RequestHeaderDTO rhDTO) {
			//RequestHeaderDTO rhDTO1 = new RequestHeaderDTO("Auto", "Sajay", new Date());
			RequestHeaderDTO resultDTO=rhService.addRequest(rhDTO);

			return resultDTO;
		}

		@DeleteMapping("/requestHeaders/{reqId}")
		public ResponseEntity<String> deleteRequestHeader(@PathVariable Integer reqId) {

			rhService.deleteRequestById(reqId);

			return new ResponseEntity<String>(reqId.toString(), HttpStatus.OK);

		}

		@PutMapping("/requestHeaders")
		public RequestHeaderDTO updateRequestHeader(@RequestBody RequestHeaderDTO rhDTO) {

			RequestHeaderDTO resultDTO = rhService.updateRequest(rhDTO);
			return resultDTO;
		}

}
