package com.yaozhou.domain.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserInfoVo {
    private Long id;
    //用户名
    private String userName;
    //邮箱
    private String email;
    //用户性别（0男，1女，2未知）
    private String sex;
    //用户类型：0代表普通用户，1代表管理员
    private String type;
    //头像
    private String avatar;
}
