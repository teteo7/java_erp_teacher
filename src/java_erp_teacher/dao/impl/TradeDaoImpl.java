package java_erp_teacher.dao.impl;

import java.util.ArrayList;

import java_erp_teacher.dao.TradeDao;
import java_erp_teacher.dto.Trade;

public class TradeDaoImpl implements TradeDao {
	
	public static final TradeDaoImpl instance = new TradeDaoImpl();
	
	public static TradeDaoImpl getInstance() {
		return instance;
	}
	public TradeDaoImpl() {
	}
	
	@Override
	public ArrayList<Trade> selectTradeByAll() {
		String sql = "select * from Trade";
		ArrayList<Trade> list = null;
		
		
		return null;
	}

	@Override
	public Trade selectTradeByNo(Trade trade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int intsertTrade(Trade trade) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTrade(Trade trade) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTrade(Trade trade) {
		// TODO Auto-generated method stub
		return 0;
	}

}
