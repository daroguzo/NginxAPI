package kr.co.direa.nginxapi.controller;

import kr.co.direa.nginxapi.service.NginxService;
import kr.co.direa.nginxapi.vo.MonitoringStatus;
import kr.co.direa.nginxapi.vo.NginxStatus;
import kr.co.direa.nginxapi.vo.NodeInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/nginx/api", produces =  "application/json; charset=utf8")
public class NginxRestController {

    private final Logger log = LoggerFactory.getLogger(NginxRestController.class);

    private final NginxService nginxService;

    @Autowired
    public NginxRestController(NginxService nginxService) {
        this.nginxService = nginxService;
    }

    @GetMapping("/start")
    public NginxStatus start() {
        return nginxService.start();
    }

    @GetMapping("/stop")
    public NginxStatus stop() {
        return nginxService.stop();
    }

    @GetMapping("/reload")
    public NginxStatus reload() {
        return nginxService.reload();
    }

    @GetMapping("/status")
    public MonitoringStatus status() {
        return nginxService.status();
    }

    @GetMapping("/monitoring")
    public NodeInfo monitoring() {
        return nginxService.getNodeInfo();
    }

    @PostMapping("/cmd")
    public String postCmd(@RequestBody String cmd) {
        String result = nginxService.postCmd(cmd);
        log.debug(result);
        return result;
    }

}
