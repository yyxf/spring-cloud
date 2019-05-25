package com.pxz.consumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.pxz.consumer.model.User;
import com.pxz.consumer.model.response.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * TODO
 *
 * @ClassName TempController
 * @Package com.pxz.consumer.controller
 * @Author 潘形忠
 * @Date 2019/5/20 12:52
 */
@RestController
public class TempController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 测eureka
     */
    @Autowired
    private EurekaClient eurekaClient;

    @Value("${user.url}")
    private String url;
    //private String url = "http://localhost:8002/user/";

    @GetMapping("/order/{id}")
    public User getUser(@PathVariable Long id) {
        final User us = restTemplate.getForObject(url + id, User.class);
        return us;
    }

    //String url1 = "http://localhost:8080/results/scores1/190429102914834/90966595724200/dev";

    @GetMapping("/scores1/{examId}/{usid}/{alias}")
    public ResponseBean getExamineeScore(@PathVariable String examId, @PathVariable String usid, @PathVariable String alias) {
        String url1 = "http://localhost:8080/results/scores1/";
        System.out.println("examId = [" + examId + "], usid = [" + usid + "], alias = [" + alias + "]");
        return restTemplate.getForObject(url1 + examId + "/" + usid + "/" + alias, ResponseBean.class);
    }


    // test http://localhost:8001/scores2/190429102914834/90966595724200/dev
    @GetMapping("/scores2/{examId}/{usid}/{alias}")
    public ResponseBean getExamineeScore1(@PathVariable String examId, @PathVariable String usid, @PathVariable String alias) {
        final InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("ANALYSIS", false);
        System.out.println("nextServerFromEureka = " + nextServerFromEureka);
        final String analysisUrl = nextServerFromEureka.getHomePageUrl();
        return restTemplate.getForObject(analysisUrl + "/results/scores1/"
                + examId + "/" + usid + "/" + alias, ResponseBean.class);
    }


    @GetMapping("/eurekaInfo")
    public String eurekaInfo() {
        final InstanceInfo consumer1 = eurekaClient.getNextServerFromEureka("CONSUMER", false);
        return consumer1.getHomePageUrl();
    }

}
