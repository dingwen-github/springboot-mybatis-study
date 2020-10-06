package com.dw.sms.controller;

import com.dw.sms.dto.StudentDTO;
import com.dw.sms.vo.RespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @program:
 * @description: Validation Controller
 * @author: dingwen
 * @create: 2020/10/6 12:45
 **/

/*
 1.分组
    @Validated：提供了一个分组功能，可以在入参验证时，根据不同的分组采用不同的验证机制。没有添加分组属性时，默认验证没有分组的验证属性。
2.注解地方
    @Validated：可以用在类型、方法和方法参数上。但是不能用在成员属性（字段）上
    @Valid：可以用在方法、构造函数、方法参数和成员属性（字段）上
    两者是否能用于成员属性（字段）上直接影响能否提供嵌套验证的功能。
3.嵌套验证
    由于@Validated不能用在成员属性（字段）上，但是@Valid能加在成员属性（字段）上. 所以在嵌套验证的场景中我们必须要用@Valid.

   4.普通模式（默认是这个模式）
    普通模式(会校验完所有的属性，然后返回所有的验证失败信息)

    5.快速失败返回模式
    快速失败返回模式(只要有一个验证失败，则返回)
 */
@RestController
@RequestMapping("/validation")
@Api("Bean Validation 使用")
//在类上使用validated配合valid对List进行校验
@Validated
public class ValidationController {

    /*
     *基础使用
     * @param [studentDTO]
     * @return com.dw.sms.vo.RespVO
     */
    @ApiOperation(value = "基础使用")
    @PostMapping("/studentDto")
    public RespVO studentDtoValidation(@RequestBody @Valid StudentDTO studentDTO) {
        return RespVO.ok("success");
    }

    /*
     *分组测试
     * 除了按组指定是否验证之外，还可以指定组的验证顺序，前面组验证不通过的，后面组不进行验证
     * @param [studentDTO]
     * @return com.dw.sms.vo.RespVO
     */
    @ApiOperation(value = "分组测试")
    @PostMapping("/group")
    public RespVO AgeGroup(@RequestBody @Validated({StudentDTO.Minors.class}) StudentDTO studentDTO) {
        return RespVO.ok("success");
    }

    /*
     *级联验证
     * 方法参数中的BindingResult bindingResult（因为这个参数已经没有用了，异常统一有controller返回了
     * @param [studentDTO, result]
     * @return java.lang.Object
     */
    @ApiOperation(value = "级联验证")
    @PostMapping("/valid")
    public RespVO result(@RequestBody List<@Valid StudentDTO> studentDTOList) {
        return RespVO.ok("success");
    }
}
