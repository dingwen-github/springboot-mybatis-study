package com.dw.sms.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

/**
 * @program:
 * @description: 学生数据传输对象 Bean Validation 2.0 JSR303 基本使用
 * @author: dingwen
 * @create: 2020/10/6 12:18
 **/
@Data
//lombok 自动生成get、set方法
public class StudentDTO {

    //@Size
    // @NotEmpty
    //使用报错

    //未成年人年龄组
    public interface Minors {
    }

    //成年人年龄组
    public interface Audit {
    }

    @NotNull(message = "id不能为空")
    private Integer id;

    @NotNull(message = "name不能为空")
    @Length(max = 20, message = "name长度不能超出20")
    private String name;

    //"23"类型的数据也可以
    @NotNull(message = "age不能为空")
    @Range(min = 1, max = 17, message = "必须为未成年人", groups = Minors.class)
    @Range(min = 18, max = 150, message = "必须为未成年人", groups = Audit.class)
    private Integer age;

    @NotNull(message = "性别不能为空")
    @Range(max = 2, min = 1, message = "性别参数错误")
    private Integer gender;

    @Email(message = "电子邮箱格式错误")
    private String email;

    @NotNull(message = "身份证号码不能为空")
    //被注释的元素必须符合指定的正则表达式
    @Pattern(regexp = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$", message = "身份证号码不合法")
    private String idCard;

    //被注释的元素必须是一个过去的日期
    @Past(message = "无效的出生日期")
    private Date birthday;

    //被注释的元素必须是一个将来的日期
    @Future(message = "无效的毕业日期")
    private Date graduation;

    //验证字符串非null，且长度必须大于0
    @NotBlank(message = "班级不能为空")
    private String clazz;

    @Range(min = 0, max = 100, message = "成绩不合法")
    private Integer score;

    @AssertTrue(message = "ok")
    private Boolean isOk;

    @AssertFalse(message = "not")
    private Boolean isNot;

    @DecimalMax(message = "DecimalMax", value = "100")
    private String maxStr;

    @DecimalMin(value = "0", message = "DecimalMin")
    private String minStr;

    @Max(value = 1000, message = "Max")
    private Long max;

    @Min(value = 100, message = "Min")
    private Long min;

    @Null(message = "nul必须为空")
    private String nul;

    //数字的值超出了允许范围(只允许在2位整数和3位小数范围内
    //小数位数没有限制
    @Digits(integer = 2, fraction = 3)
    private Integer digits;

    @CheckCase(value = CaseMode.LOWER,message = "必须是小写")
    private String lower;

    Object json = "{\n" +
            "    \"id\":1  ,\n" +
            "    \"name\":\"dingwe\",\n" +
            "    \"age\":\"1\",\n" +
            "    \"gender\":2,\n" +
            "    \"email\":\"1981723769@qq.com\",\n" +
            "    \"idCard\": \"53012519970710221X\",\n" +
            "    \"birthday\":\"{{birthday}}\",\n" +
            "    \"graduation\":\"{{graduation}}\",\n" +
            "    \"clazz\": \"物联网工程\",\n" +
            "    \"score\": 100,\n" +
            "    \"isOk\": true,\n" +
            "    \"isNot\": \"false\",\n" +
            "    \"maxStr\": \"100\",\n" +
            "    \"max\": 600,\n" +
            "    \"min\": \"100\",\n" +
            "    \"nul\": null,\n" +
            "    \"digits\": 16.0099\n" +
            "\n" +
            "}";
}
