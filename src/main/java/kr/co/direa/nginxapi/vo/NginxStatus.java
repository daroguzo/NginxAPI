package kr.co.direa.nginxapi.vo;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class NginxStatus {

    private boolean isRun;

    private String cmd;
}
