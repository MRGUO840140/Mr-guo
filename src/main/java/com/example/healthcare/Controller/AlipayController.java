package com.example.healthcare.Controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.example.healthcare.Service.DoctorService;
import com.example.healthcare.Service.OrdinglistService;
import com.example.healthcare.Service.PriceService;
import com.example.healthcare.bean.Doctor;
import com.example.healthcare.bean.Ordinglist;
import com.example.healthcare.bean.Price;
import com.example.healthcare.config.AlipayConfig;
import com.example.healthcare.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;


@RequestMapping("/alipay")
@Controller
public class AlipayController {
    Ordinglist ording;
    // 获取配置文件的信息
    String app_id = AlipayConfig.app_id;
    String private_key = AlipayConfig.private_key;
    String notify_url = AlipayConfig.notify_url;
    String return_url = AlipayConfig.return_url;
    String url = AlipayConfig.url;
    String charset = AlipayConfig.charset;
    String format = AlipayConfig.format;
    String public_key = AlipayConfig.public_key;
    String signtype = AlipayConfig.signtype;

    //自己添加的支付接口
    String myreturn_url=AlipayConfig.myreturn_url;


    @Autowired
    private OrdinglistService ordinglistService;
    @Autowired
    private PriceService priceService;
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/chatpay")
    public void mypay(HttpServletRequest request, HttpServletResponse response, String Did, HttpSession session) throws Exception {

        Doctor doc = doctorService.getDoc(Did);
        Price priceByChat = priceService.getPriceByChat(doc.getTitle().getDTid());
        // 模拟从前台传来的数据
        String orderNo =String.valueOf(UUID.randomUUID()) ; // 生成订单号
        String totalAmount = String.valueOf(priceByChat.getPrice()); // 支付总金额
        String subject = "ITAEMBook"; // 订单名称
        String body = "reading"; // 商品描述

        // 封装请求客户端
        AlipayClient client = new DefaultAlipayClient(url, app_id, private_key, format, charset, public_key, signtype);

        // 支付请求
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(myreturn_url);
        alipayRequest.setNotifyUrl(notify_url);
        AlipayTradePayModel model = new AlipayTradePayModel();
        model.setProductCode("FAST_INSTANT_TRADE_PAY"); // 设置销售产品码
        model.setOutTradeNo(orderNo); // 设置订单号
        model.setSubject(subject); // 订单名称
        model.setTotalAmount(totalAmount); // 支付总金额
        model.setBody(body); // 设置商品描述
        alipayRequest.setBizModel(model);

        String form = client.pageExecute(alipayRequest).getBody(); // 生成表单

        response.setContentType("text/html;charset=" + charset);
        response.getWriter().write(form); // 直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }













    /**
     * 支付请求
     *
     * @param
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/pay")
    public void pay(HttpServletRequest request, HttpServletResponse response, Integer ordingId, HttpSession session) throws Exception {
         ording = ordinglistService.getOrding(ordingId);
        Double price = ording.getPrice().getPrice();

        // 模拟从前台传来的数据
        String orderNo =String.valueOf(UUID.randomUUID()) ; // 生成订单号
        String totalAmount = String.valueOf(price); // 支付总金额
        String subject = "ITAEMBook"; // 订单名称
        String body = "reading"; // 商品描述

        // 封装请求客户端
        AlipayClient client = new DefaultAlipayClient(url, app_id, private_key, format, charset, public_key, signtype);

        // 支付请求
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);
        AlipayTradePayModel model = new AlipayTradePayModel();
        model.setProductCode("FAST_INSTANT_TRADE_PAY"); // 设置销售产品码
        model.setOutTradeNo(orderNo); // 设置订单号
        model.setSubject(subject); // 订单名称
        model.setTotalAmount(totalAmount); // 支付总金额
        model.setBody(body); // 设置商品描述
        alipayRequest.setBizModel(model);

        String form = client.pageExecute(alipayRequest).getBody(); // 生成表单

        response.setContentType("text/html;charset=" + charset);
        response.getWriter().write(form); // 直接将完整的表单html输出到页面
        response.getWriter().flush();
        ordinglistService.updateIspay(ordingId);
        response.getWriter().close();
    }

    /**
     * 同步跳转
     *
     * @param request
     * @throws Exception
     */
    @RequestMapping("/returnUrl")
    public ModelAndView returnUrl(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();

        // 获取支付宝GET过来反馈信息（官方固定代码）
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, public_key, charset, signtype); // 调用SDK验证签名

       /* ordinglistService.getOrding(ording.getOrdingId());*/
        // 返回界面
        if (signVerified) {
            System.out.println("前往支付成功页面");
            mav.setViewName("successReturn");
        } else {
            System.out.println("前往支付失败页面");
            mav.setViewName("failReturn");

        }
        return mav;
    }

    /**
     * 支付宝服务器异步通知
     *
     * @param request
     * @throws Exception
     */
    @RequestMapping("/notifyUrl")
    public void notifyUrl(HttpServletRequest request) throws Exception {
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }


        boolean signVerified = AlipaySignature.rsaCheckV1(params, public_key, charset, signtype); // 调用SDK验证签名

        if (signVerified) { // 验证成功 更新订单信息
            System.out.println("异步通知成功");
            // 商户订单号
            String out_trade_no = request.getParameter("out_trade_no");
            // 交易状态
            String trade_status = request.getParameter("trade_status");
            // 修改数据库
            if(trade_status.equals("TRADE_SUCCESS")){
                ordinglistService.getOrding(ording.getOrdingId());
            }
        } else {
            System.out.println("异步通知失败");
        }
    }
}
