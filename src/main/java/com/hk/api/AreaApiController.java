package com.hk.api;

import java.util.List;

import javax.validation.Valid;

import com.hk.model.Area;
import com.hk.service.AreaService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AreaApiController implements AreaApi {

	private static final Logger log = LoggerFactory.getLogger(AreaApiController.class);

	@Autowired
	AreaService areaService;

	/**
	 * This function adds new priority area in the database.
	 * @param body JSON object of Area in the format
	 * {
	 *   "areaName": "string"
	 * }
	 */
	public ResponseEntity<Void> addArea(@Parameter(in = ParameterIn.DEFAULT, description = "Area object that needs to be added to the database", required = true, schema = @Schema()) @Valid @RequestBody Area body) {
		try {
			log.debug("inside addArea");
			areaService.addArea(body);
			log.debug("adding priority area is successful");
			log.debug("returning httpStatus 200");
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		catch (Exception e) {
			/**
			 * if there is some error occurred while saving priority area.
			 */
			log.error("Some Error Occurred while saving");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Area>> getAreas() {
		try {
			List<Area> areaList = areaService.getAreas();
			if (!areaList.isEmpty()) {
				return new ResponseEntity<>(areaList, HttpStatus.OK);
			}
			else {
				/**
				 * If there is no Priority Area in the db, service will return Error Code 204
				 */
				return new ResponseEntity<>(areaList, HttpStatus.NO_CONTENT);
			}
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
