package kr.co.direa.nginxapi.vo;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class OpenPort {

    String ip;

    int port;
}
