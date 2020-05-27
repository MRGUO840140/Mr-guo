package com.example.healthcare.config;

public class AlipayConfig {

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ APPID（填自己的，下面都是改过的~）
    public static String app_id = "2016101200672231";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 生成公钥时对应的私钥（填自己的，下面都是改过的~）
    public static String private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCAr5/5wHLP/ixeOzghQjCEyEu+MvBTSmkz2fVgWQDncJO7OdLtC6GcopwjgSUFvzB1WBaLMvCg4jYet4dwL2ERxQkdEunRzEPby4kChB28haSOVCcbmPAsTMA/aMiL/L+icLSxQKprhMCeDt+udkmJILZsjh1+DQCOWoglCFIuuZU2QdIy84T1W2SFIN+zLhEIY0wd0ZLCDbfM+zztsv6BFqQjYSVzCDi5KAvz+y8EVJJtK8G9JUdkZmyMGmBJ2jEgxn+3f4ysQOJRrluMyOWtZjqBSNOUUTBUkyImSbBoefQ0UWEAWoTrVb0FIJtPEVAPSAIPWnjAo7x6lgwVllmfAgMBAAECggEARowBT5HJX20gNaiRZOo8Xw7PNz4FsiOg+OQMOP2SGU8GLiXNFFbECnK61lv+R+BAWJQqB7WtZQWeVciXX1EaDfvOuzmbJYCt0tkKC28SPj+lrsFDj0WQpTiOTDTNfLDa/dp7tJCW3MqyLfRJfAMs3Rgp6ekfEfNe0que525gX2xjmrd8BAdI4S3J40n/MEelCfzdOuAVS+bsm3h7cTlCRBgWLOeLUnlbPropZkikArid1oYfDrabaQkwSBEgTP2+QjXJftcCLrayk4IFUmLP3m9C3FoRpAAVKcwkF7Hq0UIb+nzuqHZtWH8mNnzYR/Um5+X6iAn2j1/+rCEPaSdaQQKBgQDaDvTmyd+ZUumRVUHLsWkwTon/zB5WEm1oMk6UGBff7pYymrrIBd6GkkHEwziGfMhwo+bKvQIbZZid+gzQjrODOiSoXKpbAklJl9wGa8LtBZhTInBmeyxOz/LxR6am6W60tz0tyB+WhpBYRoAJY3LSNgrZGwczhQDNaWNWW8ERywKBgQCXE7n5otrwiJMmWLb8yl7cnDGZ5uVXZFoxmoYwt5bDKJLW2XBwR627Gc6tkIK94bFoaz5QD8XXzfoIIm5oIKFTjTkLIzHCaRdztxwWn1c9yoZ4TZhtHKp8x9KnS1sGSA7b3yylaj4U/gUTMLmo+OtIWAkZWYfHs/rYorp3LY7M/QKBgFsMC62hdL8sI2IPWx2VwfntkSlBLRl7MDtlZfHn7XAOyp/ugzapXLSLtPJXIO7mgzqk9OSJ7qtJzGOJ2HfsXX/ZcxzpNCgz2C3mPnRf4k/dGjD8HDpuC54Mrb+Yzzi6FwNVzzGica4EGZkCNsu0vmiPMBBefK9CRYd/DX8taHvpAoGAJF6SWd9zt44ZZpTa0HZjadaMNlGYinZVJDXf8iBwQeEloGVOJSmMUEuBLtVoNA/+JnYS1TFG3pHujEDFtXmNfNC1l9HMK9Ii3C+LqoKHfQ+hWZrMhA/vlwR/2NhSPGvib9oFJHk0IteYHyuOtnfeJFdVMW4VOuVAESDzpLcp9n0CgYAsifQ/jSzrZrc9JpLz+2HN12y6IEsBGXOlgt+ShMwcPzO0Rvh5ZIAemwmT1lUFg4dXRh1A+bZ3FMW63WWyMfc7vkfG8aUnOo+r8AVOpBtLhYonPWkoZ4pgXWlLaRbef3GZ57ajFeRrlYRmZC11LNBGUUu0qtHzOxe6TyqD3Lw0RQ==";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String notify_url = "http://www.linhongcun.com/SpringBootPay-0.0.1-SNAPSHOT/pay/notifyUrl";

    //Controller Mapping:得放到服务器上，且使用域名解析 IP
    public static String return_url = "http://localhost:8088/user/center";

//    public static String return_url = "http://182.92.232.6:8088/user/center";
    //自己定义的支付接口
    public static String myreturn_url = "http://localhost:8088/user/chat";

   /* public static String myreturn_url = "http://182.92.232.6:8088/user/chat";*/
    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 支付宝网关（注意沙箱alipaydev，正式则为 alipay）
    public static String url = "https://openapi.alipaydev.com/gateway.do";

    public static String charset = "UTF-8";

    public static String format = "json";

    //开发者中心 / 研发服务 / 沙箱环境 / 沙箱应用/ 信息配置/ 必看部分/ 公钥（填自己的，下面都是改过的~）
    public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn3oZmISAZReqRKYPALjsnEIEF4DPKtO803GuJgr9CAwd9eqnf3GOzGXGRLiY2Qi3TtI6M07VrSNoh0KggYGUpy9BU2VIJ0sMhMN/xvIWW02dPP5LOWRqXKlGxu4l89Er752zmIaCdyM/XqDzOrZwXilQqFc6w9TctF7RwRRxTS+efKQptZHC2461b+HX1gCSicDolNAhkXZU5hfHMP2RC2Dp+b+vMB7Bql5Mv38HKr9SiNr+MXbRwu7hqiBco9tykg4L3iJdfDypRDajmZpgrFMRo+OrWzaClL0U7DLbLNBYPnAatVMZLXoMOX//bfA2FtiTihw9YND3NuWaQsQUTQIDAQAB";

    public static String signtype = "RSA2";

}
