package java_erp_teacher.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java_erp_teacher.dao.impl.TradeDaoImpl;
import java_erp_teacher.dto.Trade;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TradeDaoTest {
	
	private TradeDao dao = TradeDaoImpl.getInstance();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectTradeByAll() {
		System.out.println("testSelectTradeByAll()");
		ArrayList<Trade>list = dao.selectTradeByAll();
		Assert.assertNotEquals(0, list.size());
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testSelectTradeByNo() {
		fail("Not yet implemented");
	}

	@Test
	public void testIntsertTrade() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTrade() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTrade() {
		fail("Not yet implemented");
	}

}
