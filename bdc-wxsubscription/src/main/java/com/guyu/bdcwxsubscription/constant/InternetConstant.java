package com.guyu.bdcwxsubscription.constant;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 互联网收件常量类
 */
public class InternetConstant {

    /**
     * 登录拦截白名单
     */
    public static final Set<String> LOGIN_INTERCEPTE_WHITE_URLS;

    /**
     * 日志记录排除名单
     */
    public static final Set<String> LOG_EXCLUDE_URLS;

    static {
        LOGIN_INTERCEPTE_WHITE_URLS = new HashSet<>();
        LOGIN_INTERCEPTE_WHITE_URLS.add("/admin/login");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/admin/exit");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/admin/verify");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/admin/getPubKey");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/information/detail");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/rec/bdcflow");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/recdata/down");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/userData/down");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/tmpl/down");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/information/pageinate");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/sysconf/query");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/tmpl/paginate");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/biz/query");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/biz/queryAll");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/admin/VerifyCertAndGenRandom");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/admin/VerifyRandomSign");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/rec/viewElectronic");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/admin/HunanCaSign");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/admin/HunanCAlogin");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/rec/impBdcData");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/rec/getViewElectronic");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/statistics/getTrade");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/statistics/qyfccx");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/statistics/sjcx");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/sqqlr/pushqlrtobdc");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/dydjxx/pushqldjxxtobdc");

        LOGIN_INTERCEPTE_WHITE_URLS.add("/statistics/guihuaxinxi");

        LOGIN_INTERCEPTE_WHITE_URLS.add("/static/upload");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/static/upload/");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/static/upload/batch");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/static/upload/down");
        LOGIN_INTERCEPTE_WHITE_URLS.add("/v2/api-docs-ext");

        LOG_EXCLUDE_URLS = new HashSet<>();
        LOG_EXCLUDE_URLS.add("/log/paginate");
        LOG_EXCLUDE_URLS.add("/v2/api-docs-ext");
    }

    /**
     * 字符集UTF-8
     */
    public static final String CHARSET_UTF_8 = "UTF-8";

    /**
     * 字符集ISO-8859-1
     */
    public static final String CHARSET_ISO_8859_1 = "ISO-8859-1";

    /**
     * nacos地址-连州
     */
    public static final String LZ_NACOS_ADDR = "172.16.3.166:8848";
    /**
     * nacos地址-连南
     */
    public static final String LN_NACOS_ADDR = "172.25.225.200:8848";
    /**
     * nacos地址-常德
     */
    public static final String CD_NACOS_ADDR = "172.23.20.80:8848";
    /**
     * nacos地址-英德
     */
    public static final String YD_NACOS_ADDR = "192.168.1.241:8848";
    /**
     * nacos地址-长沙
     */
    public static final String CS_NACOS_ADDR = "192.168.0.108:8848";

    /**
     * 区县编码-长沙
     */
    public static final String AREACODE_CS = "430100";
    /**
     * 区县编码-常德
     */
    public static final String AREACODE_CD = "430702";
    /**
     * 区县编码-连州
     */
    public static final String AREACODE_LZ = "441882";
    /**
     * 区县编码-连南
     */
    public static final String AREACODE_LN = "441826";

    /**
     * '共有方式'字典名
     */
    public static final String DICTNAME_GYFS = "dict206";
    /**
     * '证件种类'字典名
     */
    public static final String DICTNAME_ZJZL = "dict202";
    /**
     * '权利人类型'字典名
     */
    public static final String DICTNAME_QLRLX = "dict208";
    /**
     * '性别'字典名
     */
    public static final String DICTNAME_XB = "dict215";
    /**
     * '国家和地区'字典名
     */
    public static final String DICTNAME_GJDQ = "dict207";
    /**
     * '查封类型'字典名
     */
    public static final String DICTNAME_CFLX = "dict204";
    /**
     * '省份'字典名
     */
    public static final String DICTNAME_SHENGFEN = "dict210";
    /**
     * '抵押方式'字典名
     */
    public static final String DICTNAME_DYFS = "dict200";
    /**
     * '房屋结构'字典名
     */
    public static final String DICTNAME_FWJG = "dict218";
    /**
     * '房屋性质'字典名
     */
    public static final String DICTNAME_FWXZ = "dict191";
    /**
     * '房屋用途'字典名
     */
    public static final String DICTNAME_FWYT = "dict189";
    /**
     * '登记类型'字典名
     */
    public static final String DICTNAME_DJLX = "dict193";

    /**
     * RSA最大加密明文大小
     */
    public static final int MAX_ENCRYPT_BLOCK = 256;

    /**
     * RSA最大解密密文大小
     */
    public static final int MAX_DECRYPT_BLOCK = 256;

    public static final int INITIALIZEKEYSIZE = 1024;


    /**
     * 湖南CA
     */
    public static final String HUCA_NUMBERSANDLETTERS = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 登录用户存放在redis中key的前缀
     */
    public static final String REDIS_KEY_LOGINER_PREFIX = "bdconline:loginer:";

    /**
     * 案卷材料在redis中的临时key
     */
    public static final String REDIS_KEY_REC_TEMPDATA_PREFIX = "bdconline:tempdata:";

    /**
     * 系统配置存放在redis中key的前缀
     */
    public static final String REDIS_KEY_SYS_CONFIG = "bdconline:sysconfig:";

    /**
     * rsa在redis中key的前缀
     */
    public static final String REDIS_KEY_RSA = "bdconline:rsa:";

    /**
     * request获取用户token的key
     */
    public static final String REQUEST_HEADER_KEY_LOGINER = "X-Access-Token";

    /**
     * request设置/获取 log标识的key
     */
    public static final String LOG_REQUEST_UUID_KEY = "log-uuid";

    /**
     * 预售商品房预告登记业务code
     */
    public static final String BIZCODE_YSSPFYGDJ = "ysspfygdj";

    /**
     * 预告预抵押合并登记业务code
     */
    public static final String BIZCODE_YGYDYHBDJ = "ygydyhbdj";

    public static final String BIZCODE_PLYGYDHBDJ = "ygydyhbdj";


    /**
     * 存量房转移登记业务code
     */
    public static final String BIZCODE_CLFZYDJ = "clfzydj";

    /**
     * 房屋变更登记业务code
     */
    public static final String BIZCODE_FWBGDJ = "fwbgdj";

    /**
     * 抵押注销登记业务code
     */
    public static final String BIZCODE_DYZXDJ = "dyzxdj";

    public static final String BIZCODE_CFDJ = "seizurerec";

    public static final String BIZCODE_PLDYDJ = "pldydj";

    public static final String BIZCODE_GSPFZYDJ = "xgspfajzy";

    public static final String BIZCODE_PLSCDJ = "plscdj";

    public static final String BIZCODE_GSPFQKZYDJ = "xgspfqkzy";

    public static final String BIZCODE_YBDYZHDK = "ybdyzhdk";

    public static final String BIZCODE_FWWXZJ = "fwwxzj";

    public static final String BIZCODE_YDYDJ = "ydydj";

    public static final String BIZCODE_YGYDZHDK = "ygydzhdk";

    public static final String BIZCODE_BJCX = "bjcx";

    /**
     * 登录后台
     */
    public static final String LOGIN_ADMIN = "1";

    /**
     * 登录前台
     */
    public static final String LOGIN_FRONT = "2";

    /**
     * 列表查询默认每页显示数量
     */
    public static final int PAGEINATE_SIZE = 20;

    /**
     * 未登录错误code
     */
    public static final int NOT_LOGIN_ERRCODE = 401;

    /**
     * 肯定状态, yes表 是/启用/有效 等状态
     */
    public static final int WHETHER_YES = 1;

    /**
     * 否定状态, not表 否/禁用/无效 等状态
     */
    public static final int WHETHER_NOT = 0;

    /**
     * 无权籍
     **/
    public static final int STATE_WQJ = 1;
    /**
     * 查封
     */
    public static final int STATE_CF = 12;
    /**
     * 异议
     */
    public static final int STATE_YY = 14;
    /**
     * 持证抵押
     */
    public static final int STATE_CZDY = 11;
    /**
     * 指定转移
     */
    public static final int STATE_ZDZY = 0;
    /**
     * 抵押预告
     */
    public static final int STATE_DYYG = 8;
    /**
     * 持证抵押预告
     */
    public static final int STATE_CZDYYG = 6;
    /**
     * 在建工程抵押
     */
    public static final int STATE_ZJGCDY = 13;
    /**
     * 持证转移预告
     */
    public static final int STATE_CZZYYG = 10;
    /**
     * 预告
     */
    public static final int STATE_YG = 7;
    /**
     * 权证发放
     */
    public static final int STATE_QZFF = 9;
    /**
     * 可售
     */
    public static final int STATE_KS = 3;
    /**
     * 其他限制
     */
    public static final int STATE_QTXZ = 17;

    /**
     * 房地一体区域字典
     */
    public enum FdytZones {
        LyhZone(5, "柳叶湖"), DsZone(4, "德山"), ThyZone(3, "桃花源"), GxZone(2, "高新"), WlZone(1, "武陵");
        final int val;
        final String text;

        FdytZones(int val, String text) {
            this.val = val;
            this.text = text;
        }

        public int getVal() {
            return val;
        }

        public String getText() {
            return text;
        }
    }

    /**
     * 用户类型
     */
    public enum UserType {
        OrgUser(1, "组织用户"), User(2, "个人用户");
        final int val;
        final String text;

        UserType(int val, String text) {
            this.val = val;
            this.text = text;
        }

        public int getVal() {
            return val;
        }

        public String getText() {
            return text;
        }

    }

    /**
     * 用户角色
     */
    public enum UserRole {
        Admin(10000, "管理员"), Receiver(10001, "收件"), Checker(10002, "审核");
        final int val;
        final String text;

        UserRole(int val, String text) {
            this.val = val;
            this.text = text;
        }

        public int getVal() {
            return val;
        }

        public String getText() {
            return text;
        }
    }

    /**
     * 用户状态
     */
    public enum UserStatus {
        Natural(1, "正常"), Disabled(2, "禁用");
        final int val;
        final String text;

        UserStatus(int val, String text) {
            this.val = val;
            this.text = text;
        }

        public int getVal() {
            return val;
        }

        public String getText() {
            return text;
        }

    }

    /**
     * 用户账号类型
     */
    public enum UserAccountType {
        OrgAccount(1, "组织账号"), Personal(3, "个人账号");
        final int val;
        final String text;

        UserAccountType(int val, String text) {
            this.val = val;
            this.text = text;
        }

        public int getVal() {
            return val;
        }

        public String getText() {
            return text;
        }

    }

    /**
     * 资讯类型
     */
    public enum InformationType {
        NewsInfo(1, "新闻资讯"), GovAffairsInfo(2, "政务资讯"), PropertyRight(3, "产权公示");
        final int val;
        final String text;

        InformationType(int val, String text) {
            this.val = val;
            this.text = text;
        }

        public int getVal() {
            return val;
        }

        public String getText() {
            return text;
        }

        public static InformationType getByVal(int val) {
            for (InformationType informationType : InformationType.values()) {
                if (informationType.getVal() == val) {
                    return informationType;
                }
            }
            return null;
        }
    }

    /**
     * 不动产操作类型
     */
    public enum BdcFlowOperat {
        REJECTED(-1, "驳回"), NORMAL(0, "正常流转"), FINISHED(1, "已办结");
        final int val;
        final String text;

        BdcFlowOperat(int val, String text) {
            this.val = val;
            this.text = text;
        }

        public int getVal() {
            return val;
        }

        public String getText() {
            return text;
        }

        public static BdcFlowOperat getByVal(int val) {
            for (BdcFlowOperat bdcFlowOperat : BdcFlowOperat.values()) {
                if (bdcFlowOperat.getVal() == val) {
                    return bdcFlowOperat;
                }
            }
            return null;
        }
    }

    /**
     * 案卷状态
     */
    public enum RecStatus {
        REJECTED(-1, "被驳回"), CREATED(0, "新创建"), SAVED(1, "已保存"), WAITCHECK(2, "待审核"), CHECKED(3, "已审核"), SUBMITTED(4, "提交办理"), FINISHED(5, "已办结");
        final int val;
        final String text;

        RecStatus(int val, String text) {
            this.val = val;
            this.text = text;
        }

        public int getVal() {
            return val;
        }

        public String getText() {
            return text;
        }

        public static RecStatus getByVal(int val) {
            for (RecStatus recStatus : RecStatus.values()) {
                if (recStatus.getVal() == val) {
                    return recStatus;
                }
            }
            return null;
        }
    }

    /**
     * 案卷人员区分
     */
    public enum RecPersonType {
        QLR(1, "权利人/抵押权人"), YWR(2, "义务人/抵押人"), YDQLR(3, "预抵权利人");
        final int val;
        final String text;

        RecPersonType(int val, String text) {
            this.val = val;
            this.text = text;
        }

        public int getVal() {
            return val;
        }

        public String getText() {
            return text;
        }

    }

    /**
     * 机构节点标识
     */
    public enum TreeNodeMark {
        ROOT(0, "根节点"), ORGROOT(1, "组织根节点"), PERSONROOT(2, "个人根节点"), ORG(3, "组织"), DEPT(4, "子组织"), PERSONNEL(5, "人员");
        final int val;
        final String text;

        TreeNodeMark(int val, String text) {
            this.val = val;
            this.text = text;
        }

        public int getVal() {
            return val;
        }

        public String getText() {
            return text;
        }

        public static TreeNodeMark getByVal(int val) {
            for (TreeNodeMark nodeMark : TreeNodeMark.values()) {
                if (nodeMark.getVal() == val) {
                    return nodeMark;
                }
            }
            return null;
        }
    }

    /**
     * 菜单功能类型
     */
    public enum FunctionType {
        MENU(1, "菜单"),
        FUNCTION(2, "功能");
        private int val;
        private String text;

        FunctionType(int val, String text) {
            this.val = val;
            this.text = text;
        }

        public int getVal() {
            return val;
        }

        public String getText() {
            return text;
        }
    }

    /**
     * 获取所有用户枚举
     */
    public static List<JSONObject> getUserTypes() {
        List<JSONObject> result = new ArrayList<>();
        for (UserType userType : UserType.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("val", userType.getVal());
            jsonObject.put("text", userType.getText());
            result.add(jsonObject);
        }
        return result;
    }

    /**
     * 获取所有用户状态枚举
     */
    public static List<JSONObject> getUserStatus() {
        List<JSONObject> result = new ArrayList<>();
        for (UserStatus userStatus : UserStatus.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("val", userStatus.getVal());
            jsonObject.put("text", userStatus.getText());
            result.add(jsonObject);
        }
        return result;
    }

    /**
     * 获取所有账户类型枚举
     */
    public static List<JSONObject> getUserAccountType() {
        List<JSONObject> result = new ArrayList<>();
        for (UserAccountType accountType : UserAccountType.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("val", accountType.getVal());
            jsonObject.put("text", accountType.getText());
            result.add(jsonObject);
        }
        return result;
    }

    /**
     * 获取所有房地一体数据区域枚举
     */
    public static List<JSONObject> getFdytZones() {
        List<JSONObject> result = new ArrayList<>();
        for (FdytZones fdytZones : FdytZones.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("val", fdytZones.getVal());
            jsonObject.put("text", fdytZones.getText());
            result.add(jsonObject);
        }
        return result;
    }


    /**
     * 获取所有资讯类型枚举
     */
    public static List<JSONObject> getInformationType() {
        List<JSONObject> result = new ArrayList<>();
        for (InformationType infoType : InformationType.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("val", infoType.getVal());
            jsonObject.put("text", infoType.getText());
            result.add(jsonObject);
        }
        return result;
    }

    /**
     * 获取所有案卷状态枚举
     */
    public static List<JSONObject> getRecStatus() {
        List<JSONObject> result = new ArrayList<>();
        for (RecStatus recStatus : RecStatus.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("val", recStatus.getVal());
            jsonObject.put("text", recStatus.getText());
            result.add(jsonObject);
        }
        return result;
    }

    public static List<JSONObject> getRecPersonType() {
        List<JSONObject> result = new ArrayList<>();
        for (RecPersonType recPersonType : RecPersonType.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("val", recPersonType.getVal());
            jsonObject.put("text", recPersonType.getText());
            result.add(jsonObject);
        }
        return result;
    }

    /**
     * 获取所有机构节点类型
     */
    public static List<JSONObject> getTreeNodeMark() {
        List<JSONObject> result = new ArrayList<>();
        for (TreeNodeMark mark : TreeNodeMark.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("val", mark.getVal());
            jsonObject.put("text", mark.getText());
            result.add(jsonObject);
        }
        return result;
    }

    public static List<JSONObject> getUserRole() {
        List<JSONObject> result = new ArrayList<>();
        for (UserRole role : UserRole.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("val", role.getVal());
            jsonObject.put("text", role.getText());
            result.add(jsonObject);
        }
        return result;
    }

}
