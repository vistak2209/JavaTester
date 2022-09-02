package org.example.annotations.field;



public class BuildTagDTO {
    public Long tagId;
    @HttpParameters(name="artifactId")
    public String componentName;
    @HttpParameters(name="componentVersion")
    public String version;
    @HttpParameters(name="checkout")
    public String tagCommitId;
    @HttpParameters(name="gitUrl")
    public String gitUrl;
    @HttpParameters(name="artifactFileName")
    public String artifactFileType;
    @HttpParameters(name="gradlewPath")
    public String gradlewPath;
    @HttpParameters(name="groupId")
    public String artifactGroupId;
    @HttpParameters(name="buildTask")
    public String buildTask;
    @HttpParameters(name="artifactFilePath")
    public String artifactFilePath;
    @HttpParameters(name="artifactFileName")
    public String artifactFileName;
    public String tagName;
    public String buildCommitId;
    public String jobName;
    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTagCommitId() {
        return tagCommitId;
    }

    public void setTagCommitId(String tagCommitId) {
        this.tagCommitId = tagCommitId;
    }

    public String getBuildCommitId() {
        return buildCommitId;
    }

    public void setBuildCommitId(String buildCommitId) {
        this.buildCommitId = buildCommitId;
    }

    public String getBuildTask() {
        return buildTask;
    }

    public void setBuildTask(String buildTask) {
        this.buildTask = buildTask;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getArtifactFilePath() {
        return artifactFilePath;
    }

    public void setArtifactFilePath(String artifactFilePath) {
        this.artifactFilePath = artifactFilePath;
    }

    public String getArtifactFileType() {
        return artifactFileType;
    }

    public void setArtifactFileType(String artifactFileType) {
        this.artifactFileType = artifactFileType;
    }

    public String getGradlewPath() {
        return gradlewPath;
    }

    public void setGradlewPath(String gradlewPath) {
        this.gradlewPath = gradlewPath;
    }

    public String getArtifactGroupId() {
        return artifactGroupId;
    }

    public void setArtifactGroupId(String artifactGroupId) {
        this.artifactGroupId = artifactGroupId;
    }

    public String getArtifactFileName() {
        return artifactFileName;
    }

    public void setArtifactFileName(String artifactFileName) {
        this.artifactFileName = artifactFileName;
    }

    @Override
    public String toString() {
        return "BuildTagDTO{" +
                "tagId=" + tagId +
                ", componentName='" + componentName + '\'' +
                ", tagName='" + tagName + '\'' +
                ", version='" + version + '\'' +
                ", tagCommitId='" + tagCommitId + '\'' +
                ", buildCommitId='" + buildCommitId + '\'' +
                ", buildTask='" + buildTask + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", jobName='" + jobName + '\'' +
                ", artifactFilePath='" + artifactFilePath + '\'' +
                ", artifactFileType='" + artifactFileType + '\'' +
                ", artifactFileName='" + artifactFileName + '\'' +
                ", gradlewPath='" + gradlewPath + '\'' +
                ", artifactGroupId='" + artifactGroupId + '\'' +
                '}';
    }
}
