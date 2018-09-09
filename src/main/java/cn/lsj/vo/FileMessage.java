package cn.lsj.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Lushunjian
 * @Date: 2018/9/8 21:09
 * @Description:   文件上传请求报文解析bean
 */
public class FileMessage {

    private String contentType;
    private String acceptEncoding;
    private long fileLength;
    private int fileBlockSize;
    private String fileName;
    private String fileNameMD5;
    private String paramBoundary;
    private Map<String,String> param = new HashMap<>();

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public long getFileLength() {
        return fileLength;
    }

    public void setFileLength(long fileLength) {
        this.fileLength = fileLength;
    }

    public int getFileBlockSize() {
        return fileBlockSize;
    }

    public void setFileBlockSize(int fileBlockSize) {
        this.fileBlockSize = fileBlockSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getParamBoundary() {
        return paramBoundary;
    }

    public void setParamBoundary(String paramBoundary) {
        this.paramBoundary = paramBoundary;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }

    public String getFileNameMD5() {
        return fileNameMD5;
    }

    public void setFileNameMD5(String fileNameMD5) {
        this.fileNameMD5 = fileNameMD5;
    }
}