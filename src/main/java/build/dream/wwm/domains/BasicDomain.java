package build.dream.wwm.domains;

import build.dream.wwm.annotations.Id;
import build.dream.wwm.annotations.InsertIgnore;
import build.dream.wwm.annotations.UpdateIgnore;
import build.dream.wwm.constants.Constants;
import build.dream.wwm.orm.GenerationStrategy;
import build.dream.wwm.utils.ObjectUtils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.Date;

public class BasicDomain implements IdDomain<Long>, Serializable, Cloneable {
    @Id(strategy = GenerationStrategy.AUTO_INCREMENT)
    @UpdateIgnore
    private Long id;

    @InsertIgnore
    @UpdateIgnore
    private Date createdTime;
    private BigInteger createdUserId;

    @InsertIgnore
    @UpdateIgnore
    private Date updatedTime;
    private BigInteger updatedUserId;
    private String updatedRemark = Constants.VARCHAR_DEFAULT_VALUE;

    @InsertIgnore
    private Date deletedTime = Constants.DATETIME_DEFAULT_VALUE;

    @InsertIgnore
    private boolean deleted;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public BigInteger getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(BigInteger createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public BigInteger getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(BigInteger updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public String getUpdatedRemark() {
        return updatedRemark;
    }

    public void setUpdatedRemark(String updatedRemark) {
        this.updatedRemark = updatedRemark;
    }

    public Date getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(Date deletedTime) {
        this.deletedTime = deletedTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public static class ColumnName {
        public static final String ID = "id";
        public static final String CREATED_TIME = "created_time";
        public static final String CREATED_USER_ID = "created_user_id";
        public static final String UPDATED_TIME = "updated_time";
        public static final String UPDATED_USER_ID = "updated_user_id";
        public static final String UPDATED_REMARK = "updated_remark";
        public static final String DELETED_TIME = "deleted_time";
        public static final String DELETED = "deleted";
    }

    public static class FieldName {
        public static final String ID = "id";
        public static final String CREATED_TIME = "createdTime";
        public static final String CREATED_USER_ID = "createdUserId";
        public static final String UPDATED_TIME = "updatedTime";
        public static final String UPDATED_USER_ID = "updatedUserId";
        public static final String UPDATED_REMARK = "updatedRemark";
        public static final String DELETED_TIME = "deletedTime";
        public static final String DELETED = "deleted";
    }

    protected abstract static class Builder<BT extends Builder<BT, IT>, IT extends BasicDomain> {
        private Class<IT> domainClass;
        protected IT instance;

        public Builder() {
            Type type = this.getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            domainClass = (Class<IT>) actualTypeArguments[1];
            instance = ObjectUtils.newInstance(domainClass);
        }

        public BT id(Long id) {
            instance.setId(id);
            return (BT) this;
        }

        public BT createdTime(Date createdTime) {
            instance.setCreatedTime(createdTime);
            return (BT) this;
        }

        public BT createdUserId(BigInteger createdUserId) {
            instance.setCreatedUserId(createdUserId);
            return (BT) this;
        }

        public BT updatedTime(Date updatedTime) {
            instance.setUpdatedTime(updatedTime);
            return (BT) this;
        }

        public BT updatedUserId(BigInteger updatedUserId) {
            instance.setUpdatedUserId(updatedUserId);
            return (BT) this;
        }

        public BT updatedRemark(String updatedRemark) {
            instance.setUpdatedRemark(updatedRemark);
            return (BT) this;
        }

        public BT deletedTime(Date deletedTime) {
            instance.setDeletedTime(deletedTime);
            return (BT) this;
        }

        public BT deleted(boolean deleted) {
            instance.setDeleted(deleted);
            return (BT) this;
        }

        protected IT build() {
            IT domain = ObjectUtils.newInstance(domainClass);
            domain.setId(instance.getId());
            domain.setCreatedTime(instance.getCreatedTime());
            domain.setCreatedUserId(instance.getCreatedUserId());
            domain.setUpdatedTime(instance.getUpdatedTime());
            domain.setUpdatedUserId(instance.getUpdatedUserId());
            domain.setUpdatedRemark(instance.getUpdatedRemark());
            domain.setDeletedTime(instance.getDeletedTime());
            domain.setDeleted(instance.isDeleted());
            return domain;
        }
    }
}
