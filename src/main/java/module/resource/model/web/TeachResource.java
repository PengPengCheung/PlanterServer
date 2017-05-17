package module.resource.model.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.BaseViewModel;
import common.Resource;

/**
 * Created by peng on 2017/4/14.
 */
public class TeachResource extends BaseViewModel {

    @JsonProperty(Resource.KEY.KEY_RESOURCE_NAME)
    private String resourceName;

    @JsonProperty(Resource.KEY.KEY_RESOURCE_UPLOAD_DATE)
    private String uploadDate;


    @JsonProperty(Resource.KEY.KEY_RESOURCE_DOWNLOAD_COUNT)
    private int downloadCount;

    @JsonProperty(Resource.KEY.KEY_RESOURCE_LIKE_COUNT)
    private int likeCount;

    @JsonProperty(Resource.KEY.KEY_RESOURCE_DOWNLOAD_URL)
    private String downloadUrl;

    @JsonProperty(Resource.KEY.KEY_RESOURCE_ID)
    private String resourceId;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
