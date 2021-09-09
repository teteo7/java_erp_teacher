package java_erp_teacher.dao;

import java.util.ArrayList;

import java_erp_teacher.dto.Trade;

public interface TradeDao {
	
	ArrayList<Trade> selectTradeByAll();
	Trade selectTradeByNo(Trade trade);
	
	int intsertTrade(Trade trade);
	int updateTrade(Trade trade);
	int deleteTrade(Trade trade);	

}
