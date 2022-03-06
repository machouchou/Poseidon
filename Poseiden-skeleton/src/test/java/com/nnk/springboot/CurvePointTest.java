package com.nnk.springboot;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.CurvePointService;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CurvePointTest {

	private CurvePointRepository curvePointRepository = Mockito.mock(CurvePointRepository.class);

	private static CurvePointService curvePointService;
	
	/*@Before
	private static void init() {
		curvePointService = new CurvePointService(curvePointRepository);
	}*/
	@Test
	public void saveCurvePointTest() {
		curvePointService = new CurvePointService(curvePointRepository);
		CurvePoint curvePoint = new CurvePoint();
		curvePoint.setCurveId(10);
		curvePoint.setTerm(10d);
		curvePoint.setValue(10d);
		curvePoint.setId(1);
		
		when(curvePointRepository.save(Mockito.any(CurvePoint.class))).thenReturn(curvePoint);
		// Save
		CurvePoint curvePointResult = curvePointService.save(curvePoint);
		Assert.assertNotNull(curvePointResult.getId());
		assertEquals(curvePoint.getCurveId(), curvePointResult.getCurveId());
	}
	
	@Test
	public void findAllCurve() {
		
		CurvePoint curvePoint1 = new CurvePoint();
		curvePoint1.setCurveId(8);
		curvePoint1.setTerm(10d);
		curvePoint1.setValue(10d);
		curvePoint1.setId(3);
		
		CurvePoint curvePoint2 = new CurvePoint();
		curvePoint2.setCurveId(9);
		curvePoint2.setTerm(7d);
		curvePoint2.setValue(6d);
		curvePoint2.setId(6);
		
		List<CurvePoint> lCurve = new ArrayList<>();
		lCurve.add(curvePoint1);
		lCurve.add(curvePoint2);
		
		when(curvePointRepository.findAll()).thenReturn(lCurve);
		
		curvePointService = new CurvePointService(curvePointRepository);
		List<CurvePoint> curves = curvePointService.findAll();
		
		assertNotEquals(Collections.EMPTY_LIST, curves.size());
		assertEquals(lCurve.size(), curves.size());
		assertTrue(lCurve.stream().anyMatch(curve ->curve.getValue().equals(curvePoint1.getValue())));
		
	}
	@Test
	public void findByIdTest() {
		curvePointService = new CurvePointService(curvePointRepository);
		
		CurvePoint curvePoint = new CurvePoint();
		curvePoint.setCurveId(8);
		curvePoint.setTerm(10d);
		curvePoint.setValue(10d);
		curvePoint.setId(6);
		
		Optional<CurvePoint> optResult = Optional.of(curvePoint);
		
		when(curvePointRepository.findById(6)).thenReturn(optResult);
		
		Optional<CurvePoint> optCurve = curvePointService.findById(6);
		
		assertEquals(optResult.get().getValue(), optCurve.get().getValue());
	}
	@Test
	public void deleteCurvePointTest() {
		curvePointService = new CurvePointService(curvePointRepository);
		CurvePoint curvePoint = new CurvePoint();
		curvePoint.setCurveId(5);
		curvePoint.setTerm(5d);
		curvePoint.setValue(5d);
		curvePoint.setId(2);
		
		doNothing().when(curvePointRepository).delete(Mockito.any(CurvePoint.class));
		curvePointService.delete(curvePoint);
		verify(curvePointRepository, times(1)).delete(Mockito.any(CurvePoint.class));
	}

}
