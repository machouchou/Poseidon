package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;

@Component
public class CurvePointService {
	
	final Logger logger = LogManager.getLogger(CurvePointService.class);

	private final CurvePointRepository curvePointRepository;
	
	public CurvePointService(CurvePointRepository curvePointRepository) {
		this.curvePointRepository = curvePointRepository;
	}
	
	public List<CurvePoint> findAll() {
		logger.debug("Curve Point List");
		return curvePointRepository.findAll();
	}
	
	public CurvePoint save(CurvePoint curvePoint) {
		logger.debug("Curve Point saved");
		 return curvePointRepository.save(curvePoint);
	}
	public Optional<CurvePoint> findById(Integer id) {
		logger.debug("curve point found by Id");
		 return curvePointRepository.findById(id);
	}
	
	public void delete(CurvePoint curvePoint) {
		logger.debug("Curve point Removed");
		 curvePointRepository.delete(curvePoint);
	}
}
