package com.wangh.community_root.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wangh.community_root.utils.UUIdGenId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "ums_user")
public class UmsUser implements Serializable {
    private static final long serialVersionUID = -5051120337175047163L;

    @Id
    @KeySql(genId = UUIdGenId.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "jdbc")
    private String id;

    private String username;

    private String alias;

    @JsonIgnore()
    private String password;

    @Builder.Default
    private String avatar = "https://s3.ax1x.com/2020/12/01/DfHNo4.jpg";

    private String email;

    private String mobile;

    @Builder.Default
    private String bio = "自由职业者";

    @Builder.Default
    private Integer score = 0;

    @JsonIgnore
    private String token;

    @Builder.Default
    private Boolean active = true;

    /**
     * 状态。1:使用，0:已停用
     */
    @Builder.Default
    private Boolean status = true;

    /**
     * 用户角色
     */
    private Integer roleId;

    private Date createTime;

    private Date modifyTime;
}
