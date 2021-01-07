package com.hk.api;

import com.hk.model.User;
import com.hk.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PriorityApiController implements PriorityApi {
	private static final Logger log = LoggerFactory.getLogger(PriorityApiController.class);

	// Autowired the service so that spring creates only one object
	@Autowired
	UserService userService;

	/** One user can create the priority only once, hence the parent of all the object is user
	 * @param body JSON formatted user data in format
	 * {
	 *   "priorities": [
	 *     {
	 *       "priority": 0,
	 *       "priorityArea": {
	 *         "areaId": 0
	 *       },
	 *       "priorityRating": 0
	 *     },
	 *     {
	 *       "priority": 0,
	 *       "priorityArea": {
	 *         "areaId": 0
	 *       },
	 *       "priorityRating": 0
	 *     }
	 *   ]
	 * }
	 *
	 * areaId should already present in the database, to extract all the present priorityAreas in the db,
	 * areaName is not required
	 * make a Get request to /area/getAreas
	 */
	public ResponseEntity<Void> addPriority(@Parameter(in = ParameterIn.DEFAULT, description = "Priority object that needs to be added to the database", required = true) @RequestBody User body) {
		try {
			log.debug("inside addPriority");
			userService.addPriority(body);
			log.debug("adding priority is successful");
			log.debug("returning httpStatus 200");
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			/**
			 * if there is some error like, user adds same priorityArea twice, then application will throw
			 * ConstraintViolationException
			 */
			log.error("Some Error Occurred while saving");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
