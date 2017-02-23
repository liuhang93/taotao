package com.taotao.common.pojo;

import java.util.List;

/**
 * Created by liuhang on 2017/2/23.
 * EasyUI DataGrid的返回值类型
 */
public class EasyUIDataGridResult {
    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public EasyUIDataGridResult(long total, List<?> rows) {

        this.total = total;
        this.rows = rows;
    }
}
