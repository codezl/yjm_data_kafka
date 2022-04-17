package com.zcdl.yjm_data_kafka.controller;


import com.alibaba.fastjson.JSONArray;
import com.zcdl.yjm_data_kafka.dto.PeopleDTO;
import com.zcdl.yjm_data_kafka.dto.ResultDTO;
import com.zcdl.yjm_data_kafka.service.impl.MsgBodyServiceImpl;
import com.zcdl.yjm_data_kafka.service.impl.PeopleServiceImpl;
import com.zcdl.yjm_data_kafka.utils.SaveMsgUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.io.*;

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


    @GetMapping("test")
    public String test() throws Exception {
        String aa = "{\"msg\":\"{\\\"cyzjdm\\\":\\\"111\\\",\\\"djrSflbdm\\\":\\\"10\\\",\\\"djrXm\\\":\\\"罗孝能\\\",\\\"djrZjhm\\\":\\\"441521199408096513\\\",\\\"djsj\\\":\\\"20220414120828\\\",\\\"gjhdqdm\\\":\\\"CHN\\\",\\\"qlcrq\\\":\\\"20220414\\\",\\\"rkbm\\\":\\\"00000000000401352651\\\",\\\"rksj\\\":\\\"20220414120828\\\",\\\"sjgsdwdm\\\":\\\"441330230001\\\",\\\"sjgsdwmc\\\":\\\"441330230001\\\",\\\"sjly\\\":\\\"yjm\\\",\\\"start\\\":0,\\\"tbgxsj\\\":\\\"20220414120828\\\",\\\"xm\\\":\\\"罗孝能\\\",\\\"ywlsh\\\":\\\"1514455523666165760b\\\",\\\"zjhm\\\":\\\"441521199408096513\\\",\\\"zxlbdm\\\":\\\"2\\\"}\",\"regionCode\":\"441330230001\",\"type\":\"01011\"}";
        String res = saveMsgUtils.savePeople(aa);
        return "okok";
    }

    @ApiOperation(position = 10, value = "人员列表")
    @PostMapping("/getPeoples")
    public ResultDTO getPeoples(PeopleDTO.getPeoples dto) {
        return peopleService.getPeoples(dto);
    }

    @ApiOperation(position = 10, value = "人员数量")
    @PostMapping("/getPeoplesNum")
    public ResultDTO getPeoplesNum(PeopleDTO.getPeoplesNum dto) {
        return peopleService.getPeoplesNum(dto);
    }

    @GetMapping("/t")
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

            while((line= br.readLine())!=null){
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
