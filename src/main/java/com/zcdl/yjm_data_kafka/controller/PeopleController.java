package com.zcdl.yjm_data_kafka.controller;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcdl.yjm_data_kafka.dto.BuildingDTO;
import com.zcdl.yjm_data_kafka.dto.PeopleDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.dto.StandardDTO;
import com.zcdl.yjm_data_kafka.helper.StandardHelper;
import com.zcdl.yjm_data_kafka.model.BuildingCheck;
import com.zcdl.yjm_data_kafka.model.People;
import com.zcdl.yjm_data_kafka.service.impl.HouseLogoutServiceImpl;
import com.zcdl.yjm_data_kafka.service.impl.MsgBodyServiceImpl;
import com.zcdl.yjm_data_kafka.service.impl.PeopleLogoutServiceImpl;
import com.zcdl.yjm_data_kafka.service.impl.PeopleServiceImpl;

import com.zcdl.yjm_data_kafka.utils.CommonUtils;
import com.zcdl.yjm_data_kafka.utils.SaveMsgUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.xml.transform.Result;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 实有人口-住址信息 前端控制器
 * </p>
 *
 * @author
 * @since 2022-04-16
 */
@RestController
@RequestMapping("/people")
@Api(tags = "60.人员管理", position = 60)
public class PeopleController {

    @Resource
    private SaveMsgUtils saveMsgUtils;
    @Resource
    private PeopleServiceImpl peopleService;
    @Resource
    private MsgBodyServiceImpl msgBodyService;
    @Resource
    private StandardHelper standardHelper;
    @Resource
    private PeopleLogoutServiceImpl peopleLogoutService;

    @ApiOperation(position = 10, value = "人员列表")
    @PostMapping("/getPeoples")
    public ResultDTO getPeoples(@RequestBody @Valid PeopleDTO.getPeoples dto) {
        return peopleService.getPeoples(dto);
    }
//
//    @ApiOperation(position = 20, value = "人员数量")
//    @PostMapping("/getPeoplesNum")
//    public ResultDTO getPeoplesNum(@RequestBody @Valid PeopleDTO.getPeoplesNum dto) {
//        return peopleService.getPeoplesNum(dto);
//    }


    @ApiOperation(position = 10, value = "人员注销列表(村居/警务)")
    @PostMapping("/getPeopleLogoutBycjORpl")
    public ResultDTO getPeopleLogoutBycjORpl(@RequestBody @Valid PeopleDTO.getPeoplesBycjORpl dto) {
        String ssjwqdm = dto.getSsjwqdm();
        String jzdzSqcjdm = dto.getJzdzSqcjdm();

        if (StrUtil.isBlank(ssjwqdm) && StrUtil.isBlank(jzdzSqcjdm))return ResultDTO.error_msg(50242, "警务编号和村居编号必须有一个");

        List<Map<String, Object>> list = new ArrayList<>();
        // 村居
        if (StrUtil.isNotBlank(jzdzSqcjdm)){
            StandardDTO.areaADto a = new StandardDTO.areaADto().setAreaDm(dto.getJzdzSqcjdm()).setType(dto.getType());
            JSONObject jsonObject = standardHelper.getType(a);
            if (jsonObject.getInteger("status") == 200) {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (Object o : jsonArray) {
                    JSONObject json = (JSONObject) JSONObject.toJSON(o);
                    Map<String, Object> map = CommonUtils.putCJMap(json);

                    QueryWrapper wrapper = new QueryWrapper<>()
                            .likeRight(!StringUtils.isEmpty(json.getString("dm")), "jzdz_sqcjdm", json.getString("dm"))
                            .like(!StringUtils.isEmpty(dto.getRkbm()), "rkbm", dto.getRkbm());
                    List l = peopleLogoutService.list(wrapper);

                    map.put("peopleLogoutList", l);
                    map.put("count",l.size());
                    list.add(map);
                }
                return ResultDTO.ok_data(list);
            }
        }else {
            // 警务
            StandardDTO.areaDto a = new StandardDTO.areaDto().setArea(dto.getSsjwqdm()).setType(dto.getType());
            JSONObject jsonObject = standardHelper.policeArea(a);
            if (jsonObject.getInteger("status") == 200) {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (Object o : jsonArray) {
                    JSONObject json = (JSONObject) JSONObject.toJSON(o);
                    Map<String, Object> map = CommonUtils.putJWMap(json);

                    QueryWrapper wrapper = new QueryWrapper<>()
                            .likeRight(!StringUtils.isEmpty(json.getString("id")), "jzdz_ssjwqdm",
                                    json.getString("id").replaceAll("0+$", ""))
                            .like(!StringUtils.isEmpty(dto.getRkbm()), "rkbm", dto.getRkbm());

                    List l = peopleLogoutService.list(wrapper);
                    map.put("peopleLogoutList", l);
                    map.put("count",l.size());
                    list.add(map);
                }
                return ResultDTO.ok_data(list);
            }
        }
        return ResultDTO.error_msg(50241, "查询失败");
    }




    @ApiOperation(position = 10, value = "人员列表(村居/警务)")
    @PostMapping("/getPeoplesBycjORpl")
    public ResultDTO getPeoplesBycjORpl(@RequestBody @Valid PeopleDTO.getPeoplesBycjORpl dto) {
        String ssjwqdm = dto.getSsjwqdm();
        String jzdzSqcjdm = dto.getJzdzSqcjdm();

        if (StrUtil.isBlank(ssjwqdm) && StrUtil.isBlank(jzdzSqcjdm))return ResultDTO.error_msg(50242, "警务编号和村居编号必须有一个");

        List<Map<String, Object>> list = new ArrayList<>();
        // 村居
        if (StrUtil.isNotBlank(jzdzSqcjdm)){
            StandardDTO.areaADto a = new StandardDTO.areaADto().setAreaDm(dto.getJzdzSqcjdm()).setType(dto.getType());
            JSONObject jsonObject = standardHelper.getType(a);
            if (jsonObject.getInteger("status") == 200) {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (Object o : jsonArray) {
                    JSONObject json = (JSONObject) JSONObject.toJSON(o);
                    Map<String, Object> map = CommonUtils.putCJMap(json);

                    QueryWrapper wrapper = new QueryWrapper<>()
                            .likeRight(!StringUtils.isEmpty(json.getString("dm")), "jzdz_sqcjdm", json.getString("dm"))
                            .like(!StringUtils.isEmpty(dto.getRkbm()), "rkbm", dto.getRkbm());
                    List l = peopleService.list(wrapper);

                    map.put("PeopleLogoutList", l);
                    map.put("count",l.size());
                    list.add(map);
                }
                return ResultDTO.ok_data(list);
            }
        }else {
            // 警务
            StandardDTO.areaDto a = new StandardDTO.areaDto().setArea(dto.getSsjwqdm()).setType(dto.getType());
            JSONObject jsonObject = standardHelper.policeArea(a);
            if (jsonObject.getInteger("status") == 200) {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (Object o : jsonArray) {
                    JSONObject json = (JSONObject) JSONObject.toJSON(o);
                    Map<String, Object> map = CommonUtils.putJWMap(json);

                    QueryWrapper wrapper = new QueryWrapper<>()
                            .likeRight(!StringUtils.isEmpty(json.getString("id")), "jzdz_ssjwqdm",
                                    json.getString("id").replaceAll("0+$", ""))
                            .like(!StringUtils.isEmpty(dto.getRkbm()), "rkbm", dto.getRkbm());

                    List l = peopleService.list(wrapper);
                    map.put("peopleList", l);
                    map.put("count",l.size());
                    list.add(map);
                }
                return ResultDTO.ok_data(list);
            }
        }
        return ResultDTO.error_msg(50241, "查询失败");
    }






    //@GetMapping("/t")
    @Transactional
    public void a() {
        try (FileInputStream file = new FileInputStream(new File("C:\\Users\\mata\\Desktop\\yjm.log"))) {

            InputStreamReader reader = new InputStreamReader(file, "UTF-8");

            BufferedReader br = new BufferedReader(reader);

//            int read = 0;
//            byte[] b = new byte[1024];
//
//            while ((read = file.read(b)) != -1) {
//                sb.append(new String(b, 0, read));
//            }

            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            JSONArray array = JSONArray.parseArray(sb.toString());


            for (Object o : array) {
                msgBodyService.handleMsg(o.toString(), null);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
