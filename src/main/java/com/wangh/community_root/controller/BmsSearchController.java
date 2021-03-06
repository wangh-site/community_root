package com.wangh.community_root.controller;

import com.github.pagehelper.PageInfo;
import com.wangh.community_root.common.api.ApiResult;
import com.wangh.community_root.model.vo.PostVO;
import com.wangh.community_root.service.BmsPostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/search")
public class BmsSearchController extends BaseController {

    @Resource
    private BmsPostService postService;

    @GetMapping
    public ApiResult<PageInfo<PostVO>> searchList(@RequestParam("keyword") String keyword,
                                                  @RequestParam("pageNum") Integer pageNum,
                                                  @RequestParam("pageSize") Integer pageSize) {
        PageInfo<PostVO> results = postService.searchByKey(keyword, pageNum, pageSize );
        return ApiResult.success(results);
    }

}