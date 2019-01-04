package example.zsltest;

public class M00_Customer {
    private String id;
    private String tmp_CONTACT_TEL;
    private String tmp_LEGAL_CARD_NO;
    private String tmp_CONTACT_MOBILE;
    private String tmp_REAL_CONTROL_CARD_NO;//控股股东证件号
    private String tmp_FINANCE_TEL;
    private String tmp_AUTHORIZE_CARD_NO;
    private String tmp_FINANCE_MOBILE;
    private String tmp_AUTHORIZE_MOBILE;
    private String tmp_LEGAL_TEL;
    private String tmp_LEGAL_MOBILE;
    private String CONTACT_TEL_ENC;
    private String LEGAL_CARD_NO_ENC;
    private String CONTACT_MOBILE_ENC;
    private String REAL_CONTROL_CARD_NO_ENC;//控股股东证件号加密
    private String FINANCE_TEL_ENC;//财务负责人电话加密
    private String AUTHORIZE_CARD_NO_ENC;//授权办理人证件号加密
    private String FINANCE_MOBILE_ENC;//财务负责人手机加密
    private String AUTHORIZE_MOBILE_ENC;//授权办理人手机加密
    private String LEGAL_TEL_ENC;//法人电话加密
    private String LEGAL_MOBILE_ENC;//法人手机加密

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTmp_CONTACT_TEL() {
        return tmp_CONTACT_TEL;
    }
    public void setTmp_CONTACT_TEL(String tmp_CONTACT_TEL) {
        this.tmp_CONTACT_TEL = tmp_CONTACT_TEL;
    }
    public String getTmp_LEGAL_CARD_NO() {
        return tmp_LEGAL_CARD_NO;
    }
    public void setTmp_LEGAL_CARD_NO(String tmp_LEGAL_CARD_NO) {
        this.tmp_LEGAL_CARD_NO = tmp_LEGAL_CARD_NO;
    }
    public String getTmp_CONTACT_MOBILE() {
        return tmp_CONTACT_MOBILE;
    }
    public void setTmp_CONTACT_MOBILE(String tmp_CONTACT_MOBILE) {
        this.tmp_CONTACT_MOBILE = tmp_CONTACT_MOBILE;
    }
    public String getTmp_REAL_CONTROL_CARD_NO() {
        return tmp_REAL_CONTROL_CARD_NO;
    }
    public void setTmp_REAL_CONTROL_CARD_NO(String tmp_REAL_CONTROL_CARD_NO) {
        this.tmp_REAL_CONTROL_CARD_NO = tmp_REAL_CONTROL_CARD_NO;
    }
    public String getTmp_FINANCE_TEL() {
        return tmp_FINANCE_TEL;
    }
    public void setTmp_FINANCE_TEL(String tmp_FINANCE_TEL) {
        this.tmp_FINANCE_TEL = tmp_FINANCE_TEL;
    }
    public String getTmp_AUTHORIZE_CARD_NO() {
        return tmp_AUTHORIZE_CARD_NO;
    }
    public void setTmp_AUTHORIZE_CARD_NO(String tmp_AUTHORIZE_CARD_NO) {
        this.tmp_AUTHORIZE_CARD_NO = tmp_AUTHORIZE_CARD_NO;
    }
    public String getTmp_FINANCE_MOBILE() {
        return tmp_FINANCE_MOBILE;
    }
    public void setTmp_FINANCE_MOBILE(String tmp_FINANCE_MOBILE) {
        this.tmp_FINANCE_MOBILE = tmp_FINANCE_MOBILE;
    }
    public String getTmp_AUTHORIZE_MOBILE() {
        return tmp_AUTHORIZE_MOBILE;
    }
    public void setTmp_AUTHORIZE_MOBILE(String tmp_AUTHORIZE_MOBILE) {
        this.tmp_AUTHORIZE_MOBILE = tmp_AUTHORIZE_MOBILE;
    }
    public String getTmp_LEGAL_TEL() {
        return tmp_LEGAL_TEL;
    }
    public void setTmp_LEGAL_TEL(String tmp_LEGAL_TEL) {
        this.tmp_LEGAL_TEL = tmp_LEGAL_TEL;
    }
    public String getTmp_LEGAL_MOBILE() {
        return tmp_LEGAL_MOBILE;
    }
    public void setTmp_LEGAL_MOBILE(String tmp_LEGAL_MOBILE) {
        this.tmp_LEGAL_MOBILE = tmp_LEGAL_MOBILE;
    }
    public String getCONTACT_TEL_ENC() {
        return CONTACT_TEL_ENC;
    }
    public void setCONTACT_TEL_ENC(String cONTACT_TEL_ENC) {
        CONTACT_TEL_ENC = cONTACT_TEL_ENC;
    }
    public String getLEGAL_CARD_NO_ENC() {
        return LEGAL_CARD_NO_ENC;
    }
    public void setLEGAL_CARD_NO_ENC(String lEGAL_CARD_NO_ENC) {
        LEGAL_CARD_NO_ENC = lEGAL_CARD_NO_ENC;
    }
    public String getCONTACT_MOBILE_ENC() {
        return CONTACT_MOBILE_ENC;
    }
    public void setCONTACT_MOBILE_ENC(String cONTACT_MOBILE_ENC) {
        CONTACT_MOBILE_ENC = cONTACT_MOBILE_ENC;
    }
    public String getREAL_CONTROL_CARD_NO_ENC() {
        return REAL_CONTROL_CARD_NO_ENC;
    }
    public void setREAL_CONTROL_CARD_NO_ENC(String rEAL_CONTROL_CARD_NO_ENC) {
        REAL_CONTROL_CARD_NO_ENC = rEAL_CONTROL_CARD_NO_ENC;
    }
    public String getFINANCE_TEL_ENC() {
        return FINANCE_TEL_ENC;
    }
    public void setFINANCE_TEL_ENC(String fINANCE_TEL_ENC) {
        FINANCE_TEL_ENC = fINANCE_TEL_ENC;
    }
    public String getAUTHORIZE_CARD_NO_ENC() {
        return AUTHORIZE_CARD_NO_ENC;
    }
    public void setAUTHORIZE_CARD_NO_ENC(String aUTHORIZE_CARD_NO_ENC) {
        AUTHORIZE_CARD_NO_ENC = aUTHORIZE_CARD_NO_ENC;
    }
    public String getFINANCE_MOBILE_ENC() {
        return FINANCE_MOBILE_ENC;
    }
    public void setFINANCE_MOBILE_ENC(String fINANCE_MOBILE_ENC) {
        FINANCE_MOBILE_ENC = fINANCE_MOBILE_ENC;
    }
    public String getAUTHORIZE_MOBILE_ENC() {
        return AUTHORIZE_MOBILE_ENC;
    }
    public void setAUTHORIZE_MOBILE_ENC(String aUTHORIZE_MOBILE_ENC) {
        AUTHORIZE_MOBILE_ENC = aUTHORIZE_MOBILE_ENC;
    }
    public String getLEGAL_TEL_ENC() {
        return LEGAL_TEL_ENC;
    }
    public void setLEGAL_TEL_ENC(String lEGAL_TEL_ENC) {
        LEGAL_TEL_ENC = lEGAL_TEL_ENC;
    }
    public String getLEGAL_MOBILE_ENC() {
        return LEGAL_MOBILE_ENC;
    }
    public void setLEGAL_MOBILE_ENC(String lEGAL_MOBILE_ENC) {
        LEGAL_MOBILE_ENC = lEGAL_MOBILE_ENC;
    }

}
