package com.yuelinghui.service.vo;
import java.math.BigDecimal;
import java.util.Date;
import cn.assist.easydao.annotation.Id;
import cn.assist.easydao.annotation.Temporary;
import cn.assist.easydao.pojo.BasePojo;

/**
 *产品 
 *
 * @author caixb
 */
public class Product extends BasePojo {
	@Temporary
	private static final long serialVersionUID = 1L;
	@Id
	private String pid;
	private String name;//名称
	private String title;//标题
	private Integer productGroupType;//类型 一级分类id
	private BigDecimal price;//价格
	private Integer status;//状态
	private String imageUrl;//列表图片
	private Date releaseTime;//发布时间
	private String label;//产品标签
	private String info;//产品详情
	private Date createTime;
	private Date updateTime;
	private String remark;
	private Integer stock;//库存
	private Integer remaining;//剩余库存
	private BigDecimal originalPrice;//进货价
	private Integer supplierId;//供应商
	
	public Product() {
		super();
	}
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public Integer getProductGroupType() {
		return productGroupType;
	}
	public void setProductGroupType(Integer productGroupType) {
		this.productGroupType = productGroupType;
	}
	public void setPrice(BigDecimal price){
		this.price=price;
	}
	public BigDecimal getPrice(){
		return price;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
	public Integer getStatus(){
		return status;
	}
	public void setReleaseTime(Date releaseTime){
		this.releaseTime=releaseTime;
	}
	public Date getReleaseTime(){
		return releaseTime;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setUpdateTime(Date updateTime){
		this.updateTime=updateTime;
	}
	public Date getUpdateTime(){
		return updateTime;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getRemaining() {
		return remaining;
	}
	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}
	public void setOriginalPrice(BigDecimal originalPrice){
		this.originalPrice=originalPrice;
	}
	public BigDecimal getOriginalPrice(){
		return originalPrice;
	}
	public void setSupplierId(Integer supplierId){
		this.supplierId=supplierId;
	}
	public Integer getSupplierId(){
		return supplierId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}

