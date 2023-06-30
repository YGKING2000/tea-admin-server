package com.example.tea.admin.server.content.pojo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/** 
 * 类别完整"树"结构节点项的VO类
 * @author YGKING e-mail:hrd18960706057@163.com
 * @version 0.0.1
 * @date 2023/06/28 09:43
 */
@Data
@Accessors(chain = true)
public class CategoryTreeItemVO {
    /**
     * 数据id，Element UI控件要求名为value
     */
    private Long value;
    /**
     * 类别名称，Element UI控件要求名为label
     */
    private String label;
    /**
     * 子级类别列表，Element UI控件要求名为children
     */
    private List<CategoryTreeItemVO> children;
}
