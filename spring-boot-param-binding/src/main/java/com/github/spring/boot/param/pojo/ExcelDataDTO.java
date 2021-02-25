package com.github.spring.boot.param.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * TODO
 * <p>
 * create in 2021/2/19 3:50 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
public class ExcelDataDTO {

    @ExcelProperty("标题")
    private String title;

    @ExcelProperty("数据")
    private String data;

    @ExcelProperty("序号")
    private Integer index;

}
