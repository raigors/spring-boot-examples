package com.github.spring.boot.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * TODO
 * <p>
 * create in 2021/3/9 7:06 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户基本信息")
public class UserInfoDTO {

    @ApiModelProperty("姓名")
    @Size(max = 20)
    private String name;

    @ApiModelProperty("年龄")
    @Max(150)
    @Min(1)
    private Integer age;

    @NotNull
    private String address;

    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
    private String email;

}
