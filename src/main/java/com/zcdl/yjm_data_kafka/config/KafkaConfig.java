package com.zcdl.yjm_data_kafka.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zcdl.yjm_data_kafka.model.People;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

import java.lang.reflect.Field;
import java.util.Set;

@Configuration
@Slf4j
public class KafkaConfig {

    @Bean
    public KafkaListenerContainerFactory<?> batchFactory(ConsumerFactory consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setConcurrency(6);
        factory.getContainerProperties().setPollTimeout(1500);
        factory.setBatchListener(true);//设置为批量消费，每个批次数量在Kafka配置参数中设置
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);//设置手动提交ackMode
        return factory;
    }


    public static void main(String[] args) {
//        String aa = "{\"msg\":\"{\\\"csrq\\\":\\\"20170423\\\",\\\"cyzjdm\\\":\\\"111\\\",\\\"djrSflbdm\\\":\\\"16\\\",\\\"djrXm\\\":\\\"邓惠香\\\",\\\"djrZjhm\\\":\\\"441522199112281804\\\",\\\"djsj\\\":\\\"20220414143758\\\",\\\"dzzdjlxdm\\\":\\\"9\\\",\\\"gjhdqdm\\\":\\\"CHN\\\",\\\"gxrlbdm\\\":\\\"130\\\",\\\"gxsj\\\":\\\"20220414143758\\\",\\\"jcjzdbs\\\":\\\"0\\\",\\\"jzdzCxfldm\\\":\\\"121\\\",\\\"jzdzDzbm\\\":\\\"8E5DF293-B91F-4308-9875-FAA97804DA79\\\",\\\"jzdzDzmc\\\":\\\"广东省惠东县吉隆镇吉城社区鞋城大道明泰路五巷8号\\\",\\\"jzdzSqcjdm\\\":\\\"441323109003000\\\",\\\"jzdzSsjwqdm\\\":\\\"441323600002\\\",\\\"jzdzSsxqdm\\\":\\\"441323\\\",\\\"jznxjsQsrq\\\":\\\"20220414\\\",\\\"lxdh\\\":\\\"13509065362\\\",\\\"mzdm\\\":\\\"01\\\",\\\"qlrrq\\\":\\\"20220414\\\",\\\"qsbs\\\":\\\"1\\\",\\\"rhyzbs\\\":\\\"3\\\",\\\"rkbm\\\":\\\"1514493145335726080b\\\",\\\"rksj\\\":\\\"20220414143758\\\",\\\"sjgsdwdm\\\":\\\"441323600002\\\",\\\"sjgsdwmc\\\":\\\"441323600002\\\",\\\"sjly\\\":\\\"yjm\\\",\\\"sjztbs\\\":\\\"2\\\",\\\"smrzbs\\\":\\\"0\\\",\\\"start\\\":0,\\\"tbgxsj\\\":\\\"20220414143758\\\",\\\"xbdm\\\":\\\"2\\\",\\\"xm\\\":\\\"王汐\\\",\\\"zaxxhjlydm\\\":\\\"4\\\",\\\"zhlbdm\\\":\\\"1\\\",\\\"zhqrbs\\\":\\\"1\\\",\\\"zjhm\\\":\\\"441521201704234423\\\",\\\"zzlxdm\\\":\\\"3\\\"}\",\"regionCode\":\"441323600002\",\"type\":\"01001\"}";
//        String aa = "{\"msg\":\"{\\\"cyzjdm\\\":\\\"111\\\",\\\"djrSflbdm\\\":\\\"10\\\",\\\"djrXm\\\":\\\"黎伟标\\\",\\\"djrZjhm\\\":\\\"441521197505101119\\\",\\\"djsj\\\":\\\"20220414143802\\\",\\\"gjhdqdm\\\":\\\"CHN\\\",\\\"qlcrq\\\":\\\"20220414\\\",\\\"rkbm\\\":\\\"00000000000397668932\\\",\\\"rksj\\\":\\\"20220414143802\\\",\\\"sjgsdwdm\\\":\\\"441381720001\\\",\\\"sjgsdwmc\\\":\\\"441381720001\\\",\\\"sjly\\\":\\\"yjm\\\",\\\"start\\\":0,\\\"tbgxsj\\\":\\\"20220414143802\\\",\\\"xm\\\":\\\"黎伟标\\\",\\\"ywlsh\\\":\\\"1514493161794174976p\\\",\\\"zjhm\\\":\\\"441521197505101119\\\",\\\"zxlbdm\\\":\\\"2\\\"}\",\"regionCode\":\"441381720001\",\"type\":\"01011\"}";
//        String aa = "{\"msg\":\"{\\\"csrq\\\":\\\"19851225\\\",\\\"cyzjdm\\\":\\\"111\\\",\\\"djrSflbdm\\\":\\\"11\\\",\\\"djrXm\\\":\\\"张可新\\\",\\\"djrZjhm\\\":\\\"230405198512250314\\\",\\\"djsj\\\":\\\"20220414151536\\\",\\\"dzzdjlxdm\\\":\\\"9\\\",\\\"gjhdqdm\\\":\\\"CHN\\\",\\\"gxsj\\\":\\\"20220414151536\\\",\\\"jcjzdbs\\\":\\\"0\\\",\\\"jzdzDzbm\\\":\\\"982FE8C2-38BC-45CD-B292-ABD24E97D9F7\\\",\\\"jzdzDzmc\\\":\\\"广东省惠州市惠阳区淡水街道爱民中路建业华府1栋\\\",\\\"jzdzSqcjdm\\\":\\\"441303001010000\\\",\\\"jzdzSsjwqdm\\\":\\\"441381640001\\\",\\\"jzdzSsxqdm\\\":\\\"441303\\\",\\\"jznxjsQsrq\\\":\\\"20220414\\\",\\\"lxdh\\\":\\\"15815439550\\\",\\\"rhyzbs\\\":\\\"1\\\",\\\"rkbm\\\":\\\"1514502614547431424h\\\",\\\"rksj\\\":\\\"20220414151536\\\",\\\"sjgsdwdm\\\":\\\"441381640001\\\",\\\"sjgsdwmc\\\":\\\"441381640001\\\",\\\"sjly\\\":\\\"yjm\\\",\\\"sjztbs\\\":\\\"1\\\",\\\"smrzbs\\\":\\\"1\\\",\\\"start\\\":0,\\\"tbgxsj\\\":\\\"20220414151536\\\",\\\"xbdm\\\":\\\"1\\\",\\\"xm\\\":\\\"张可新\\\",\\\"zaxxhjlydm\\\":\\\"4\\\",\\\"zhqrbs\\\":\\\"0\\\",\\\"zjhm\\\":\\\"230405198512250314\\\",\\\"zzlxdm\\\":\\\"12\\\"}\",\"regionCode\":\"441381640001\",\"type\":\"01001\"}";
//        String aa = "{\"msg\":\"{\\\"cyzjdm\\\":\\\"111\\\",\\\"djrSflbdm\\\":\\\"10\\\",\\\"djrXm\\\":\\\"严香香\\\",\\\"djrZjhm\\\":\\\"362132198303168529\\\",\\\"djsj\\\":\\\"20220414112925\\\",\\\"gjhdqdm\\\":\\\"CHN\\\",\\\"qlcrq\\\":\\\"20220414\\\",\\\"rkbm\\\":\\\"00000000000373884327\\\",\\\"rksj\\\":\\\"20220414112925\\\",\\\"sjgsdwdm\\\":\\\"441399510003\\\",\\\"sjgsdwmc\\\":\\\"441399510003\\\",\\\"sjly\\\":\\\"yjm\\\",\\\"start\\\":0,\\\"tbgxsj\\\":\\\"20220414112925\\\",\\\"xm\\\":\\\"严香香\\\",\\\"ywlsh\\\":\\\"1514445697456275456c\\\",\\\"zjhm\\\":\\\"362132198303168529\\\",\\\"zxlbdm\\\":\\\"2\\\"}\",\"regionCode\":\"441399510003\",\"type\":\"01011\"}";
        String aa = "{\"msg\":\"{\\\"cyzjdm\\\":\\\"111\\\",\\\"djrSflbdm\\\":\\\"10\\\",\\\"djrXm\\\":\\\"罗孝能\\\",\\\"djrZjhm\\\":\\\"441521199408096513\\\",\\\"djsj\\\":\\\"20220414120828\\\",\\\"gjhdqdm\\\":\\\"CHN\\\",\\\"qlcrq\\\":\\\"20220414\\\",\\\"rkbm\\\":\\\"00000000000401352651\\\",\\\"rksj\\\":\\\"20220414120828\\\",\\\"sjgsdwdm\\\":\\\"441330230001\\\",\\\"sjgsdwmc\\\":\\\"441330230001\\\",\\\"sjly\\\":\\\"yjm\\\",\\\"start\\\":0,\\\"tbgxsj\\\":\\\"20220414120828\\\",\\\"xm\\\":\\\"罗孝能\\\",\\\"ywlsh\\\":\\\"1514455523666165760b\\\",\\\"zjhm\\\":\\\"441521199408096513\\\",\\\"zxlbdm\\\":\\\"2\\\"}\",\"regionCode\":\"441330230001\",\"type\":\"01011\"}";
        JSONObject jsonObject = JSON.parseObject(aa).getJSONObject("msg");
        System.out.println(jsonObject);
        People jsonToModel = (People) jsonToModel(jsonObject.toJSONString(), new People());
        System.out.println(jsonToModel);
    }

    public static Object jsonToModel(String jsonString, Object classA) {
        try {
            JSONObject json = JSON.parseObject(jsonString);
            Set<String> setList = json.keySet();
            for (String data : setList) {
                Field value = null;
                try {
                    value = classA.getClass().getDeclaredField(data);//在目标类中查看是否有相同名称的属性
                    value.setAccessible(true);
                    value.set(classA, json.get(data)); //把属性值赋予给目标类对应属性
                }catch (Exception e){

                }
            }
            return classA;
        } catch (Exception e) {
            System.out.println("转化异常！");
            return null;
        }
    }
}
