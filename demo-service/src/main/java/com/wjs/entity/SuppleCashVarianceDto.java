package com.wjs.entity;

import java.util.Date;
import java.math.BigDecimal;

/**
 * Created by 341039 on 2017/4/14.
 * 补录现金差异实体类
 */
public class SuppleCashVarianceDto {
    //运单号
    private  String waybillNo;
    /*
      开单日期(开单日期)
     */
    private Date billTime;
    /*
      补录日期(运单补录日期)
     */
    private Date postRecordedTime;

     /*
       开单付款方式
      */
    private String paymentMode;

    /*
       补录付款方式
     */
    private String supplePaymentMode;

    /*
      开单收入（元）(PDA开单现金金额)
     */
    private BigDecimal pdaBillCashAmount;


    /*
      补录收入（元）(补录为现金金额)
     */
    private BigDecimal suppleBillCashAmount;
    
    /*
      补录差额（元）(补录金额减去开单金额,补录收入减去开单收入)
	 */
	 private BigDecimal suppleBalanceAmount;
	 
	 /*
	  合计(补录差额之和)
	 */
	 private BigDecimal suppleBalanceSum;
	 
	 /*
	  开单现金总收入(PDA开单现金总收入)
	 */
	 private BigDecimal pdaBillCashTotalAmount;
	 /*
	  补录现金总收入(补录现金总收入)
	 */
	 private BigDecimal suppleCashTotalAmount;

}
