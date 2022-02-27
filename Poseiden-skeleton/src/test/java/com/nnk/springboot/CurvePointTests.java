package com.nnk.springboot;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.CurvePointService;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CurvePointTests {

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
	
	/*Update
		curvePoint.setCurveId(20);
		curvePoint = curvePointRepository.save(curvePoint);
		Assert.assertTrue(curvePoint.getCurveId() == 20);

		// Find
		List<CurvePoint> listResult = curvePointRepository.findAll();
		Assert.assertTrue(listResult.size() > 0);
*/
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
