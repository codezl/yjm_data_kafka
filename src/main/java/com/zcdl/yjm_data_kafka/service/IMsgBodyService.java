package com.zcdl.yjm_data_kafka.service;

import com.zcdl.yjm_data_kafka.model.MsgBody;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-04-17
 */
public interface IMsgBodyService extends IService<MsgBody> {

    void handleMsg(String msg);

    void handleMsgAndForward(String msg);
}
