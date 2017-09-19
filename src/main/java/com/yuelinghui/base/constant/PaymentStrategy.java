package com.yuelinghui.base.constant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * 支付策略
 * 
 *
 * @author caixb
 */
public class PaymentStrategy {
	
	
	public static Map<Integer, Strategy> ps = new HashMap<Integer, Strategy>();
	static{
		Strategy strategy = new Strategy();
		strategy.setStrategyId(1);
		strategy.setStrategyName("微信支付"); //微信订阅号支付
		strategy.setPayUrl("wxpay/pay");
		ps.put(1, strategy);	
	}
	
	
	static class Strategy implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private Integer strategyId;			//支付策略id
		private String StrategyName;		//支付策略名
		private String payUrl;				//支付url

		public Integer getStrategyId() {
			return strategyId;
		}
		public void setStrategyId(Integer strategyId) {
			this.strategyId = strategyId;
		}
		public String getStrategyName() {
			return StrategyName;
		}
		public void setStrategyName(String strategyName) {
			StrategyName = strategyName;
		}
		public String getPayUrl() {
			return payUrl;
		}
		public void setPayUrl(String payUrl) {
			this.payUrl = payUrl;
		}
	}
	

}
