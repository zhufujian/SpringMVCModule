package org.SpringMVCModule_interface.domain.request;

import java.util.Date;

import org.SpringMVCModule_interface.enums.StateEnum;
import org.SpringMVCModule_interface.validator.annotation.BaseElementsValidator;
import org.SpringMVCModule_interface.validator.annotation.EnumValue;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 
*
* @Description: 用户新增请求参数
* @ClassName: UserAddRequest 
* @author zhufj
* @date 2019年1月31日 下午5:05:33 
*
 */
@BaseElementsValidator(message = "request elements is not valid")
public class UserAddRequest extends BaseRequest{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotBlank(message = "id is blank")
	private String id;
	@NotBlank(message = "loginName is blank")
    private String loginName;
	@NotBlank(message = "password is blank")
    private String password;

    private String realName;
    @EnumValue(enumClass=StateEnum.class, enumMethod="isValidCode",message = "isForbidden illegal")
    @NotBlank(message = "isForbidden is blank")
    private String isForbidden;

    private String mobile;

    private String icon;

    private String orgId;

    private String orgName;
    private Date createDate;
    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIsForbidden() {
        return isForbidden;
    }

    public void setIsForbidden(String isForbidden) {
        this.isForbidden = isForbidden == null ? null : isForbidden.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

	@Override
	public String validateLogic() {
		// TODO Auto-generated method stub
		return null;
	}
}