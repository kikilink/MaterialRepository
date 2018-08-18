package com.sequoia.common;

import java.io.Serializable;
import java.util.List;

public class PageResult<T extends Serializable> implements Serializable {

    private PageVO pageVO;

    private List<T> result;

    public PageVO getPageVO() {
        return pageVO;
    }

    public void setPageVO(PageVO pageVO) {
        this.pageVO = pageVO;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
