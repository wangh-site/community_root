//package com.wangh.community_root.controller;
//
//
//import com.wangh.community_root.common.api.ApiResult;
//import com.wangh.community_root.common.exception.ApiAsserts;
//import com.wangh.community_root.model.entity.BmsFollow;
//import com.wangh.community_root.model.entity.UmsUser;
//import com.wangh.community_root.service.BmsFollowService;
//import com.wangh.community_root.service.UmsUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.HashMap;
//import java.util.Map;
//
//import static com.wangh.community_root.jwt.JwtUtil.USER_NAME;
//
//@RestController
//@RequestMapping("/relationship")
//public class BmsFollowController extends BaseController {
//
//    @Autowired
//    private BmsFollowService bmsFollowService;
//
//    @Autowired
//    private UmsUserService umsUserService;
//
//    @GetMapping("/subscribe/{userId}")
//    public ApiResult<Object> handleFollow(@RequestHeader(value = USER_NAME) String userName
//            , @PathVariable("userId") String parentId) {
//
//        bmsFollowService.handleFollow(userName,parentId);
//        return ApiResult.success(null, "关注成功");
//    }
//
//    @GetMapping("/unsubscribe/{userId}")
//    public ApiResult<Object> handleUnFollow(@RequestHeader(value = USER_NAME) String userName
//            , @PathVariable("userId") String parentId) {
//        UmsUser umsUser = umsUserService.getUserByUsername(userName);
//        BmsFollow one = bmsFollowService.getOne(
//                new LambdaQueryWrapper<BmsFollow>()
//                        .eq(BmsFollow::getParentId, parentId)
//                        .eq(BmsFollow::getFollowerId, umsUser.getId()));
//        if (ObjectUtils.isEmpty(one)) {
//            ApiAsserts.fail("未关注！");
//        }
//        bmsFollowService.remove(new LambdaQueryWrapper<BmsFollow>().eq(BmsFollow::getParentId, parentId)
//                .eq(BmsFollow::getFollowerId, umsUser.getId()));
//        return ApiResult.success(null, "取关成功");
//    }
//
//    @GetMapping("/validate/{topicUserId}")
//    public ApiResult<Map<String, Object>> isFollow(@RequestHeader(value = USER_NAME) String userName
//            , @PathVariable("topicUserId") String topicUserId) {
//        UmsUser umsUser = umsUserService.getUserByUsername(userName);
//        Map<String, Object> map = new HashMap<>(16);
//        map.put("hasFollow", false);
//        if (!ObjectUtils.isEmpty(umsUser)) {
//            BmsFollow one = bmsFollowService.getOne(new LambdaQueryWrapper<BmsFollow>()
//                    .eq(BmsFollow::getParentId, topicUserId)
//                    .eq(BmsFollow::getFollowerId, umsUser.getId()));
//            if (!ObjectUtils.isEmpty(one)) {
//                map.put("hasFollow", true);
//            }
//        }
//        return ApiResult.success(map);
//    }
//}
