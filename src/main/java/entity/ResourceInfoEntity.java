package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by peng on 2017/3/22.
 */
@Entity
@Table(name = "resource_info", schema = "PlanterDatabase", catalog = "")
public class ResourceInfoEntity {
    private String resourceId;
    private String resourceUploadTime;
    private String resourceUrl;
    private String resourceName;
    private Integer resourceDownloadCount;
    private Integer resourceLikeCount;
    private String resourceSavePath;

    @Basic
    @Column(name = "resource_upload_time")
    public String getResourceUploadTime() {
        return resourceUploadTime;
    }

    public void setResourceUploadTime(String resourceUploadTime) {
        this.resourceUploadTime = resourceUploadTime;
    }

    @Id
    @Column(name = "resource_id")
    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Basic
    @Column(name = "resource_url")
    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    @Basic
    @Column(name = "resource_name")
    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Basic
    @Column(name = "resource_download_count")
    public Integer getResourceDownloadCount() {
        return resourceDownloadCount;
    }

    public void setResourceDownloadCount(Integer resourceDownloadCount) {
        this.resourceDownloadCount = resourceDownloadCount;
    }

    @Basic
    @Column(name = "resource_like_count")
    public Integer getResourceLikeCount() {
        return resourceLikeCount;
    }

    public void setResourceLikeCount(Integer resourceLikeCount) {
        this.resourceLikeCount = resourceLikeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceInfoEntity entity = (ResourceInfoEntity) o;

        if (resourceId != null ? !resourceId.equals(entity.resourceId) : entity.resourceId != null) return false;
        if (resourceUploadTime != null ? !resourceUploadTime.equals(entity.resourceUploadTime) : entity.resourceUploadTime != null)
            return false;
        if (resourceUrl != null ? !resourceUrl.equals(entity.resourceUrl) : entity.resourceUrl != null) return false;
        if (resourceName != null ? !resourceName.equals(entity.resourceName) : entity.resourceName != null)
            return false;
        if (resourceDownloadCount != null ? !resourceDownloadCount.equals(entity.resourceDownloadCount) : entity.resourceDownloadCount != null)
            return false;
        if (resourceLikeCount != null ? !resourceLikeCount.equals(entity.resourceLikeCount) : entity.resourceLikeCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = resourceId != null ? resourceId.hashCode() : 0;
        result = 31 * result + (resourceUrl != null ? resourceUrl.hashCode() : 0);
        result = 31 * result + (resourceName != null ? resourceName.hashCode() : 0);
        result = 31 * result + (resourceDownloadCount != null ? resourceDownloadCount.hashCode() : 0);
        result = 31 * result + (resourceLikeCount != null ? resourceLikeCount.hashCode() : 0);
        result = 31 * result + (resourceUploadTime != null ? resourceUploadTime.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "resource_save_path")
    public String getResourceSavePath() {
        return resourceSavePath;
    }

    public void setResourceSavePath(String resourceSavePath) {
        this.resourceSavePath = resourceSavePath;
    }
}
