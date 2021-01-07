package com.hk.service;

import java.util.ArrayList;
import java.util.List;
import com.hk.entity.AreaEntity;
import com.hk.entity.PriorityEntity;
import com.hk.entity.UserEntity;
import com.hk.model.Priority;
import com.hk.model.User;
import com.hk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hilal Kaldane
 */

/**
 * Service is created to separate DAO from DTO
 * All the business logics are written in this layer
 */

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public void addPriority(User user) {
		UserEntity userEntity = new UserEntity();
		List<PriorityEntity> priorityEntities = new ArrayList<>();
		for (Priority priority : user.getPriorityList()) {
			PriorityEntity priorityEntity = new PriorityEntity();
			priorityEntity.setPriority(priority.getPriority());
			priorityEntity.setPriorityRating(priority.getPriorityRating());
			AreaEntity areaEntity = new AreaEntity();
			areaEntity.setAreaId(priority.getPriorityArea().getAreaId());
			priorityEntity.setPriorityArea(areaEntity);
			priorityEntity.setUserId(userEntity);
			priorityEntities.add(priorityEntity);
		}
		userEntity.setPriorityList(priorityEntities);
		userRepository.save(userEntity);
	}
}
