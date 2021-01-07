package com.hk.service;

import java.util.ArrayList;
import java.util.List;

import com.hk.entity.AreaEntity;
import com.hk.model.Area;
import com.hk.repository.AreaRepository;

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
public class AreaService {
	@Autowired
	AreaRepository areaRepository;

	public void addArea(Area area) {
		AreaEntity areaEntity = new AreaEntity();
		areaEntity.setAreaName(area.getAreaName());
		areaRepository.save(areaEntity);
	}

	/**
	 * This method returns all the priorityAreas stored inside the database
	 * @return Lists of Areas
	 */
	public List<Area> getAreas() {
		List<Area> areaList = new ArrayList<>();
		for (AreaEntity areaEntity : areaRepository.findAll()) {
			Area area = new Area();
			area.setAreaName(areaEntity.getAreaName());
			area.setAreaId(areaEntity.getAreaId());
			areaList.add(area);
		}
		return areaList;
	}

}
